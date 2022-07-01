package com.stg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.stg.entity.Course.coursType;
import com.stg.exception.CustomExcepHandler;
import com.stg.serviceinterfaces.CollegeService;

@CrossOrigin(value="http://localhost:4200/")
@RestController
@RequestMapping(value = "college")
public class CollegeController {

	@Autowired
	private CollegeService collegeService;

	/*---------------------------------------CREATE---------------------------------------------------- */

	@PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public College createCollege(@RequestBody College college) {
		return collegeService.createCollege(college);
	}

	/*---------------------------------------READ---------------------------------------------------- */

	@GetMapping(value = "getall")
	public List<College> readAllColleges() {
		return collegeService.getAllColleges();
	}

	@GetMapping(value = "getbycode")
	public College readCollegeByCode(@RequestParam String code) {
		return collegeService.readCollegeByCode(code);
	}
	
	@GetMapping(value = "getbyname")
	public College readCollegeByName(@RequestParam String collegeName) {
		return collegeService.readCollegeByName(collegeName);
	}

	/*---------------------------------------UPDATE---------------------------------------------------- */

	@PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public College updateCollege(@RequestBody College college) {
		return collegeService.updateCollege(college);
	}
	
	@PutMapping(value = "updatestreamincollege")
	public College updateStreamInCollege(@RequestParam String streamCode,@RequestParam String collegeCode) {
		return collegeService.addCertainStream(streamCode, collegeCode);
	}
	
	@PutMapping(value = "updatecourseincollege")
	public College updateCourseInCollege(@RequestParam String courseCode,@RequestParam String collegeCode) {
		return collegeService.addCertainCourse(courseCode, collegeCode);
	}
	

	@PutMapping(value = "updatecollegename")
	public College updateCollegeName(@RequestParam String collegeName,@RequestParam String newName) throws CustomExcepHandler {
		
		return collegeService.updateCollegeName(collegeName, newName);
	}

	@PutMapping(value = "updatecollegecode")
	public College updateCollegeCode(@RequestParam String collegeName,@RequestParam String newName) throws CustomExcepHandler {
		
		return collegeService.updateCollegeCode(collegeName, newName);
	}

	@PutMapping(value = "updatecollegeest")
	public College updateEstablishedIn(@RequestParam String collegeName,@RequestParam int newEstabYear) throws CustomExcepHandler {
		
		return collegeService.updateEstablishedIn(collegeName, newEstabYear);
	}

	@PutMapping(value = "updatecollegeinfo")
	public College updateCollegeInfo(@RequestParam String collegeName,@RequestParam String newColegeInfo) throws CustomExcepHandler {
		
		return collegeService.updateCollegeInfo(collegeName, newColegeInfo);
	}

	@PutMapping(value = "updatecollegetype")
	public College updateCollegeType(@RequestParam String collegeName,@RequestParam coursType newType) throws CustomExcepHandler {
		
		return collegeService.updateCollegeType(collegeName, null);
	}

	@PutMapping(value = "updatecollegedescription")
	public College updateCollegeDescription(@RequestParam String collegeName,@RequestParam String newCollegeDescription) throws CustomExcepHandler {
		
		return collegeService.updateCollegeDescription(collegeName, newCollegeDescription);
	}

	@PutMapping(value = "updatecollegelogo")
	public College updateCollegeLogo(@RequestParam String collegeName,@RequestParam String newCollegeLogo) throws CustomExcepHandler {
		
		return collegeService.updateCollegeLogo(collegeName, newCollegeLogo);
	}

	@PutMapping(value = "updatecollegeimage")
	public College updateCollegeImage(@RequestParam String collegeName,@RequestParam String newCollegeImage) throws CustomExcepHandler {
		
		return collegeService.updateCollegeImage(collegeName, newCollegeImage);
	}

	@PutMapping(value = "updatecollegelink")
	public College updateCollegeLink(@RequestParam String collegeName,@RequestParam String newCollegeLink) throws CustomExcepHandler {
		
		return collegeService.updateCollegeLink(collegeName, newCollegeLink);
	}

	

	/*---------------------------------------DELETE---------------------------------------------------- */

	@DeleteMapping(value = "deletebycode/")
	public String deleteCollegeByCode(@RequestParam String code) {
		System.out.println("message " + collegeService.deleteCollegeByCode(code));
		return collegeService.deleteCollegeByCode(code);
	}

	/*---------------------------------------END---------------------------------------------------- */

}
