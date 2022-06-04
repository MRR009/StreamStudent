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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
public class Stream {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int streamId;

	@Column(length = 10)
	private String streamCode;

	@Column(length = 30)
	private String streamName;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "stream")
	private List<Student> students;

	@JsonBackReference
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, mappedBy = "streamsInCollege")
	private Set<College> collegesWithStream = new HashSet<College>();

	public Stream() {
		super();
	}

	public Stream(int streamId, String streamCode, String streamName, List<Student> students,
			Set<College> collegesWithStream) {
		super();
		this.streamId = streamId;
		this.streamCode = streamCode;
		this.streamName = streamName;
		this.students = students;
		this.collegesWithStream = collegesWithStream;
	}

	public int getStreamId() {
		return streamId;
	}

	public void setStreamId(int streamId) {
		this.streamId = streamId;
	}

	public String getStreamCode() {
		return streamCode;
	}

	public void setStreamCode(String streamCode) {
		this.streamCode = streamCode;
	}

	public String getStreamName() {
		return streamName;
	}

	public void setStreamName(String streamName) {
		this.streamName = streamName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Set<College> getCollegesWithStream() {
		return collegesWithStream;
	}

	public void setCollegesWithStream(Set<College> collegesWithStream) {
		this.collegesWithStream = collegesWithStream;
	}

	
}
