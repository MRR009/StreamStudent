package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.College;
import com.stg.entity.Course;
import com.stg.entity.Course.coursType;
import com.stg.serviceinterfaces.CourseService;
@CrossOrigin(value ="http://localhost:4200/")
@RestController
@RequestMapping(value = "course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	/*---------------------------------------CREATE---------------------------------------------------- */
	@PostMapping(value="add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Course createCourse(@RequestBody Course course) {
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
	
	@GetMapping(value="readByName")
	public Course readCourseByName(@RequestParam String courseName) {
		return courseService.readCourseByName(courseName);
	}
	
	@GetMapping(value="getall")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@GetMapping(value = "getcollegeswithcourse")
	public List<College> getCollegesWithCourse(@RequestParam String courseCode){
		return courseService.getCollegesWithCourse(courseCode);
	}
	
	/*---------------------------------------UPDATE---------------------------------------------------- */
	@PutMapping(value="update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Course updateCourse(@RequestBody Course course) {
		return courseService.updateCourse(course);
	}
	
	@PutMapping(value="updatebycode")
	public Course updateCourseNameByCode(@RequestParam String courseCode,@RequestParam String changedname) {
		return courseService.updateCourseNameByCode(courseCode, changedname);
	}
	
	@PutMapping(value="updatestreamincourse")
	public Course setStreamToCourse(@RequestParam String streamCode, @RequestParam String courseCode ) {
		return courseService.setStreamToCourse(streamCode, courseCode);
	}
	
	@PutMapping(value="updatecoursename")
	public Course updateCourseName(@RequestParam String courseName,@RequestParam String newName) {
		return courseService.updateCourseName(courseName, newName);
	}
	
	@PutMapping(value="updatecoursecode")
	public Course updateCourseCode(@RequestParam String courseName,@RequestParam String newName) {
		return courseService.updateCourseCode(courseName, newName);
	}
	
	@PutMapping(value="updatecoursefee")
	public Course updateCourseFee(@RequestParam String courseName,@RequestParam int newName) {
		return courseService.updateCourseFee(courseName, newName);
	}
	
	@PutMapping(value="updatecourseduration")
	public Course updateCourseDuration(@RequestParam String courseName,@RequestParam int newName) {
		return courseService.updateCourseDuration(courseName, newName);
	}
	
	@PutMapping(value="updatecoursetype")
	public Course updateCourseType(@RequestParam String courseName,@RequestParam coursType newName) {
		return courseService.updateCourseType(courseName, newName);
	}
	
	
	/*---------------------------------------DELETE---------------------------------------------------- */
	
	public String deleteCourseByCode(@RequestParam String courseCode) {
		return null;
	}
	
	/*---------------------------------------END---------------------------------------------------- */
}
