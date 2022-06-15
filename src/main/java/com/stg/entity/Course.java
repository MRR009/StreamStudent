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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;

	@Column(length = 6, unique = true, columnDefinition = "varchar(6) default 'XX'")
	private String courseCode;

	@Column(length = 60)
	private String courseName;

	@Column(length = 10)
	private int courseFee;

	@Column(length = 2)
	private int courseDuration;
	
	@Column
	private coursType courseType;
	
	public enum coursType {
		DEGREE, DIPLOMA, CERTIFICATION
	}

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, mappedBy = "coursesInUniversity")
	private Set<University> universitiesWithCourse = new HashSet<University>();

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, mappedBy = "streamsInCollege")
	private Set<College> collegesWithCourse = new HashSet<College>();
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "streamFk", referencedColumnName = "streamId", nullable = false)
	@JsonBackReference(value = "strmcrs")
	private Stream stream;

	public Course() {
		super();
	}

	public Course(int courseId, String courseCode, String courseName, int courseFee, int courseDuration,
			Set<University> universitiesWithCourse, Set<College> collegesWithCourse) {
		super();
		this.courseId = courseId;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.courseDuration = courseDuration;
		this.universitiesWithCourse = universitiesWithCourse;
		this.collegesWithCourse = collegesWithCourse;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	@JsonBackReference("coursesInUniversity")
	public Set<University> getUniversitiesWithCourse() {
		return universitiesWithCourse;
	}

	public void setUniversitiesWithCourse(Set<University> universitiesWithCourse) {
		this.universitiesWithCourse = universitiesWithCourse;
	}

	@JsonBackReference("coursesInCollege")
	public Set<College> getCollegesWithCourse() {
		return collegesWithCourse;
	}

	public void setCollegesWithCourse(Set<College> collegesWithCourse) {
		this.collegesWithCourse = collegesWithCourse;
	}

}
