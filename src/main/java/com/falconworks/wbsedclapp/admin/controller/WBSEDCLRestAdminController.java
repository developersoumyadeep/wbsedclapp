package com.falconworks.wbsedclapp.admin.controller;

import com.falconworks.wbsedclapp.admin.entities.Employee;
import com.falconworks.wbsedclapp.admin.entities.Office;
import com.falconworks.wbsedclapp.exceptions.OfficeNotFoundException;
import com.falconworks.wbsedclapp.admin.services.EmployeeService;
import com.falconworks.wbsedclapp.admin.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public List<Office> getAllOffices() {
        return officeService.findAll();
    }

    @GetMapping("/offices/{officeCode}")
    public Office getOfficeByCode(@PathVariable String officeCode) {
        Office office =  officeService.findByOfficeCode(officeCode);
        if (office == null) {
            throw new OfficeNotFoundException("Office "+officeCode+" does not exist");
        }
        return office;
    }

    @PutMapping("/offices")
    public Office updateOffice(@RequestBody Office office) {
        return officeService.updateOffice(office);
    }

    @PostMapping("/offices")
    public Office saveOffice(@RequestBody Office office) {
        return officeService.saveOffice(office);
    }

    @DeleteMapping("/offices/{id}")
    public void deleteOfficeById(@PathVariable int id) {
        officeService.deleteById(id);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees/{username}")
    public Employee getUserByUsername(@PathVariable String username) {
        return employeeService.getEmployeeByUsername(username);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        employeeService.deleteById(id);
    }


}
