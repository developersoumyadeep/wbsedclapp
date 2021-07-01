package com.falconworks.wbsedclapp.admin.services;

import java.util.List;

import com.falconworks.wbsedclapp.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falconworks.wbsedclapp.admin.repositories.EmployeeRepository;
import com.falconworks.wbsedclapp.admin.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findById(int id) {
		return employeeRepository.getById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);

	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		Employee employee =  employeeRepository.findByUsername(username);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee "+username+" does not exist");
		}
		return employee;
	}

}
