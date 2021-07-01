package com.falconworks.wbsedclapp.admin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falconworks.wbsedclapp.admin.repositories.OfficeRepository;
import com.falconworks.wbsedclapp.admin.entities.Office;

@Service
public class OfficeServiceImpl implements OfficeService{

	private final OfficeRepository officeRepository;

	@Autowired
	public OfficeServiceImpl(OfficeRepository officeRepository) {
		this.officeRepository = officeRepository;
	}

	@Override
	public List<Office> findAll() {
		return officeRepository.findAll();
	}
	@Override
	public Office findById(int id) {
		return officeRepository.getById(id);
	}
	@Override
	public Office saveOffice(Office office) {
		return officeRepository.save(office);
	}
	@Override
	public Office updateOffice(Office office) {
		return officeRepository.save(office);
	}
	@Override
	public void deleteById(int id) {
		officeRepository.deleteById(id);
	}
	@Override
	public Office findByOfficeCode(String officeCode) {
		return officeRepository.findByOfficeCode(officeCode);
	}

}
