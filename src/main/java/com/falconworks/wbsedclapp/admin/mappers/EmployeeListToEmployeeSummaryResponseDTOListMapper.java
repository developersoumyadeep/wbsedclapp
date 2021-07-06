package com.falconworks.wbsedclapp.admin.mappers;

import com.falconworks.wbsedclapp.admin.dto.responses.EmployeeSummaryResponseDTO;
import com.falconworks.wbsedclapp.admin.entities.Employee;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class EmployeeListToEmployeeSummaryResponseDTOListMapper {

    private EmployeeListToEmployeeSummaryResponseDTOListMapper() {

    }

    public static List<EmployeeSummaryResponseDTO> map(List<Employee> employeeList) {
        return employeeList.stream().map(employee->mapEmployeeEntityToEmployeeSummaryResponseDTO(employee)).collect(toList());
    }

    private static EmployeeSummaryResponseDTO mapEmployeeEntityToEmployeeSummaryResponseDTO(Employee employee) {
        return new EmployeeSummaryResponseDTO(employee.getUsername(), employee.getFirstName(),
                employee.getLastName(), employee.getOffice().getOfficeCode());
    }
}
