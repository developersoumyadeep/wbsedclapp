package com.falconworks.wbsedclapp.admin.mappers;

import com.falconworks.wbsedclapp.admin.dto.responses.OfficeSummaryResponseDTO;
import com.falconworks.wbsedclapp.admin.entities.Office;

import java.util.ArrayList;
import java.util.List;

public class OfficeEntityListToOfficeSummaryResponseDTOListMapper {
    public static List<OfficeSummaryResponseDTO> map(List<Office> officeList) {
        List<OfficeSummaryResponseDTO> list = new ArrayList<>();
        officeList.forEach(o->{list.add(OfficeEntityToOfficeSummaryResponseDTOMapper.map(o));});
        return list;
    }

    private static class OfficeEntityToOfficeSummaryResponseDTOMapper {
        public static OfficeSummaryResponseDTO map(Office office) {
            OfficeSummaryResponseDTO dto = new OfficeSummaryResponseDTO(office.getOfficeCode(), office.getOfficeLocation());
            office.getSubOffices().forEach(subOffice->dto.getSubOffices().add(new OfficeSummaryResponseDTO(subOffice.getOfficeCode(), subOffice.getOfficeLocation())));
            return dto;
        }
    }
}
