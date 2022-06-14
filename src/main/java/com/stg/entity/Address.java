package com.stg.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;

	@Column
	private String addressLane1;

	@Column
	private String addressLane2;

	@Column(length = 6)
	private int pincode;

	@Column
	private String district;

	@Column
	private String state;

	@OneToOne(mappedBy = "address")
	private College college;

	@OneToOne(mappedBy = "address")
	private University university;

	public Address() {
		super();
	}

	public Address(int addressId, String addressLane1, String addressLane2, int pincode, String district, String state,
			College college, University university) {
		super();
		this.addressId = addressId;
		this.addressLane1 = addressLane1;
		this.addressLane2 = addressLane2;
		this.pincode = pincode;
		this.district = district;
		this.state = state;
		this.college = college;
		this.university = university;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressLane1() {
		return addressLane1;
	}

	public void setAddressLane1(String addressLane1) {
		this.addressLane1 = addressLane1;
	}

	public String getAddressLane2() {
		return addressLane2;
	}

	public void setAddressLane2(String addressLane2) {
		this.addressLane2 = addressLane2;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

}
