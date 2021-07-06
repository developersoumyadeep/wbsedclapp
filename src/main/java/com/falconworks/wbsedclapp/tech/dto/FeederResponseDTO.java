package com.falconworks.wbsedclapp.tech.dto;

public class FeederResponseDTO {

    private int id;

    private String feederCode;

    private String name;

    private String voltageGradekV;

    private String substationOfficeCode;

    private String substationName;

    private boolean isFromGSS;

    private String meterNo;

    private int ictr;

    public FeederResponseDTO() {
    }

    public FeederResponseDTO(int id, String feederCode, String name, String voltageGradekV, String substationOfficeCode, String substationName, boolean isFromGSS, String meterNo, int ictr) {
        this.id = id;
        this.feederCode = feederCode;
        this.name = name;
        this.voltageGradekV = voltageGradekV;
        this.substationOfficeCode = substationOfficeCode;
        this.substationName = substationName;
        this.isFromGSS = isFromGSS;
        this.meterNo = meterNo;
        this.ictr = ictr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeederCode() {
        return feederCode;
    }

    public void setFeederCode(String feederCode) {
        this.feederCode = feederCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoltageGradekV() {
        return voltageGradekV;
    }

    public void setVoltageGradekV(String voltageGradekV) {
        this.voltageGradekV = voltageGradekV;
    }

    public String getSubstationOfficeCode() {
        return substationOfficeCode;
    }

    public void setSubstationOfficeCode(String substationOfficeCode) {
        this.substationOfficeCode = substationOfficeCode;
    }

    public String getSubstationName() {
        return substationName;
    }

    public void setSubstationName(String substationName) {
        this.substationName = substationName;
    }

    public boolean isFromGSS() {
        return isFromGSS;
    }

    public void setFromGSS(boolean fromGSS) {
        isFromGSS = fromGSS;
    }

    public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo;
    }

    public int getIctr() {
        return ictr;
    }

    public void setIctr(int ictr) {
        this.ictr = ictr;
    }
}
