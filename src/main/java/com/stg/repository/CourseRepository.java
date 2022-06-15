package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	public Course findByCourseCode(String courseCode);
	
	public Course findByCourseName(String courseName);
	
	public String deleteByCourseCode(String courseCode);
}
