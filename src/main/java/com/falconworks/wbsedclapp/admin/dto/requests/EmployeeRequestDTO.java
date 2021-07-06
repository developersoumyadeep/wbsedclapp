package com.falconworks.wbsedclapp.admin.dto.requests;

import com.falconworks.wbsedclapp.admin.validation.NonExistingUsername;
import com.falconworks.wbsedclapp.admin.validation.OfficeCodeExists;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public class EmployeeRequestDTO {
    @NotNull(message="username must not be null")
    @Pattern(regexp = "[0-9]{8}", message = "Username must be 8 digits long")
    @NonExistingUsername
    private String username;
    @NotNull(message="password must not be null")
    @Size(min = 3, message="password must be at least three characters long")
    private String password;
    @NotNull(message="mobile no. must not be null")
    @Pattern(regexp = "[0-9]{10}", message="Invalid mobile no.")
    private String mobile;
    @Email(message="Invalid email address")
    private String email;
    @NotNull(message = "First name must not be null")
    @Size(min = 3, message = "First name must be at least 3 characters long ")
    private String firstName;
    private String lastName;
    @NotNull(message = "Designation must not be null")
    private String designation;
    @NotNull(message = "Employee type must not be null")
    private String employeeType;
    @NotNull(message = "Address Line1 must not be null")
    @Size(min=3, message = "Invalid address line1")
    private String addressLine1;
    private String addressLine2;
    @NotNull(message = "District must not be null")
    @Size(min=3, message = "Invalid district ")
    private String district;
    @NotNull(message = "Pin code must not be null")
    @Pattern(regexp = "[0-9]{6}", message = "Pin code must be six digits long")
    private String pinCode;
    @NotNull(message="Joining date must not be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate joiningDate;
    @NotNull(message = "Retirement date must not be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate retirementDate;
    @NotNull(message="Employee office code must not be null")
    @Pattern(regexp="[0-9]{7}",message="Invalid office code")
    @OfficeCodeExists
    private String officeCode;
    @NotNull(message="Uninitialized authorization list")
    private List<String> authorizations;
    @NotNull(message="Enabled status cannot be null")
    private boolean isEnabled;

    public EmployeeRequestDTO() {
    }

    public EmployeeRequestDTO(String username, String password, String mobile, String email, String firstName, String lastName, String designation, String employeeType, String addressLine1, String addressLine2, String district, String pinCode, LocalDate joiningDate, LocalDate retirementDate, String officeCode, List<String> authorizations, boolean isEnabled) {
        this.username = username;
        this.password = password;
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
        this.authorizations = authorizations;
        this.isEnabled = isEnabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<String> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(List<String> authorizations) {
        this.authorizations = authorizations;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
