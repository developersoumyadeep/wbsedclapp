package com.falconworks.wbsedclapp.admin.mappers;

import com.falconworks.wbsedclapp.admin.dto.requests.EmployeeRequestDTO;
import com.falconworks.wbsedclapp.admin.entities.Address;
import com.falconworks.wbsedclapp.admin.entities.Employee;
import com.falconworks.wbsedclapp.admin.entities.Office;
import com.falconworks.wbsedclapp.admin.services.EmployeeService;
import com.falconworks.wbsedclapp.admin.services.OfficeService;

public class EmployeeRequestDTOtoEmployeeEntityMapper {
    private OfficeService officeService;
    private EmployeeService employeeService;

    public EmployeeRequestDTOtoEmployeeEntityMapper(OfficeService officeService, EmployeeService employeeService) {
        this.officeService = officeService;
        this.employeeService = employeeService;
    }

    public Employee map(EmployeeRequestDTO employeeRequestDTO) {
        Office office = officeService.findByOfficeCode(employeeRequestDTO.getOfficeCode());
        Address address = new Address(employeeRequestDTO.getAddressLine1(), employeeRequestDTO.getAddressLine2(), employeeRequestDTO.getDistrict(), employeeRequestDTO.getPinCode());
        Employee employee = null;
        Employee existingEmployee = employeeService.getEmployeeByUsername(employeeRequestDTO.getUsername());
        //check if the requested dto is for an existing employee in the database
        //if the employee exists then the request is for editing the employee
        //the following checks will retrieve the existing employee with its id field populated to facilitate edit
        if (existingEmployee == null) {
            employee = new Employee();
            employee.setUsername(employeeRequestDTO.getUsername());
        } else {
            employee = existingEmployee;
        }
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
        employee.setOffice(office);
        return employee;
    }


}
