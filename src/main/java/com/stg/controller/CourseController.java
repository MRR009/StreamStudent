package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.College;
import com.stg.entity.Course;
import com.stg.serviceinterfaces.CourseService;
@CrossOrigin(value="http://localhost:4200/")
@RestController
@RequestMapping(value = "course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	/*---------------------------------------CREATE---------------------------------------------------- */
	@PostMapping(value="add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Course createStream(@RequestBody Course course) {
		return courseService.createCourse(course);
	}
	@PostMapping(value = "addcourseincollege", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Course addCourseInCollege(@RequestBody Course course,@RequestParam String collegeCode) {
		return courseService.addCourseInCollege(course, collegeCode);
	}
	
	/*---------------------------------------READ---------------------------------------------------- */
	@GetMapping(value="readbycode")
	public Course readCourseByCode(@RequestParam String courseCode) {
		return courseService.readCourseByCode(courseCode);
	}
	
	@GetMapping(value="getall")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	public List<College> getCollegesWithCourse(@RequestParam String courseCode){
		return courseService.getCollegesWithCourse(courseCode);
	}
	
	/*---------------------------------------UPDATE---------------------------------------------------- */
	public Course updateCourse(@RequestBody Course course) {
		return courseService.updateCourse(course);
	}
	
	public Course updateCourseNameByCode(@RequestParam String courseCode,@RequestParam String changedname) {
		return courseService.updateCourseNameByCode(courseCode, changedname);
	}
	
	/*---------------------------------------DELETE---------------------------------------------------- */
	
	public String deleteCourseByCode(@RequestParam String courseCode) {
		return null;
	}
	
	/*---------------------------------------END---------------------------------------------------- */
}