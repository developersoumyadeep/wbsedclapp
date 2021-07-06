package com.falconworks.wbsedclapp.tech.dto;

import com.falconworks.wbsedclapp.admin.validation.OfficeCodeExists;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class FeederRequestDTO {
    @NotNull(message="Feeder code must not be null")
    @Size(min=5, message="Feeder code must be at least five characters long")
    private String feederCode;
    @NotNull(message="Feeder name must not be null")
    private String name;
    @NotNull(message="Feeder Voltage grade must not be null")
    @Pattern(regexp = "11|33", message=" Voltage grade must be 11kV or 33kV")
    private String voltageGradekV;
    @NotNull(message="Feeder substation office code must not be null")
    @OfficeCodeExists
    private String substationOfficeCode;
    @NotNull(message="Feeder from GSS indicator must not be null")
    private boolean isFromGSS;
    @NotNull(message="Feeder meter no. must not be null")
    @Size(min=5, max= 10, message = "Meter no invalid. Size must be between 5 to 10 characters")
    private String meterNo;
    @NotNull(message="Feeder CT Ratio must not be null")
    @Min(value = 50, message = "Feeder CT ratio must be at least 50/1")
    private int ictr;

    public FeederRequestDTO() {
    }

    public FeederRequestDTO(@NotNull(message = "Feeder code must not be null") @Size(min = 5, message = "Feeder code must be at least five characters long") String feederCode, @NotNull(message = "Feeder name must not be null") String name, @NotNull(message = "Feeder Voltage grade must not be null") @Pattern(regexp = "11|33", message = " Voltage grade must be 11kV or 33kV") String voltageGradekV, @NotNull(message = "Feeder substation office code must not be null") String substationOfficeCode, @NotNull(message = "Feeder from GSS indicator must not be null") boolean isFromGSS, @NotNull(message = "Feeder meter no. must not be null") @Size(min = 5, max = 10, message = "Meter no invalid. Size must be between 5 to 10 characters") String meterNo, @NotNull(message = "Feeder CT Ratio must not be null") @Min(value = 50, message = "Feeder CT ratio must be at least 50/1") int ictr) {
        this.feederCode = feederCode;
        this.name = name;
        this.voltageGradekV = voltageGradekV;
        this.substationOfficeCode = substationOfficeCode;
        this.isFromGSS = isFromGSS;
        this.meterNo = meterNo;
        this.ictr = ictr;
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
