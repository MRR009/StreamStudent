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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int collegeId;

	@Column(length = 6, unique = true, columnDefinition = "varchar(6) default 'XX'")
	private String collegeCode;

	@Column(length = 100)
	private String collegeName;

	@Column
	private collType collegeType;

	@Column(length = 4)
	private int establishedIn;

	public enum collType {
		PRIVATE, PUBLIC
	}

	@Column
	private String collegeInfo;

	@Column
	private String collegeDescription;

	@Column
	private String collegeLogo;

	@Column
	private String collegeImage;

	@Column
	private String collegeLink;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "universityFk", referencedColumnName = "universityId", nullable = false)
	@JsonBackReference(value = "unicol")
	private University university;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "collegestreamjunc", joinColumns = @JoinColumn(name = "collegeId"), inverseJoinColumns = @JoinColumn(name = "streamId"))
	private Set<Stream> streamsInCollege = new HashSet<Stream>();

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "collegecoursejunc", joinColumns = @JoinColumn(name = "collegeId"), inverseJoinColumns = @JoinColumn(name = "courseId"))
	private Set<Course> coursesInCollege = new HashSet<Course>();

	@OneToOne(mappedBy = "college")
	private Address address;

	public College() {
		super();
	}

	public College(int collegeId, String collegeCode, String collegeName, collType collegeType, int establishedIn,
			String collegeDescription, String collegeLogo, String collegeImage, University university,
			Set<Stream> streamsInCollege, Set<Course> coursesInCollege, Address address) {
		super();
		this.collegeId = collegeId;
		this.collegeCode = collegeCode;
		this.collegeName = collegeName;
		this.collegeType = collegeType;
		this.establishedIn = establishedIn;
		this.collegeDescription = collegeDescription;
		this.collegeLogo = collegeLogo;
		this.collegeImage = collegeImage;
		this.university = university;
		this.streamsInCollege = streamsInCollege;
		this.coursesInCollege = coursesInCollege;
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

	public String getCollegeDescription() {
		return collegeDescription;
	}

	public void setCollegeDescription(String collegeDescription) {
		this.collegeDescription = collegeDescription;
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

	public int getEstablishedIn() {
		return establishedIn;
	}

	public void setEstablishedIn(int establishedIn) {
		this.establishedIn = establishedIn;
	}

	public String getCollegeInfo() {
		return collegeInfo;
	}

	public void setCollegeInfo(String collegeInfo) {
		this.collegeInfo = collegeInfo;
	}

	public String getCollegeLink() {
		return collegeLink;
	}

	public void setCollegeLink(String collegeLink) {
		this.collegeLink = collegeLink;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Set<Stream> getStreamsInCollege() {
		return streamsInCollege;
	}

	public void setStreamsInCollege(Set<Stream> streamsInCollege) {
		this.streamsInCollege = streamsInCollege;
	}

	public Set<Course> getCoursesInCollege() {
		return coursesInCollege;
	}

	public void setCoursesInCollege(Set<Course> coursesInCollege) {
		this.coursesInCollege = coursesInCollege;
	}

	@JsonBackReference("address")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getUniversityCode() {
		return university.getUniversityCode();
	}

}
