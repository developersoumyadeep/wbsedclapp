package com.falconworks.wbsedclapp.admin.mappers;

import com.falconworks.wbsedclapp.admin.dto.responses.OfficeDetailedResponseDTO;
import com.falconworks.wbsedclapp.admin.entities.Office;

import java.util.ArrayList;
import java.util.List;

public class OfficeEntityToDetailedResponseDTOMapper {

    private OfficeEntityToDetailedResponseDTOMapper() {

    }

    public static OfficeDetailedResponseDTO map(Office office) {

        OfficeDetailedResponseDTO dto = new OfficeDetailedResponseDTO();
        dto.setId(office.getId());
        dto.setOfficeCode(office.getOfficeCode());
        dto.setOfficeLocation(office.getOfficeLocation());
        if (office.getParentOffice() != null) {
            dto.setParentOfficeCode(office.getParentOffice().getOfficeCode());
        } else {
            dto.setParentOfficeCode("");
        }
        if (office.getAddress().getAddressLine1() != null) {
            dto.setAddressLine1(office.getAddress().getAddressLine1());
        } else {
            dto.setAddressLine1("");
        }
        if (office.getAddress().getAddressLine2() != null) {
            dto.setAddressLine2(office.getAddress().getAddressLine2());
        } else {
            dto.setAddressLine2("");
        }

        dto.setDistrict(office.getAddress().getDistrict());
        dto.setPinCode(office.getAddress().getPinCode());
        dto.setEmployeeUsernames(getEmployeeUsernamesFromOfficeEntity(office));
        dto.setSubOfficeCodes(getSubOfficeCodesFromOfficeEntity(office));
        return dto;
    }

    private static List<String> getEmployeeUsernamesFromOfficeEntity(Office office) {
        List<String> empUsername = new ArrayList<>();
        if (!office.getEmployees().isEmpty()) {
            office.getEmployees().forEach(e -> empUsername.add(e.getUsername()));
        }
        return empUsername;
    }

    private static List<String> getSubOfficeCodesFromOfficeEntity(Office office) {
        List<String> officeCodes = new ArrayList<>();
        if (!office.getSubOffices().isEmpty()) {
            office.getSubOffices().forEach(o -> officeCodes.add(o.getOfficeCode()));
        }
        return officeCodes;
    }
}
