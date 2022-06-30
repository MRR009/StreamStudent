package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stg.entity.College;
import com.stg.entity.Course;
import com.stg.entity.Stream;

public interface StreamRepository extends JpaRepository<Stream, Integer> {

	public Stream findByStreamCode(String streamCode);

	public Stream findBystreamName(String streamName);

	public String removeByStreamCode(String streamCode);
	
	/* (SELECT college_id FROM collegestreamjunc WHERE stream_id IN ?1); */
	@Query(value = "SELECT college_id FROM collegestreamjunc WHERE stream_id IN ?1", nativeQuery = true)
	public List<Integer> getCollegesIdsWithStream(List<Integer> streamIds);
	
	
}
