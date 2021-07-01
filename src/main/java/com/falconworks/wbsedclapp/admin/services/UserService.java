package com.falconworks.wbsedclapp.admin.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.falconworks.wbsedclapp.admin.entities.User;

public interface UserService extends UserDetailsService {
	public List<User> findAll();
	public User findById(int id);
	public User getUserByUsername(String username);
}
