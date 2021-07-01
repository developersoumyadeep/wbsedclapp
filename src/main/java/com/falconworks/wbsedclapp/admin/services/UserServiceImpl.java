package com.falconworks.wbsedclapp.admin.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.falconworks.wbsedclapp.admin.repositories.UserRepository;
import com.falconworks.wbsedclapp.admin.entities.User;

@Service
public class UserServiceImpl implements UserService {
	

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= userRepository.findByUsername(username);
		if (user != null && user.isEnabled()) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			for (String authorization : user.getAuthorizations()) {
				authorities.add(new SimpleGrantedAuthority(authorization));
			}
			return (UserDetails) new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
		} else {
			throw new UsernameNotFoundException("No user found with the username");
		}
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	} 
	

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	

}
