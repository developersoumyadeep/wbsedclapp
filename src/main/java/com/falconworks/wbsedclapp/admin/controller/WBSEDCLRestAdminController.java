package com.falconworks.wbsedclapp.admin.controller;

import com.falconworks.wbsedclapp.admin.dto.requests.EmployeeRequestDTO;
import com.falconworks.wbsedclapp.admin.dto.requests.OfficeRequestDTO;
import com.falconworks.wbsedclapp.admin.dto.responses.EmployeeDetailedResponseDTO;
import com.falconworks.wbsedclapp.admin.dto.responses.EmployeeSummaryResponseDTO;
import com.falconworks.wbsedclapp.admin.dto.responses.OfficeDetailedResponseDTO;
import com.falconworks.wbsedclapp.admin.dto.responses.OfficeSummaryResponseDTO;
import com.falconworks.wbsedclapp.admin.entities.Employee;
import com.falconworks.wbsedclapp.admin.entities.Office;
import com.falconworks.wbsedclapp.admin.mappers.*;
import com.falconworks.wbsedclapp.admin.services.EmployeeService;
import com.falconworks.wbsedclapp.admin.services.OfficeService;
import com.falconworks.wbsedclapp.exceptions.OfficeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class WBSEDCLRestAdminController {

    private OfficeService officeService;
    private EmployeeService employeeService;

    @Autowired
    public WBSEDCLRestAdminController(OfficeService officeService, EmployeeService employeeService) {
        this.officeService = officeService;
        this.employeeService = employeeService;
    }


    @GetMapping("/offices")
    public List<OfficeSummaryResponseDTO> getAllOffices() {
        return OfficeEntityListToOfficeSummaryResponseDTOListMapper.map(officeService.findAll());
    }

    @GetMapping("/offices/{officeCode}")
    public OfficeDetailedResponseDTO getOfficeByCode(@PathVariable String officeCode) {
        Office office = officeService.findByOfficeCode(officeCode);
        if (office == null) {
            throw new OfficeNotFoundException("Office " + officeCode + " does not exist");
        }
        return OfficeEntityToDetailedResponseDTOMapper.map(office);
    }

    @PutMapping("/offices")
    public OfficeDetailedResponseDTO updateOffice(@Valid @RequestBody OfficeRequestDTO officeRequestDTO, BindingResult bindingResult) {
        Office office = new OfficeRequestDTOtoOfficeEntityMapper(officeService).map(officeRequestDTO);
        office = officeService.updateOffice(office);
        return OfficeEntityToDetailedResponseDTOMapper.map(office);
    }

    @PostMapping("/offices")
    public OfficeDetailedResponseDTO saveOffice(@Valid @RequestBody OfficeRequestDTO officeRequestDTO) {
        Office office = new OfficeRequestDTOtoOfficeEntityMapper(officeService).map(officeRequestDTO);
        office = officeService.saveOffice(office);
        System.out.println(office.getEmployees());
        return OfficeEntityToDetailedResponseDTOMapper.map(office);
    }

    @DeleteMapping("/offices/{id}")
    public void deleteOfficeById(@PathVariable int id) {
        officeService.deleteById(id);
    }

    @GetMapping("/employees")
    public List<EmployeeSummaryResponseDTO> getAllEmployees() {
        return EmployeeListToEmployeeSummaryResponseDTOListMapper.map(employeeService.findAll());
    }

    @PostMapping("/employees")
    public EmployeeDetailedResponseDTO saveEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = new EmployeeRequestDTOtoEmployeeEntityMapper(officeService).map(employeeRequestDTO);
        employee = employeeService.saveEmployee(employee);
        return EmployeeEntityToResponseDTOMapper.map(employee);
    }

    @GetMapping("/employees/{username}")
    public Employee getUserByUsername(@PathVariable String username) {
        return employeeService.getEmployeeByUsername(username);
    }

    @PutMapping("/employees")
    public EmployeeDetailedResponseDTO updateEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = new EmployeeRequestDTOtoEmployeeEntityMapper(officeService).map(employeeRequestDTO);
        employee = employeeService.updateEmployee(employee);
        return EmployeeEntityToResponseDTOMapper.map(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        employeeService.deleteById(id);
    }
}
