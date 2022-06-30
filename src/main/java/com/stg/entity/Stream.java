package com.stg.entity;

import java.util.ArrayList;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
public class Stream {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int streamId;
	
	@Column(length = 6, unique = true, columnDefinition = "varchar(6) default 'XX'")
	private String streamCode;

	@Column(length = 30)
	private String streamName;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, mappedBy = "streamsInUniversity")
	private Set<University> universitiesWithStream = new HashSet<University>();

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, mappedBy = "streamsInCollege")
	private Set<College> collegesWithStream = new HashSet<College>();
	
	//@JsonManagedReference(value = "stream")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "stream")
	private List<Course> coursesInStream ;

	public Stream() {
		super();
	}

	public Stream(int streamId, String streamCode, String streamName, Set<University> universitiesWithStream,
			Set<College> collegesWithStream) {
		super();
		this.streamId = streamId;
		this.streamCode = streamCode;
		this.streamName = streamName;
		this.universitiesWithStream = universitiesWithStream;
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

	@JsonBackReference("streamsInUniversity")
	public Set<University> getUniversitiesWithStream() {
		return universitiesWithStream;
	}

	public void setUniversitiesWithStream(Set<University> universitiesWithStream) {
		this.universitiesWithStream = universitiesWithStream;
	}

	@JsonBackReference("streamsInCollege")
	public Set<College> getCollegesWithStream() {
		return collegesWithStream;
	}

	public void setCollegesWithStream(Set<College> collegesWithStream) {
		this.collegesWithStream = collegesWithStream;
	}

}
