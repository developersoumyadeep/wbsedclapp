package com.falconworks.wbsedclapp.admin.dto.requests;

import javax.validation.constraints.NotNull;

public class OfficeRequestDTO {

    @NotNull(message="Office Code cannot be null")
    private String officeCode;
    @NotNull(message="Office Location cannot be null")
    private String officeLocation;
    private String parentOfficeCode;
    private String addressLine1;
    private String addressLine2;
    @NotNull(message="District cannot be null")
    private String district;
    @NotNull(message="Pin code cannot be null")
    private String pinCode;

    public OfficeRequestDTO() {
    }

    public OfficeRequestDTO(String officeCode, String officeLocation, String parentOfficeCode, String addressLine1, String addressLine2, String district, String pincode) {
        this.officeCode = officeCode;
        this.officeLocation = officeLocation;
        this.parentOfficeCode = parentOfficeCode;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.district = district;
        this.pinCode = pincode;
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
}
