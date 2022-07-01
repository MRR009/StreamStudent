package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.stg.entity.College;
import com.stg.entity.Course;
import com.stg.entity.Stream;

public interface StreamRepository extends JpaRepository<Stream, Integer> {
	
	public Stream findByStreamId(int streamId);

	public Stream findByStreamCode(String streamCode);

	public Stream findBystreamName(String streamName);

	public String removeByStreamCode(String streamCode);
	
	/* (SELECT college_id FROM collegestreamjunc WHERE stream_id IN ?1); */
	@Query(value = "SELECT college_id FROM collegestreamjunc WHERE stream_id IN ?1", nativeQuery = true)
	public List<Integer> getCollegesIdsWithStream(List<Integer> streamIds);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE stream SET stream_name = :stream_name WHERE stream_id = :stream_id", nativeQuery = true)
	public void updateStreamName(@Param("stream_id") int streamId, @Param("stream_name") String streamName);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE stream SET stream_code = :stream_code WHERE stream_id = :stream_id", nativeQuery = true)
	public void updateStreamCode(@Param("stream_id") int streamId,@Param("stream_code") String streamCode);
}
