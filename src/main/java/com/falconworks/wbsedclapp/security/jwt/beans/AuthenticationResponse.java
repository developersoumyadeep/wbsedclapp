package com.falconworks.wbsedclapp.security.jwt.beans;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationResponse {
    private String jwt;

    public AuthenticationResponse() {
    }


    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }


    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
