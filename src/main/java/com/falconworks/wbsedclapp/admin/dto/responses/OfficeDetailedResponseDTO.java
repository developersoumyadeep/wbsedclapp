package com.falconworks.wbsedclapp.admin.dto.responses;

import java.util.ArrayList;
import java.util.List;

public class OfficeDetailedResponseDTO {
    private int id;
    private String officeCode;
    private String officeLocation;
    private String parentOfficeCode;
    private String addressLine1;
    private String addressLine2;
    private String district;
    private String pinCode;
    private List<String> subOfficeCodes = new ArrayList<>();
    private List<String> employeeUsernames = new ArrayList<>();

    public OfficeDetailedResponseDTO() {
    }

    public OfficeDetailedResponseDTO(int id, String officeCode, String officeLocation, String parentOfficeCode, String addressLine1, String addressLine2, String district, String pinCode, List<String> subOfficeCodes, List<String> employeeUsernames) {
        this.id = id;
        this.officeCode = officeCode;
        this.officeLocation = officeLocation;
        this.parentOfficeCode = parentOfficeCode;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.district = district;
        this.pinCode = pinCode;
        this.subOfficeCodes = subOfficeCodes;
        this.employeeUsernames = employeeUsernames;
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

    public String getParentOfficeCode() {
        return parentOfficeCode;
    }

    public void setParentOfficeCode(String parentOfficeCode) {
        this.parentOfficeCode = parentOfficeCode;
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

    public List<String> getSubOfficeCodes() {
        return subOfficeCodes;
    }

    public void setSubOfficeCodes(List<String> subOfficeCodes) {
        this.subOfficeCodes = subOfficeCodes;
    }

    public List<String> getEmployeeUsernames() {
        return employeeUsernames;
    }

    public void setEmployeeUsernames(List<String> employeeUsernames) {
        this.employeeUsernames = employeeUsernames;
    }

    public void addEmployeeUsername(String username) {
        employeeUsernames.add(username);
    }

}
