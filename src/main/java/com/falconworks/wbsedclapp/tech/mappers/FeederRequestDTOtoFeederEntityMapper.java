package com.falconworks.wbsedclapp.tech.mappers;

import com.falconworks.wbsedclapp.admin.entities.Office;
import com.falconworks.wbsedclapp.admin.services.OfficeService;
import com.falconworks.wbsedclapp.tech.dto.FeederRequestDTO;
import com.falconworks.wbsedclapp.tech.entities.Feeder;


public class FeederRequestDTOtoFeederEntityMapper {

    private OfficeService officeService;

    public FeederRequestDTOtoFeederEntityMapper(OfficeService officeService) {
        this.officeService = officeService;
    }

    public Feeder map(FeederRequestDTO dto) {
        Office substation = officeService.findByOfficeCode(dto.getSubstationOfficeCode());
        Feeder feeder = new Feeder();
        feeder.setFeederCode(dto.getFeederCode());
        feeder.setName(dto.getName());
        feeder.setVoltageGradekV(dto.getVoltageGradekV());
        feeder.setSubstation(substation);
        feeder.setMeterNo(dto.getMeterNo());
        feeder.setFromGSS(dto.isFromGSS());
        feeder.setIctr(dto.getIctr());
        return feeder;
    }
}
