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
import com.falconworks.wbsedclapp.exceptions.SavingWithExistingUsernameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

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

    //SUPERUSER routes: Get all employees, Get all offices, Create a new Office, Update an existing office, Delete an existing office, Add any employee to any office, Update any employee of any office, Delete an employee of any office
    @GetMapping("/offices")
    @PreAuthorize("@authorizationServiceImpl.hasPermission(authentication.principal.username,'SUPERUSER')")
    public List<OfficeSummaryResponseDTO> getAllOffices() {
        return OfficeEntityListToOfficeSummaryResponseDTOListMapper.map(officeService.findAll());
    }

    @PostMapping("/offices")
    @PreAuthorize("@authorizationServiceImpl.hasPermission(authentication.principal.username,'SUPERUSER')")
    public OfficeDetailedResponseDTO saveOffice(@Valid @RequestBody OfficeRequestDTO officeRequestDTO) {
        Office office = new OfficeRequestDTOtoOfficeEntityMapper(officeService).map(officeRequestDTO);
        office = officeService.saveOffice(office);
        System.out.println(office.getEmployees());
        return OfficeEntityToDetailedResponseDTOMapper.map(office);
    }

    @PutMapping("/offices")
    @PreAuthorize("@authorizationServiceImpl.hasPermission(authentication.principal.username,'SUPERUSER')")
    public OfficeDetailedResponseDTO updateOffice(@Valid @RequestBody OfficeRequestDTO officeRequestDTO, BindingResult bindingResult) {
        Office office = new OfficeRequestDTOtoOfficeEntityMapper(officeService).map(officeRequestDTO);
        office = officeService.updateOffice(office);
        return OfficeEntityToDetailedResponseDTOMapper.map(office);
    }

    @DeleteMapping("/offices/{id}")
    @PreAuthorize("@authorizationServiceImpl.hasPermission(authentication.principal.username,'SUPERUSER')")
    public void deleteOfficeById(@PathVariable int id) {
        officeService.deleteById(id);
    }

    @GetMapping("/employees")
    @PreAuthorize("@authorizationServiceImpl.hasPermission(authentication.principal.username,'SUPERUSER')")
    public List<EmployeeSummaryResponseDTO> getAllEmployees() {
        return EmployeeListToEmployeeSummaryResponseDTOListMapper.map(employeeService.findAll());
    }

    @GetMapping("/employees/{username}")
    @PreAuthorize("@authorizationServiceImpl.hasPermission(authentication.principal.username,'SUPERUSER')")
    public EmployeeDetailedResponseDTO getUserByUsername(@PathVariable String username) {
        return EmployeeEntityToDetailedResponseDTOMapper.map(employeeService.getEmployeeByUsername(username));
    }

    @PostMapping("/employees")
    @PreAuthorize("@authorizationServiceImpl.hasPermission(authentication.principal.username,'SUPERUSER')")
    public EmployeeDetailedResponseDTO saveEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) throws Exception {
        if (employeeService.getEmployeeByUsername(employeeRequestDTO.getUsername())!= null) {
            throw new SavingWithExistingUsernameException("User "+employeeRequestDTO.getUsername()+" already exists");
        }
        Employee employee = new EmployeeRequestDTOtoEmployeeEntityMapper(officeService, employeeService).map(employeeRequestDTO);
        employee = employeeService.saveEmployee(employee);
        return EmployeeEntityToDetailedResponseDTOMapper.map(employee);
    }

    @PutMapping("/employees")
    @PreAuthorize("@authorizationServiceImpl.hasPermission(authentication.principal.username,'SUPERUSER')")
    public EmployeeDetailedResponseDTO updateEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = new EmployeeRequestDTOtoEmployeeEntityMapper(officeService, employeeService).map(employeeRequestDTO);
        employee = employeeService.updateEmployee(employee);
        return EmployeeEntityToDetailedResponseDTOMapper.map(employee);
    }

    @DeleteMapping("/employees/{id}")
    @PreAuthorize("@authorizationServiceImpl.hasPermission(authentication.principal.username,'SUPERUSER')")
    public void deleteEmployeeById(@PathVariable int id) {
        employeeService.deleteById(id);
    }

    //ADMIN routes: Get all employees of his/her office/sub-office, Get the details of his/her office/sub-office, Add a new employee to his/her office/sub-office,Get an employee of his/her office/sub-office, Edit an employee of his/her office/sub-office

    @GetMapping("/offices/{officeCode}")
    @PreAuthorize("@authorizationServiceImpl.hasPermission(#officeCode, authentication.principal.username,'ADMIN')")
    public OfficeDetailedResponseDTO getOfficeByCode(@PathVariable String officeCode) {
        Office office = officeService.findByOfficeCode(officeCode);
        if (office == null) {
            throw new OfficeNotFoundException("Office " + officeCode + " does not exist");
        }
        return OfficeEntityToDetailedResponseDTOMapper.map(office);
    }

    @GetMapping("/offices/{officeCode}/employees")
    @PreAuthorize("@authorizationServiceImpl.hasPermission(#officeCode, authentication.principal.username,'ADMIN')")
    public List<EmployeeSummaryResponseDTO> getEmployeesFromOfficeCode(@PathVariable String officeCode) {
        List<Employee> employeeList = null;
        if (!(officeCode.endsWith("000"))) {
            employeeList = employeeService.findAll().stream().filter(employee -> employee.getOffice().getOfficeCode().equals(officeCode)).collect(toList());
        } else {
            employeeList = employeeService.findAll().stream().filter(employee -> employee.getOffice().getOfficeCode().startsWith(officeCode.substring(0, 4))).collect(toList());
        }
        return EmployeeListToEmployeeSummaryResponseDTOListMapper.map(employeeList);
    }

    @GetMapping("/offices/{officeCode}/employees/{username}")
    @PreAuthorize("@authorizationServiceImpl.hasPermission(#officeCode, authentication.principal.username,'ADMIN')")
    public EmployeeDetailedResponseDTO getEmployeeDetailsFromOfficeCode(@PathVariable String officeCode, @PathVariable String username) {
        return EmployeeEntityToDetailedResponseDTOMapper.map(employeeService.getEmployeeByUsername(username));
    }

    @PostMapping("/offices/{officeCode}/employees")
    @PreAuthorize("@authorizationServiceImpl.hasPermission(#officeCode, authentication.principal.username,'ADMIN')")
    public EmployeeDetailedResponseDTO saveEmployeeToAParticularOffice(@PathVariable String officeCode, @RequestBody EmployeeRequestDTO dto) throws Exception {
        if (employeeService.getEmployeeByUsername(dto.getUsername())!= null) {
            throw new SavingWithExistingUsernameException("User "+dto.getUsername()+" already exists");
        }
        Employee employee = new EmployeeRequestDTOtoEmployeeEntityMapper(officeService,employeeService).map(dto);
        return EmployeeEntityToDetailedResponseDTOMapper.map(employeeService.saveEmployee(employee));
    }

    @PutMapping("/offices/{officeCode}/employees")
    @PreAuthorize("@authorizationServiceImpl.hasPermission(#officeCode, authentication.principal.username,'ADMIN')")
    public EmployeeDetailedResponseDTO updateEmployeeOfAParticularOffice(@PathVariable String officeCode, @RequestBody EmployeeRequestDTO dto) {
        Employee employee = new EmployeeRequestDTOtoEmployeeEntityMapper(officeService,employeeService).map(dto);
        return EmployeeEntityToDetailedResponseDTOMapper.map(employeeService.updateEmployee(employee));
    }
}
