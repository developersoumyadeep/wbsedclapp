package com.falconworks.wbsedclapp.admin.repositories;

import com.falconworks.wbsedclapp.admin.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//	@Query("from Employee e where e.username= :username")
//	Employee getEmployeeByUsername(@Param("username") String username);

	//using inferred query facility of spring-jpa here
	Employee findByUsername(String username);
	Employee findEmployeeByOffice_OfficeCodeAndUsername(String officeCode, String username);
}
