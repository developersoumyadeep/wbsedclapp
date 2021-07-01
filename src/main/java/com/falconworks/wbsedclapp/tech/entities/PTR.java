package com.falconworks.wbsedclapp.tech.entities;

import com.falconworks.wbsedclapp.admin.entities.Office;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ptr")
public class PTR {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name="ptr_code", unique=true)
	private String ptrCode;
	@Column(name="ptr_text")
	private String ptrText;
	@Column(name="capacity_mva")
	private String capacityMva;
	@Column(name="make")
	private String make;
	@Column(name="sl_no")
	private String serialNo;
	@OneToOne
	@JoinColumn(name="ss_office_code")
	private Office substation;
	
	public PTR() {
		
	}
	
	public PTR(String ptrCode, String ptrText, String capacityMva, String make, String serialNo) {
		this.ptrCode = ptrCode;
		this.ptrText = ptrText;
		this.capacityMva = capacityMva;
		this.make = make;
		this.serialNo = serialNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPtrCode() {
		return ptrCode;
	}
	public void setPtrCode(String ptrCode) {
		this.ptrCode = ptrCode;
	}
	public String getPtrText() {
		return ptrText;
	}
	public void setPtrText(String ptrText) {
		this.ptrText = ptrText;
	}
	public String getCapacityMva() {
		return capacityMva;
	}
	public void setCapacityMva(String capacityMva) {
		this.capacityMva = capacityMva;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public Office getSubstation() {
		return substation;
	}
	public void setSubstation(Office substation) {
		this.substation = substation;
	} 
	
}
