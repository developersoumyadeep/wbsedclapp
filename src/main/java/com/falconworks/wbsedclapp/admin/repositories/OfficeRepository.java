package com.falconworks.wbsedclapp.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.falconworks.wbsedclapp.admin.entities.Office;

public interface OfficeRepository extends JpaRepository<Office, Integer> {

	// @Query("from Office o where o.officeCode= :officeCode")
	public Office findByOfficeCode(String officeCode);
}
