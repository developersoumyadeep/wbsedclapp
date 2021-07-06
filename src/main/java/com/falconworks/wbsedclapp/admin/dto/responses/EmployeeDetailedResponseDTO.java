package com.falconworks.wbsedclapp.admin.dto.responses;

import java.time.LocalDate;

public class EmployeeDetailedResponseDTO {
    private String username;
    private String mobile;
    private String email;
    private String firstName;
    private String lastName;
    private String designation;
    private String employeeType;
    private String addressLine1;
    private String addressLine2;
    private String district;
    private String pinCode;
    private LocalDate joiningDate;
    private LocalDate retirementDate;
    private String officeCode;

    public EmployeeDetailedResponseDTO() {
    }

    public EmployeeDetailedResponseDTO(String username, String mobile, String email, String firstName, String lastName, String designation, String employeeType, String addressLine1, String addressLine2, String district, String pinCode, LocalDate joiningDate, LocalDate retirementDate, String officeCode) {
        this.username = username;
        this.mobile = mobile;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.designation = designation;
        this.employeeType = employeeType;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.district = district;
        this.pinCode = pinCode;
        this.joiningDate = joiningDate;
        this.retirementDate = retirementDate;
        this.officeCode = officeCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
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

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }
}
