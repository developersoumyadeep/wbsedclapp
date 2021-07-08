package com.falconworks.wbsedclapp.security.jwt.filters;

import com.falconworks.wbsedclapp.exceptions.ErrorResponse;
import com.falconworks.wbsedclapp.security.jwt.utils.JWTUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private UserDetailsService jwtUserDetailsService;
    private JWTUtil jwtUtil;

    @Autowired
    public JwtRequestFilter(@Qualifier("jwtUserDetailsServiceImpl") UserDetailsService jwtUserDetailsService, JWTUtil jwtUtil) {
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;
        System.out.println(requestTokenHeader);
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            System.out.println(jwtToken);
            try {
                username = jwtUtil.extractUsername(jwtToken);
                System.out.println("Extracted username from jwt:" + username);
                //Once we get the token, validate it
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
                    if (jwtUtil.isValidToken(jwtToken, userDetails)) {
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
                }
                filterChain.doFilter(request, response);
            } catch (IllegalArgumentException exc) {
                throw exc;
            } catch (ExpiredJwtException exc) {
                List<String> messages = new ArrayList<>();
                messages.add("JWT token expired");
                ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), messages, System.currentTimeMillis());
                ObjectMapper mapper = new ObjectMapper();
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.getWriter().write(mapper.writeValueAsString(errorResponse));
            }
        } else {
            filterChain.doFilter(request, response);
            logger.warn("JWT token is invalid");
        }
    }
}
