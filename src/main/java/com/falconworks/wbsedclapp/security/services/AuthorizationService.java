package com.falconworks.wbsedclapp.security.services;

public interface AuthorizationService {
	
	public boolean hasPermission(String officeCode, String username);

}
