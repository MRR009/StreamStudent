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

import com.stg.entity.Aspirant;
import com.stg.serviceinterfaces.AspirantService;

@CrossOrigin(value="http://localhost:4200/")
@RestController
@RequestMapping(value = "student")
public class StudentController {
	@Autowired
	private AspirantService aspirantService;

	/*---------------------------------------CREATE---------------------------------------------------- */
	
	@PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Aspirant createStudent(@RequestBody Aspirant aspirant) {
		return aspirantService.createAspirant(aspirant);
	}

	/*---------------------------------------READ---------------------------------------------------- */

	@GetMapping(value = "getbyrollno")
	public Aspirant readStudentByUsername(@RequestParam String username) {
		return aspirantService.readyByUsername(username);
	}

	@GetMapping(value = "getall")
	public List<Aspirant> getAllStudents() {
		return aspirantService.getAllAspirants();
	}

	/*---------------------------------------UPDATE---------------------------------------------------- */
	
	@PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Aspirant updateStudent(@RequestBody Aspirant aspirant) {
		return aspirantService.updateAspirant(aspirant);
	}

	@PutMapping(value = "updatepassword")
	public Aspirant updateStudentPassword(@RequestParam String username, @RequestParam String newPassword) {
		return aspirantService.updatePassword(username, newPassword);
	}

	
	/*---------------------------------------DELETE---------------------------------------------------- */
	
	@DeleteMapping(value = "deletebyusername")
	public String deleteStudentByUsername(@RequestParam String username) {
		return aspirantService.removeByUsername(username);
	}
}
