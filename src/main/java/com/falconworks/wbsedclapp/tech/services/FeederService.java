package com.falconworks.wbsedclapp.tech.services;

import com.falconworks.wbsedclapp.tech.entities.Feeder;

import java.util.List;

public interface FeederService {
	public List<Feeder> findAll();
	public List<Feeder> findFeedersBySubStationOfficeCode(String officeCode);
	public Feeder findById(int id);
	public Feeder findByFeederCode(String feederCode);
	public Feeder saveFeeder(Feeder feeder);
	public Feeder updateFeeder(Feeder feeder);
	public void deleteById(int id);
	public List<Feeder> findFeedersByDivisionOfficeCode(String officeCode);
}
