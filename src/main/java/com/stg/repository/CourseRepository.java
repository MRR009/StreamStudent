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
	
	@Modifying
	@Transactional
	@Query(value="UPDATE course SET course_name = :course_name WHERE course_id = :course_id", nativeQuery = true)
	public void updateCourseName(@Param("course_id") int courseId,@Param("course_name") String courseName);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE course SET course_code = :course_code WHERE course_id = :course_id", nativeQuery = true)
	public void updateCourseCode(@Param("course_id") int courseId,@Param("course_code") String courseCode);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE course SET course_fee = :cour_fee WHERE course_id = :cour_id", nativeQuery = true)
	public void updateCourseFee(@Param("cour_fee") int courseFee, @Param("cour_id") int courseId);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE course SET course_duration = :course_duration WHERE course_id = :course_id", nativeQuery = true)
	public void updateCourseDuration(@Param("course_id") int courseId,@Param("course_duration") int courseDuration);
	
	
	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query(
	 * value="UPDATE course c SET c.courseType = :course_type WHERE c.courseId = :course_id"
	 * ) public void updateCourseType(@Param("course_id") int
	 * courseId,@Param("course_type") int courseType);
	 */
	
	
}
