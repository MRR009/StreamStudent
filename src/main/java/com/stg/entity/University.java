package com.stg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int universityId;

	@Column(length = 6)
	private String universityCode;

	@Column(length = 60)
	private String universityName;

	@Column(length = 35)
	private String universityLocation;

	@Column(length = 35)
	private String specialization;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "university")
	private List<College> colleges;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "universityIdFk", referencedColumnName = "addressId")
	private Address address;

	public University() {
		super();
	}

	public University(int universityId, String universityCode, String universityName, String universityLocation,
			String specialization, List<College> colleges, Address address) {
		super();
		this.universityId = universityId;
		this.universityCode = universityCode;
		this.universityName = universityName;
		this.universityLocation = universityLocation;
		this.specialization = specialization;
		this.colleges = colleges;
		this.address = address;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String getUniversityCode() {
		return universityCode;
	}

	public void setUniversityCode(String universityCode) {
		this.universityCode = universityCode;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getUniversityLocation() {
		return universityLocation;
	}

	public void setUniversityLocation(String universityLocation) {
		this.universityLocation = universityLocation;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public List<College> getColleges() {
		return colleges;
	}

	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
