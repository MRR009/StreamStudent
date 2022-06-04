package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Student;
import com.stg.serviceinterfaces.StudentService;
@CrossOrigin(value="http://localhost:4200/")
@RestController
@RequestMapping(value = "student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	/*---------------------------------------CREATE---------------------------------------------------- */
	
	@PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	/*---------------------------------------READ---------------------------------------------------- */

	@GetMapping(value = "getbyrollno")
	public Student readStudentByUsername(@RequestParam String username) {
		return studentService.readyByStudentUsername(username);
	}

	@GetMapping(value = "getall")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	/*---------------------------------------UPDATE---------------------------------------------------- */
	
	@PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	@PutMapping(value = "updatepassword")
	public Student updateStudentPassword(@RequestParam String rollNo, @RequestParam String newPassword) {
		return studentService.updateStudentPassword(rollNo, newPassword);
	}

	
	/*---------------------------------------DELETE---------------------------------------------------- */
	
	@DeleteMapping(value = "deletebycode")
	public String deleteStudentByUsername(@RequestParam String username) {
		return studentService.removeStudentByUsername(username);
	}
}
