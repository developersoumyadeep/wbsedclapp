package com.falconworks.wbsedclapp.admin.mappers;

import com.falconworks.wbsedclapp.admin.dto.responses.EmployeeDetailedResponseDTO;
import com.falconworks.wbsedclapp.admin.entities.Employee;

public class EmployeeEntityToResponseDTOMapper {
    private EmployeeEntityToResponseDTOMapper() {

    }

    public static EmployeeDetailedResponseDTO map(Employee employee) {
        EmployeeDetailedResponseDTO dto = new EmployeeDetailedResponseDTO();
        dto.setUsername(employee.getUsername());
        dto.setMobile(employee.getMobile());
        dto.setEmail(employee.getEmail());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setDesignation(employee.getDesignation());
        dto.setEmployeeType(employee.getEmployeeType());
        dto.setJoiningDate(employee.getJoiningDate());
        dto.setRetirementDate(employee.getRetirementDate());
        dto.setOfficeCode(employee.getOffice().getOfficeCode());
        dto.setAddressLine1(employee.getAddress().getAddressLine1());
        dto.setAddressLine2(employee.getAddress().getAddressLine2());
        dto.setDistrict(employee.getAddress().getDistrict());
        dto.setPinCode(employee.getAddress().getPinCode());
        return dto;
    }
}
