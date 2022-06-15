package com.stg.serviceinterfaces;

import java.util.List;

import com.stg.entity.College;
import com.stg.entity.Course;
import com.stg.exception.CustomExcepHandler;

public interface CourseService {
	
	public abstract Course createCourse(Course course )throws CustomExcepHandler;
	
	public abstract Course addCourseInCollege(Course course, String collegeCode)throws CustomExcepHandler;
	
	public abstract Course readCourseByCode(String courseCode)throws CustomExcepHandler;
	
	public abstract List<Course> getAllCourses()throws CustomExcepHandler;
	
	public abstract Course updateCourse(Course course)throws CustomExcepHandler;  
	
	public abstract Course updateCourseNameByCode(String courseCode, String changedname)throws CustomExcepHandler;
	
	public abstract String deleteCourseByCode(String courseCode)throws CustomExcepHandler;
	
	public abstract List<College> getCollegesWithCourse(String courseCode) throws CustomExcepHandler;
}
