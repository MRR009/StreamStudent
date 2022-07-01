package com.stg.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.stg.entity.College;
import com.stg.entity.College.collType;
import com.stg.entity.Course;
import com.stg.entity.Stream;
import com.stg.entity.Course.coursType;
import com.stg.exception.CustomExcepHandler;

public interface CollegeService {
	public abstract College createCollege(College college) throws CustomExcepHandler;
	
	public abstract College readCollegeByCode(String code) throws CustomExcepHandler;
	
	public abstract College readCollegeByName(String courseName)throws CustomExcepHandler;
	
	public abstract List<College> getAllColleges()throws CustomExcepHandler;
	
	public abstract College updateCollege(College college) throws CustomExcepHandler; 
	
	public abstract College updateCollegeName(String collegeName, String newName) throws CustomExcepHandler;
	public abstract College updateCollegeCode(String collegeName, String newCode) throws CustomExcepHandler;
	public abstract College updateEstablishedIn(String collegeName, int newEstabYear) throws CustomExcepHandler;
	public abstract College updateCollegeInfo(String collegeName, String newColegeInfo) throws CustomExcepHandler;
	public abstract College updateCollegeType(String collegeName, collType newType) throws CustomExcepHandler;
	public abstract College updateCollegeDescription(String collegeName, String newCollegeDescription) throws CustomExcepHandler;
	public abstract College updateCollegeLogo(String collegeName, String newCollegeLogo) throws CustomExcepHandler;
	public abstract College updateCollegeImage(String collegeName, String newCollegeImage) throws CustomExcepHandler;
	public abstract College updateCollegeLink(String collegeName, String newCollegeLink) throws CustomExcepHandler;
	
	public abstract String deleteCollegeByCode(String clgCode) throws CustomExcepHandler;
	
	public abstract College AssignCollegeToUniversity(String clgCode, String uniCode) throws CustomExcepHandler; 
	
	public abstract College addCertainStream(String streamCode, String CollegeCode)throws CustomExcepHandler;
	
	public abstract College addCertainCourse(String courseCode, String CollegeCode)throws CustomExcepHandler;
}
