package com.falconworks.wbsedclapp.admin.dto.responses;

import java.util.ArrayList;
import java.util.List;

public class OfficeSummaryResponseDTO {
    private String officeCode;
    private String officeLocation;
    private List<OfficeSummaryResponseDTO> subOffices = new ArrayList<>();

    public OfficeSummaryResponseDTO() {
    }

    public OfficeSummaryResponseDTO (String officeCode, String officeLocation) {
        this.officeCode = officeCode;
        this.officeLocation = officeLocation;
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

    public List<OfficeSummaryResponseDTO> getSubOffices() {
        return subOffices;
    }

    public void setSubOffices(List<OfficeSummaryResponseDTO> subOffices) {
        this.subOffices = subOffices;
    }
}
