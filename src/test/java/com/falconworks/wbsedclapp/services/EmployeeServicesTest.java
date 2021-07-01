package com.falconworks.wbsedclapp.services;


import com.falconworks.wbsedclapp.admin.repositories.EmployeeRepository;
import com.falconworks.wbsedclapp.admin.entities.Address;
import com.falconworks.wbsedclapp.admin.entities.Employee;
import com.falconworks.wbsedclapp.admin.services.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServicesTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    public void testSavedUserHasId() {
        //create a user address
        Address userAddress = new Address("Power House Complex, 2nd Mile Sevoke Road", "Officers Dormitory-1", "Darjeeling", "734001");

        //create a user
        Employee employee = new Employee("90018329", "trishna@543",
                "8900795088", "trishnaroy@gmail.com", userAddress,
                true, "Trishna", "Roy",
                "AM(HR&A)", "Permanent", LocalDate.of(2013,9,25),LocalDate.of(2052,9,30) );

        Employee employee2 = new Employee("90018329", "trishna@543",
                "8900795088", "trishnaroy@gmail.com", userAddress,
                true, "Trishna", "Roy",
                "AM(HR&A)", "Permanent", LocalDate.of(2013,9,25),LocalDate.of(2052,9,30) );

        employee2.setId(1);
        when(employeeRepository.save(employee)).thenReturn(employee2);

        Employee savedEmployee = employeeService.saveEmployee(employee);

        assertThat(savedEmployee.getId() == employee2.getId());
    }

    @Test
    public void TestUpdateEmployee() {
        //create a user address
        Address userAddress = new Address("Power House Complex, 2nd Mile Sevoke Road", "Officers Dormitory-1", "Darjeeling", "734001");

        //create a user
        Employee employee = new Employee("90018329", "trishna@543",
                "8900795088", "trishnaroy@gmail.com", userAddress,
                true, "Trishna", "Roy",
                "AM(HR&A)", "Permanent", LocalDate.of(2013,9,25),LocalDate.of(2052,9,30) );

        //set the id so that this employee resembles a persistent employee
        employee.setId(1);

        //calling save on the repository with the modified employee object should return the modified employee object
        when(employeeRepository.save(any(Employee.class))).then(returnsFirstArg());

        Employee savedEmployee = employeeService.saveEmployee(employee);

        assertThat(savedEmployee.getPassword().equals(employee.getPassword()));
    }
}
