package com.falconworks.wbsedclapp.tech.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.falconworks.wbsedclapp.admin.entities.Office;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "feeder")
public class Feeder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "feeder_code", unique = true)
	private String feederCode;

	@Column(name = "name")
	private String name;

	@Column(name = "voltage_grade_kV")
	private String voltageGradekV;

	@OneToOne
	@JoinColumn(name = "ss_office_code", referencedColumnName="office_code")
	@JsonIgnoreProperties("subOffices")
	private Office substation;

	@Column(name = "is_from_gss", columnDefinition = "TINIINT")
	private boolean isFromGSS;

	@Column(name = "meter_no")
	private String meterNo;

	@Column(name = "ictr")
	private int ictr;

	public Feeder() {

	}

	public Feeder(int id, String feederCode, String name, String voltageGradekV, Office substation, boolean isFromGSS,
			String meterNo, int ictr) {
		super();
		this.id = id;
		this.feederCode = feederCode;
		this.name = name;
		this.voltageGradekV = voltageGradekV;
		this.substation = substation;
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

	public Office getSubstation() {
		return substation;
	}

	public void setSubstation(Office substation) {
		this.substation = substation;
	}

	public boolean isFromGSS() {
		return isFromGSS;
	}

	public void setFromGSS(boolean isFromGSS) {
		this.isFromGSS = isFromGSS;
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

	@Override
	public String toString() {
		return "Feeder [id=" + id + ", feederCode=" + feederCode + ", name=" + name + ", substation=" + substation.getOfficeLocation()
				+ ", isFromGSS=" + isFromGSS + ", meterNo=" + meterNo + ", ictr=" + ictr + "]";
	}

}
