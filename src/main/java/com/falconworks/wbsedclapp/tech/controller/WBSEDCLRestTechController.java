package com.falconworks.wbsedclapp.tech.controller;

import com.falconworks.wbsedclapp.admin.services.OfficeService;
import com.falconworks.wbsedclapp.tech.dto.FeederRequestDTO;
import com.falconworks.wbsedclapp.tech.dto.FeederResponseDTO;
import com.falconworks.wbsedclapp.tech.entities.Feeder;
import com.falconworks.wbsedclapp.tech.mappers.FeederEntityListToFeederResponseDTOListMapper;
import com.falconworks.wbsedclapp.tech.mappers.FeederEntityToFeederResponseDTOMapper;
import com.falconworks.wbsedclapp.tech.mappers.FeederRequestDTOtoFeederEntityMapper;
import com.falconworks.wbsedclapp.tech.services.FeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tech")
public class WBSEDCLRestTechController {

	private FeederService feederService;

	private OfficeService officeService;

	@Autowired
	public WBSEDCLRestTechController(FeederService feederService, OfficeService officeService) {
		this.feederService = feederService;
		this.officeService = officeService;
	}

	@GetMapping("/offices/{officeCode}/feeders")
	@PreAuthorize("@authorizationServiceImpl.hasPermission(#officeCode, authentication.principal.username,Authorization.USER)")
	public List<FeederResponseDTO> findAllByOfficeCode(@PathVariable String officeCode) {
		if (!officeCode.endsWith("000")) {
			return FeederEntityListToFeederResponseDTOListMapper.map(feederService.findFeedersBySubStationOfficeCode(officeCode));
		} else {
			return FeederEntityListToFeederResponseDTOListMapper.map(feederService.findFeedersByDivisionOfficeCode(officeCode.substring(0, 4)));
		}
	}

	@GetMapping("/offices/{officeCode}/feeders/{feederCode}")
	@PreAuthorize("@authorizationServiceImpl.hasPermission(#officeCode, authentication.principal.username,Authorization.USER)")
	public FeederResponseDTO findFeederByFeederCode(@PathVariable String officeCode,@PathVariable String feederCode) {
		return FeederEntityToFeederResponseDTOMapper.map(feederService.findByFeederCode(feederCode));
	}

	@PostMapping("/offices/{officeCode}/feeders")
	@PreAuthorize("@authorizationServiceImpl.hasPermission(#officeCode, authentication.principal.username,Authorization.SUPERVISOR)")
	public FeederResponseDTO saveFeeder(@Valid @RequestBody FeederRequestDTO dto, @PathVariable String officeCode) {
		Feeder feeder = new FeederRequestDTOtoFeederEntityMapper(officeService,feederService).map(dto);
		return FeederEntityToFeederResponseDTOMapper.map(feederService.saveFeeder(feeder));
	}

	@PutMapping("/offices/{officeCode}/feeders")
	@PreAuthorize("@authorizationServiceImpl.hasPermission(#officeCode, authentication.principal.username,Authorization.SUPERVISOR)")
	public FeederResponseDTO updateFeeder(@Valid @RequestBody FeederRequestDTO dto, @PathVariable String officeCode) {
		Feeder feeder = new FeederRequestDTOtoFeederEntityMapper(officeService,feederService).map(dto);
		return FeederEntityToFeederResponseDTOMapper.map(feederService.updateFeeder(feeder));
	}

	@DeleteMapping("/offices/{officeCode}/feeders/{id}")
	@PreAuthorize("@authorizationServiceImpl.hasPermission(#officeCode, authentication.principal.username,Authorization.SUPERVISOR)")
	public void deleteById(@PathVariable int id, @PathVariable String officeCode) {
		feederService.deleteById(id);
	}
}
