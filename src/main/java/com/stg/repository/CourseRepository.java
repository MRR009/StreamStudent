package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.stg.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	public Course findByCourseCode(String courseCode);
	
	public Course findByCourseName(String courseName);
	
	public String deleteByCourseCode(String courseCode);
	
	@Modifying
	@Transactional
	@Query(value="SET FOREIGN_KEY_CHECKS=0;", nativeQuery = true)
	public void setForeignKeyChecks();
	
	@Modifying
	@Transactional
	@Query(value="ALTER TABLE course ALTER stream_fk SET DEFAULT 0;", nativeQuery = true)
	public void setDefaultForColumn();
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE course SET stream_fk = :stream_id WHERE course_id = :cour_id", nativeQuery = true)
	public void setStreamToCourse(@Param("stream_id") int streamId,@Param("cour_id") int courseId);
}
