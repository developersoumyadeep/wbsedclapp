package com.falconworks.wbsedclapp.tech.mappers;

import com.falconworks.wbsedclapp.tech.dto.FeederResponseDTO;
import com.falconworks.wbsedclapp.tech.entities.Feeder;

public class FeederEntityToFeederResponseDTOMapper {
    private FeederEntityToFeederResponseDTOMapper() {
    }

    public static FeederResponseDTO map(Feeder feeder) {
        FeederResponseDTO dto = new FeederResponseDTO();
        dto.setId(feeder.getId());
        dto.setFeederCode(feeder.getFeederCode());
        dto.setName(feeder.getName());
        dto.setVoltageGradekV(feeder.getVoltageGradekV());
        dto.setSubstationOfficeCode(feeder.getSubstation().getOfficeCode());
        dto.setSubstationName(feeder.getSubstation().getOfficeLocation());
        dto.setFromGSS(feeder.isFromGSS());
        dto.setMeterNo(feeder.getMeterNo());
        dto.setIctr(feeder.getIctr());
        return dto;
    }
}
