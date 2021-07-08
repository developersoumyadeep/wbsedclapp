package com.falconworks.wbsedclapp.admin.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employee")
public class Employee extends User{
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "designation")
    private String designation;

    @Column(name = "employee_type")
    private String employeeType;
    
    @Column(name= "joining_date")
    private LocalDate joiningDate;
    
    @Column(name = "date_of_retirement")
    private LocalDate retirementDate;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "office_code_fk", referencedColumnName="office_code")
    private Office office;

    public Employee() {

    }

    public Employee(String username, String password, String mobile, String email, Address address, boolean isEnabled, String firstName, String lastName, String designation, String employeeType, LocalDate joiningDate, LocalDate retirementDate) {
        super(username, password, mobile, email, address, isEnabled);
        this.firstName = firstName;
        this.lastName = lastName;
        this.designation = designation;
        this.employeeType = employeeType;
        this.joiningDate = joiningDate;
        this.retirementDate = retirementDate;	
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
        office.addEmployee(this);
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public LocalDate getRetirementDate() {
		return retirementDate;
	}

	public void setRetirementDate(LocalDate retirementDate) {
		this.retirementDate = retirementDate;
	}

	@Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", designation='" + designation + '\'' +
                ", office code=" + office.getOfficeCode() + 
                "} " + super.toString();
    }


}
