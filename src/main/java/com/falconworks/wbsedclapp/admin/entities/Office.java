package com.falconworks.wbsedclapp.admin.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//The Office class needs to implement serializable because of a Hibernate bug for 
//@ManyToOne mapping with non-primary unique key
//Please check https://hibernate.atlassian.net/browse/HHH-7668

@SuppressWarnings("serial")
@Entity
@Table(name = "office")
public class Office implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "office_code", unique = true)
	private String officeCode;

	@Column(name = "office_location")
	private String officeLocation;

	@ManyToOne
	@JoinColumn(name = "parent_ofc_id")
	@JsonIgnoreProperties({ "parentOffice", "employees", "subOffices" })
	private Office parentOffice;

	@OneToMany(mappedBy = "parentOffice", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(ignoreUnknown=true, value={ "parentOffice" })
	private List<Office> subOffices;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToMany(mappedBy = "office")
	@JsonIgnoreProperties({"office"})
	private List<Employee> employees;

	public Office() {
	}

	public Office(String officeCode, String officeLocation, Address address) {
		this.officeCode = officeCode;
		this.officeLocation = officeLocation;
		this.address = address;
		this.subOffices = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public String getOfficeLocation() {
		return officeLocation;
	}

	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}

	public Office getParentOffice() {
		return parentOffice;
	}

	public void setParentOffice(Office parentOffice) {
		this.parentOffice = parentOffice;
		if (parentOffice != null) {
			parentOffice.addSubOffice(this);
		}

	}

	public List<Office> getSubOffices() {
		return subOffices;
	}

	public void setSubOffices(List<Office> subOffices) {
		this.subOffices = subOffices;
	}

	public void addSubOffice(Office office) {
		if (subOffices == null) {
			subOffices = new ArrayList<>();
		}

		subOffices.add(office);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void addEmployee(Employee employee) {
		if (employees == null) {
			employees = new ArrayList<>();
		}

		employees.add(employee);
	}

	public void removeEmployee(Employee employee) {
		if (employees != null && !employees.isEmpty()) {
			employees.remove(employee);
		}
	}

	@Override
	public String toString() {
		return "Office [id=" + id + ", officeCode=" + officeCode + ", officeLocation=" + officeLocation
				+ ", parentOffice=" + parentOffice + ", address=" + address + ", employees=" + employees + "]";
	}

}
