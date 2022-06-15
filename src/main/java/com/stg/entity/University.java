package com.stg.entity;

import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonIgnoreProperties("college")
@Entity
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int universityId;

	@Column(length = 6, unique = true, columnDefinition = "varchar(6) default 'XX'")
	private String universityCode;

	@Column(length = 60)
	private String universityName;

	@Column(length = 4)
	private int establishedIn;

	@JsonManagedReference(value = "unicol")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "university")
	private List<College> colleges;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "unistreamjunc", joinColumns = @JoinColumn(name = "universityId"), inverseJoinColumns = @JoinColumn(name = "streamId"))
	private Set<Stream> streamsInUniversity = new HashSet<Stream>();

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "unicoursejunc", joinColumns = @JoinColumn(name = "universityId"), inverseJoinColumns = @JoinColumn(name = "courseId"))
	private Set<Course> coursesInUniversity = new HashSet<Course>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "universityFk", referencedColumnName = "addressId")
	private Address address;

	public University() {
		super();
	}

	public University(int universityId, String universityCode, String universityName, int establishedIn,
			List<College> colleges, Set<Stream> streamsInUniversity, Set<Course> coursesInUniversity, Address address) {
		super();
		this.universityId = universityId;
		this.universityCode = universityCode;
		this.universityName = universityName;
		this.establishedIn = establishedIn;
		this.colleges = colleges;
		this.streamsInUniversity = streamsInUniversity;
		this.coursesInUniversity = coursesInUniversity;
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

	public int getEstablishedIn() {
		return establishedIn;
	}

	public void setEstablishedIn(int establishedIn) {
		this.establishedIn = establishedIn;
	}

	public List<College> getColleges() {
		return colleges;
	}

	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}

	public Set<Stream> getStreamsInUniversity() {
		return streamsInUniversity;
	}

	public void setStreamsInUniversity(Set<Stream> streamsInUniversity) {
		this.streamsInUniversity = streamsInUniversity;
	}

	public Set<Course> getCoursesInUniversity() {
		return coursesInUniversity;
	}

	public void setCoursesInUniversity(Set<Course> coursesInUniversity) {
		this.coursesInUniversity = coursesInUniversity;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
