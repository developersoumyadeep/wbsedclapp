package com.falconworks.wbsedclapp.tech.mappers;

import com.falconworks.wbsedclapp.admin.entities.Office;
import com.falconworks.wbsedclapp.admin.services.OfficeService;
import com.falconworks.wbsedclapp.tech.dto.FeederRequestDTO;
import com.falconworks.wbsedclapp.tech.entities.Feeder;
import com.falconworks.wbsedclapp.tech.services.FeederService;


public class FeederRequestDTOtoFeederEntityMapper {

    private OfficeService officeService;
    private FeederService feederService;

    public FeederRequestDTOtoFeederEntityMapper(OfficeService officeService, FeederService feederService) {
        this.officeService = officeService;
        this.feederService = feederService;
    }

    public Feeder map(FeederRequestDTO dto) {
        Office substation = officeService.findByOfficeCode(dto.getSubstationOfficeCode());
        Feeder feeder = null;
        //check if the feeder request is for an existing feeder meaning the request is edit request
        //this will retrieve the feeder with the id field populated from the database
        Feeder existingFeeder = feederService.findByFeederCode(dto.getFeederCode());
        if ( existingFeeder == null) {
            feeder = new Feeder();
            feeder.setFeederCode(dto.getFeederCode());
        } else {
            feeder = existingFeeder;
        }
        feeder.setName(dto.getName());
        feeder.setVoltageGradekV(dto.getVoltageGradekV());
        feeder.setSubstation(substation);
        feeder.setMeterNo(dto.getMeterNo());
        feeder.setFromGSS(dto.isFromGSS());
        feeder.setIctr(dto.getIctr());
        return feeder;

    }
}
