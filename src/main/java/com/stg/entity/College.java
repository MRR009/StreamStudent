package com.stg.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int collegeId;

	@Column(length = 6)
	private String collegeCode;

	@Column(length = 60)
	private String collegeName;

	@Column(length = 7)
	private collType collegeType;
	
	public enum collType {
		PRIVATE, GOVERNMENT
	}

	@Column(length = 35)
	private String collegeLocation;

	@Column
	private String collegeLogo;

	@Column
	private String collegeImage;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "uni_code", referencedColumnName = "universityId", nullable = false)
	@JsonBackReference
	private University university;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "collegestreamjunc", joinColumns = @JoinColumn(name = "collegeId"), inverseJoinColumns = @JoinColumn(name = "streamId"))
	private Set<Stream> streamsInCollege = new HashSet<Stream>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "collegeIdFk", referencedColumnName = "addressId")
	private Address address;

	public College() {
		super();
	}

	public College(int collegeId, String collegeCode, String collegeName, collType collegeType, String collegeLocation,
			String collegeLogo, String collegeImage, University university, Set<Stream> streamsInCollege,
			Address address) {
		super();
		this.collegeId = collegeId;
		this.collegeCode = collegeCode;
		this.collegeName = collegeName;
		this.collegeType = collegeType;
		this.collegeLocation = collegeLocation;
		this.collegeLogo = collegeLogo;
		this.collegeImage = collegeImage;
		this.university = university;
		this.streamsInCollege = streamsInCollege;
		this.address = address;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(String collegeCode) {
		this.collegeCode = collegeCode;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public collType getCollegeType() {
		return collegeType;
	}

	public void setCollegeType(collType collegeType) {
		this.collegeType = collegeType;
	}

	public String getCollegeLocation() {
		return collegeLocation;
	}

	public void setCollegeLocation(String collegeLocation) {
		this.collegeLocation = collegeLocation;
	}

	public String getCollegeLogo() {
		return collegeLogo;
	}

	public void setCollegeLogo(String collegeLogo) {
		this.collegeLogo = collegeLogo;
	}

	public String getCollegeImage() {
		return collegeImage;
	}

	public void setCollegeImage(String collegeImage) {
		this.collegeImage = collegeImage;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Stream> getStreamsInCollege() {
		return streamsInCollege;
	}

	public void setStreamsInCollege(Set<Stream> streamsInCollege) {
		this.streamsInCollege = streamsInCollege;
	}

	public String getUniversityCode() {
		return university.getUniversityCode();
	}

}
