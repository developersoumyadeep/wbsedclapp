package com.falconworks.wbsedclapp.tech.services;

import com.falconworks.wbsedclapp.tech.entities.Feeder;
import com.falconworks.wbsedclapp.tech.repositories.FeederRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeederServiceImpl implements FeederService {

	private FeederRepository feederRepository;

	@Autowired
	public FeederServiceImpl(FeederRepository feederRepository) {
		this.feederRepository = feederRepository;
	}

	@Override
	public List<Feeder> findAll() {
		return feederRepository.findAll();
	}

	@Override
	public Feeder findById(int id) {
		return feederRepository.getById(id);
	}

	@Override
	public Feeder saveFeeder(Feeder feeder) {
		return feederRepository.save(feeder);
	}

	@Override
	public Feeder updateFeeder(Feeder feeder) {
		return feederRepository.save(feeder);
	}

	@Override
	public void deleteById(int id) {
		feederRepository.deleteById(id);
	}

	@Override
	public Feeder findByFeederCode(String feederCode) {
		return feederRepository.findByFeederCode(feederCode);
	}

	@Override
	public List<Feeder> findFeedersBySubStationOfficeCode(String officeCode) {
		return feederRepository.findBySubstationOfficeCode(officeCode);
	}

	@Override
	public List<Feeder> findFeedersByDivisionOfficeCode(String officeCode) {
		return feederRepository.findBySubstationOfficeCodeStartingWith(officeCode);
	}

}
