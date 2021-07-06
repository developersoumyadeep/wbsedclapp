package com.falconworks.wbsedclapp.admin.mappers;

import com.falconworks.wbsedclapp.admin.dto.requests.EmployeeRequestDTO;
import com.falconworks.wbsedclapp.admin.entities.Address;
import com.falconworks.wbsedclapp.admin.entities.Employee;
import com.falconworks.wbsedclapp.admin.entities.Office;
import com.falconworks.wbsedclapp.admin.services.OfficeService;
import com.falconworks.wbsedclapp.exceptions.OfficeNotFoundException;

public class EmployeeRequestDTOtoEmployeeEntityMapper {
    private OfficeService officeService;


    public EmployeeRequestDTOtoEmployeeEntityMapper(OfficeService officeService) {
        this.officeService = officeService;
    }

    public Employee map(EmployeeRequestDTO employeeRequestDTO) {
        Office office = officeService.findByOfficeCode(employeeRequestDTO.getOfficeCode());
        Address address = new Address(employeeRequestDTO.getAddressLine1(), employeeRequestDTO.getAddressLine2(), employeeRequestDTO.getDistrict(), employeeRequestDTO.getPinCode());
        Employee employee = new Employee();
        employee.setUsername(employeeRequestDTO.getUsername());
        employee.setPassword(employeeRequestDTO.getPassword());
        employee.setMobile(employeeRequestDTO.getMobile());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setFirstName(employeeRequestDTO.getFirstName());
        employee.setLastName(employeeRequestDTO.getLastName());
        employee.setAddress(address);
        employee.setDesignation(employeeRequestDTO.getDesignation());
        employee.setEmployeeType(employeeRequestDTO.getEmployeeType());
        employee.setJoiningDate(employeeRequestDTO.getJoiningDate());
        employee.setRetirementDate(employeeRequestDTO.getRetirementDate());
        employee.setAuthorizations(employeeRequestDTO.getAuthorizations());
        employee.setEnabled(employeeRequestDTO.isEnabled());
        if (office == null) {
            throw new OfficeNotFoundException("Invalid office code");
        }
        employee.setOffice(office);
        return employee;
    }


}
