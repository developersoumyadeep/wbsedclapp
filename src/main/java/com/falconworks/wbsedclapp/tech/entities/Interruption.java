package com.falconworks.wbsedclapp.tech.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "interruption")
public class Interruption {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "fault_point_code")
	private String faultPointCode;
	@Column(name = "type")
	private String interruptionType;
	@Column(name="fault_nature")
	private String faultNature;
	@Column(name = "cause")
	private String cause;
	@Column(name = "from_date", columnDefinition = "DATE")
	private LocalDate fromDate;
	@Column(name = "from_hrs", columnDefinition = "TIME")
	private LocalTime fromHrs;
	@Column(name = "to_date", columnDefinition = "DATE")
	private LocalDate toDate;
	@Column(name = "to_hrs", columnDefinition = "TIME")
	private LocalTime toHrs;
	@Column(name = "timestamp", columnDefinition = "TIMESTAMP")
	private LocalDateTime timestamp;
	@Column(name="created_by")
	private String createdBy;

	public Interruption() {

	}

	public Interruption(String faultPointCode, String interruptionType, String cause,String faultNature, LocalDate fromDate,
			LocalTime fromHrs, LocalDate toDate, LocalTime toHrs, LocalDateTime timestamp, String createdBy) {
		super();
		this.faultPointCode = faultPointCode;
		this.interruptionType = interruptionType;
		this.cause = cause;
		this.faultNature = faultNature;
		this.fromDate = fromDate;
		this.fromHrs = fromHrs;
		this.toDate = toDate;
		this.toHrs = toHrs;
		this.timestamp = timestamp;
		this.createdBy = createdBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}
	
	public String getFaultNature() {
		return faultNature;
	}

	public void setFaultNature(String faultNature) {
		this.faultNature = faultNature;
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

	@Override
	public String toString() {
		return "Interruption{" +
				"id=" + id +
				", faultPointCode='" + faultPointCode + '\'' +
				", interruptionType='" + interruptionType + '\'' +
				", faultNature='" + faultNature + '\'' +
				", cause='" + cause + '\'' +
				", fromDate=" + fromDate +
				", fromHrs=" + fromHrs +
				", toDate=" + toDate +
				", toHrs=" + toHrs +
				", timestamp=" + timestamp +
				", createdBy='" + createdBy + '\'' +
				'}';
	}
}
