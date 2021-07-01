package com.falconworks.wbsedclapp.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falconworks.wbsedclapp.tech.entities.Feeder;
import com.falconworks.wbsedclapp.tech.services.FeederService;

@RestController
@RequestMapping("/tech")
public class WBSEDCLRestTechController {


	private FeederService feederService;

	@Autowired
	public WBSEDCLRestTechController(FeederService feederService) {
		this.feederService = feederService;
	}

	@GetMapping("/offices/{officeCode}/feeders")
	@PreAuthorize("@authorizationServiceImpl.hasPermission(#officeCode, authentication.principal.username)")
	public List<Feeder> findAllByOfficeCode(@PathVariable String officeCode) {
		if (!officeCode.endsWith("000")) {
			return feederService.findFeedersBySubStationOfficeCode(officeCode);
		} else {
			return feederService.findFeedersByDivisionOfficeCode(officeCode.substring(0, 4)+"%");
		}
	}

	@GetMapping("/offices/{officeCode}/feeders/{feederCode}")
	@PreAuthorize("@authorizationServiceImpl.hasPermission(#officeCode, authentication.principal.username)")
	public Feeder findFeederByFeederCode(@PathVariable String officeCode,@PathVariable String feederCode) {
		return feederService.findByFeederCode(feederCode);
	}

	@PostMapping("/offices/{officeCode}/feeders")
	@PreAuthorize("@authorizationServiceImpl.hasPermission(#officeCode, authentication.principal.username)")
	public void saveFeeder(@RequestBody Feeder feeder, @PathVariable String officeCode) {
		feederService.saveFeeder(feeder);
	}

	@PutMapping("/offices/{officeCode}/feeders")
	@PreAuthorize("@authorizationServiceImpl.hasPermission(#officeCode, authentication.principal.username)")
	public Feeder updateFeeder(@RequestBody Feeder feeder, @PathVariable String officeCode) {
		return feederService.updateFeeder(feeder);
	}

	@DeleteMapping("/offices/{officeCode}/feeders/{id}")
	@PreAuthorize("@authorizationServiceImpl.hasPermission(#officeCode, authentication.principal.username)")
	public void deleteById(@PathVariable int id, @PathVariable String officeCode) {
		feederService.deleteById(id);
	}
}
