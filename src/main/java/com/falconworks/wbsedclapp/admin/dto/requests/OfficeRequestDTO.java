package com.falconworks.wbsedclapp.admin.dto.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class OfficeRequestDTO {

    @NotNull(message="Office Code cannot be null")
    @Pattern(regexp="[0-9]{7}",message="Office code must be 7 digit long")
    private String officeCode;
    @NotNull(message="Office Location cannot be null")
    @Size(min=10, message="Office location must be at least 10 characters long")
    private String officeLocation;
    @Pattern(regexp="[0-9]{7}",message="Invalid office code")
    private String parentOfficeCode;
    @NotNull(message = "Address Line1 must not be null")
    @Size(min=3, message = "Invalid address line1")
    private String addressLine1;
    private String addressLine2;
    @NotNull(message="District cannot be null")
    private String district;
    @NotNull(message="Pin code cannot be null")
    @Pattern(regexp = "[0-9]{6}", message = "Pin code must be six digits long")
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
