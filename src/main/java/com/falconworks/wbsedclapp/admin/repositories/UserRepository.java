package com.falconworks.wbsedclapp.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.falconworks.wbsedclapp.admin.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	// @Query("from User u where u.username= :username")
	public User findByUsername(String username);
}
