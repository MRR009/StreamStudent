package com.stg.serviceimpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.College;
import com.stg.entity.Course;
import com.stg.entity.Stream;
import com.stg.exception.CustomExcepHandler;
import com.stg.repository.CollegeRepository;
import com.stg.repository.CourseRepository;
import com.stg.serviceinterfaces.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CollegeRepository collegeRepository;

	/*---------------------------------------CREATE---------------------------------------------------- */
	@Override
	public Course createCourse(Course course) throws CustomExcepHandler {
		if (courseRepository.findByCourseCode(course.getCourseCode()) == null) {
			return courseRepository.save(course);
		} else {
			throw new CustomExcepHandler("Course with this Code Already Exists");
		}

	}

	@Override
	public Course addCourseInCollege(Course course, String collegeCode) throws CustomExcepHandler {
		Course tempCourse = null;
		College college = collegeRepository.findByCollegeCode(collegeCode);
		int clgId = college.getCollegeId();
		if (courseRepository.findByCourseCode(course.getCourseCode()) == null) {
			System.out.println("if condition triggered");
			course.getCollegesWithCourse().add(college);
			college.getCoursesInCollege().add(course);
			tempCourse = courseRepository.save(course);
		}
		return tempCourse;
	}

	/*---------------------------------------READ---------------------------------------------------- */

	@Override
	public Course readCourseByCode(String courseCode) throws CustomExcepHandler {
		if (courseRepository.findByCourseCode(courseCode) == null) {
			throw new CustomExcepHandler("Course with the given code not found");
		} else {
			return courseRepository.findByCourseCode(courseCode);
		}
	}

	@Override
	public List<Course> getAllCourses() throws CustomExcepHandler {

		return courseRepository.findAll();
	}

	@Override
	public List<College> getCollegesWithCourse(String courseCode) throws CustomExcepHandler {
		// TODO Auto-generated method stub
		return null;
	}

	/*---------------------------------------UPDATE---------------------------------------------------- */

	@Override
	public Course updateCourse(Course course) throws CustomExcepHandler {
		if (courseRepository.findByCourseCode(course.getCourseCode()) == null) {
			return courseRepository.save(course);
		} else {
			throw new CustomExcepHandler("Cannot update course. Couldnt find course with the given course code");
		}
	}

	@Override
	public Course updateCourseNameByCode(String courseCode, String changedname) throws CustomExcepHandler {
		if (courseRepository.findByCourseCode(courseCode) == null) {
			Course course = courseRepository.findByCourseCode(courseCode);
			course.setCourseName(courseCode);
			return courseRepository.save(course);
		} else {
			throw new CustomExcepHandler("Cannot update course. Couldnt find course with the given course code");
		}
	}

	/*---------------------------------------DELETE---------------------------------------------------- */

	@Override
	public String deleteCourseByCode(String courseCode) throws CustomExcepHandler {
		// TODO Auto-generated method stub
		return null;
	}

	/*---------------------------------------END---------------------------------------------------- */
}
