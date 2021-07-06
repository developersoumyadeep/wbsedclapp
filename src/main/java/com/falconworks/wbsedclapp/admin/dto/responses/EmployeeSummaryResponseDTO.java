package com.falconworks.wbsedclapp.admin.dto.responses;

public class EmployeeSummaryResponseDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String officeCode;

    public EmployeeSummaryResponseDTO() {
    }

    public EmployeeSummaryResponseDTO(String username, String firstName, String lastName, String officeCode) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeCode = officeCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }
}
