package com.falconworks.wbsedclapp.tech.dto;

import com.falconworks.wbsedclapp.admin.validation.ExistingUsername;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class InterruptionRequestDTO {
    @NotNull(message = "Fault point must not be null")
    private String faultPointCode;
    @NotNull(message = "Interruption type must not be null")
    private String interruptionType;
    @NotNull(message = "Fault nature must not be null")
    private String faultNature;
    @NotNull(message = "Fault cause must not be null")
    private String cause;
    @NotNull(message = "Fault start date must not be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;
    @NotNull(message = "Fault start time must not be null")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime fromHrs;
    @NotNull(message = "Fault end date not be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate toDate;
    @NotNull(message = "Fault end time not be null")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime toHrs;
    @NotNull(message = "Interruption entry timestamp must not be null")
    private LocalDateTime timestamp;
    @NotNull(message = "Interruption entry created by field must not be null")
    @ExistingUsername
    private String createdBy;

    public InterruptionRequestDTO() {
    }

    public InterruptionRequestDTO(String faultPointCode,  String interruptionType,  String faultNature,  String cause,  LocalDate fromDate, LocalTime fromHrs,  LocalDate toDate, LocalTime toHrs,  LocalDateTime timestamp,  String createdBy) {
        this.faultPointCode = faultPointCode;
        this.interruptionType = interruptionType;
        this.faultNature = faultNature;
        this.cause = cause;
        this.fromDate = fromDate;
        this.fromHrs = fromHrs;
        this.toDate = toDate;
        this.toHrs = toHrs;
        this.timestamp = timestamp;
        this.createdBy = createdBy;
    }

    public String getFaultPointCode() {
        return faultPointCode;
    }

    public void setFaultPointCode(String faultPointCode) {
        this.faultPointCode = faultPointCode;
    }

    public String getInterruptionType() {
        return interruptionType;
    }

    public void setInterruptionType(String interruptionType) {
        this.interruptionType = interruptionType;
    }

    public String getFaultNature() {
        return faultNature;
    }

    public void setFaultNature(String faultNature) {
        this.faultNature = faultNature;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}