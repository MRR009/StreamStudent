package com.stg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.College;
import com.stg.entity.University;
import com.stg.exception.CustomExcepHandler;
import com.stg.serviceinterfaces.UniversityService;
@CrossOrigin(value="http://localhost:4200/")
@RestController
@RequestMapping(value = "university")
public class UniversityController {

	@Autowired
	private UniversityService universityService;

	/*---------------------------------------CREATE---------------------------------------------------- */

	@PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public University createUniversity(@RequestBody University university) {
		return universityService.createUniversity(university);
	}
	
	@PostMapping(value = "addcollege")
	public University addCollegeToUniversity(@RequestParam String universityCode,@RequestParam String collegeCode) {
		return universityService.addCollegeToUniversity(universityCode, collegeCode);
	}
	/*---------------------------------------READ---------------------------------------------------- */

	@GetMapping(value = "getbycode")
	public University readUniversityByCode(@RequestParam String uniCode) {
		return universityService.readUniversityByCode(uniCode);
	}

	@GetMapping(value = "getall")
	public List<University> getAllUniversities() {
		return universityService.getAllUniversities();
	}
	
	@GetMapping(value = "collegesinuniversity")
	public List<College> getCollegesInUniversity(@RequestParam String uniCode){
		return universityService.getCollegesInUniversity(uniCode);
	}
	
	@GetMapping(value = "collegesinuniversities")
	public List<College> getCollegesWithUniversities(@RequestParam(value = "universityCodes", required = false) List<String> universityCodes){
		return universityService.getCollegesWithUniversities(universityCodes);
	}
	
	@GetMapping(value = "getbyname")
	public University readUniversityByName(@RequestParam String name) throws CustomExcepHandler {
		// TODO Auto-generated method stub
		return universityService.readUniversityByName(name);
	}

	/*---------------------------------------UPDATE---------------------------------------------------- */

	@PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public University updateUniversity(@RequestBody University university) {
		return universityService.updateUniversity(university);
	}
	
	@PutMapping(value = "updatename")
	public University updateUniversityName(@RequestParam String universityName,@RequestParam String newName) throws CustomExcepHandler {
		
		return universityService.updateUniversityName(universityName, newName);
	}

	@PutMapping(value = "updatecode")
	public University updateUniversityCode(@RequestParam String universityName,@RequestParam String newCode) throws CustomExcepHandler {
		
		return universityService.updateUniversityCode(universityName, newCode);
	}

	@PutMapping(value = "updateestablished")
	public University updateUniversityEst(@RequestParam String universityName,@RequestParam int newEstb) throws CustomExcepHandler {
		// TODO Auto-generated method stub
		return universityService.updateUniversityEst(universityName, newEstb);
	}
	
	@PutMapping(value = "asgnclgtouni")
	public College asgnCollegetoUniversity(@RequestParam String collegeName,@RequestParam String universityName) {
		return universityService.asgnCollegetoUniversity(collegeName, universityName);
	}

	


	/*---------------------------------------DELETE---------------------------------------------------- */

	@DeleteMapping(value = "deletebycode")
	public String deleteUniversityByCode(@RequestParam String code) {
		return universityService.deleteUniversityByCode(code);
	}

	@DeleteMapping(value = "deletebyname")
	public String deleteUniversityByname(@RequestParam String name) {
		return universityService.deleteUniversityByName(name);
	}

	/*---------------------------------------END---------------------------------------------------- */
}
