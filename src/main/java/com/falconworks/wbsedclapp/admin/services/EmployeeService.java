package com.falconworks.wbsedclapp.admin.services;

import com.falconworks.wbsedclapp.admin.entities.Employee;

import java.util.List;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee saveEmployee(Employee employee);
	public Employee findById(int id);
	public Employee updateEmployee(Employee employee);
	public void deleteById(int id);
	public Employee getEmployeeByUsername(String username);
}
