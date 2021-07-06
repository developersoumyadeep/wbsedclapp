package com.falconworks.wbsedclapp.tech.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class InterruptionResponseDTO {
    private int id;
    private String faultPointDescription;
    private String substationName;
    private String interruptionType;
    private String cause;
    private LocalDate fromDate;
    private LocalTime fromHrs;
    private LocalDate toDate;
    private LocalTime toHrs;

    public InterruptionResponseDTO() {
    }

    public InterruptionResponseDTO(int id, String faultPointDescription, String substationName, String interruptionType, String cause, LocalDate fromDate, LocalTime fromHrs, LocalDate toDate, LocalTime toHrs) {
        this.id = id;
        this.faultPointDescription = faultPointDescription;
        this.substationName = substationName;
        this.interruptionType = interruptionType;
        this.cause = cause;
        this.fromDate = fromDate;
        this.fromHrs = fromHrs;
        this.toDate = toDate;
        this.toHrs = toHrs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFaultPointDescription() {
        return faultPointDescription;
    }

    public void setFaultPointDescription(String faultPointDescription) {
        this.faultPointDescription = faultPointDescription;
    }

    public String getSubstationName() {
        return substationName;
    }

    public void setSubstationName(String substationName) {
        this.substationName = substationName;
    }

    public String getInterruptionType() {
        return interruptionType;
    }

    public void setInterruptionType(String interruptionType) {
        this.interruptionType = interruptionType;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalTime getFromHrs() {
        return fromHrs;
    }

    public void setFromHrs(LocalTime fromHrs) {
        this.fromHrs = fromHrs;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public LocalTime getToHrs() {
        return toHrs;
    }

    public void setToHrs(LocalTime toHrs) {
        this.toHrs = toHrs;
    }
}
