package com.stg.serviceinterfaces;

import java.util.List;

import com.stg.entity.College;
import com.stg.entity.Course;
import com.stg.entity.Course.coursType;
import com.stg.exception.CustomExcepHandler;

public interface CourseService {
	
	public abstract Course createCourse(Course course )throws CustomExcepHandler;
	
	public abstract Course addCourseInCollege(Course course, String collegeCode)throws CustomExcepHandler;
	
	public abstract Course setStreamToCourse(String streamCode, String courseCode) throws CustomExcepHandler;
	
	public abstract Course readCourseByCode(String courseCode)throws CustomExcepHandler;
	
	public abstract Course readCourseByName(String courseName)throws CustomExcepHandler;
	
	public abstract List<Course> getAllCourses()throws CustomExcepHandler;
	
	public abstract Course updateCourse(Course course)throws CustomExcepHandler;
	
	public abstract Course updateCourseName(String courseName, String newName) throws CustomExcepHandler;
	public abstract Course updateCourseCode(String courseName, String newName) throws CustomExcepHandler;
	public abstract Course updateCourseFee(String courseName, int newFee) throws CustomExcepHandler;
	public abstract Course updateCourseDuration(String courseName, int newName) throws CustomExcepHandler;
	public abstract Course updateCourseType(String courseName, coursType newName) throws CustomExcepHandler;

	
	public abstract Course updateCourseNameByCode(String courseCode, String changedname)throws CustomExcepHandler;
	
	public abstract String deleteCourseByCode(String courseCode)throws CustomExcepHandler;
	
	public abstract List<College> getCollegesWithCourse(String courseCode) throws CustomExcepHandler;
}
