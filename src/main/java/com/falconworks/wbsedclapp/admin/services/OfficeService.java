package com.falconworks.wbsedclapp.admin.services;

import java.util.List;

import com.falconworks.wbsedclapp.admin.entities.Office;

public interface OfficeService {
	public List<Office> findAll();
	public Office findById(int id);
	public Office saveOffice(Office office);
	public Office updateOffice(Office office);
	public void deleteById(int id);
	public Office findByOfficeCode(String officeCode); 
	
}
