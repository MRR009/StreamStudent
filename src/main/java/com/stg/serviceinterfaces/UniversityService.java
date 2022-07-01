package com.stg.serviceinterfaces;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.stg.entity.College;
import com.stg.entity.Stream;
import com.stg.entity.University;
import com.stg.exception.CustomExcepHandler;

public interface UniversityService {
	
	public abstract University createUniversity(University university)throws CustomExcepHandler;
	
	public abstract University addCollegeToUniversity(String universityCode, String collegeCode)throws CustomExcepHandler;
	
	public abstract University readUniversityByCode(String code) throws CustomExcepHandler;
	
	public abstract University readUniversityByName(String name) throws CustomExcepHandler;
	
	public abstract List<University> getAllUniversities()throws CustomExcepHandler;
	
	public abstract University updateUniversity(University university)throws CustomExcepHandler;
	
	public abstract University updateUniversityName(String universityName, String newName) throws CustomExcepHandler;
	public abstract University updateUniversityCode(String universityName, String newCode) throws CustomExcepHandler;
	public abstract University updateUniversityEst(String universityName, int newEstb) throws CustomExcepHandler;
	
	public abstract List<College> getCollegesWithUniversities(List<String> univeristyCodes) throws CustomExcepHandler;
	
	public abstract String deleteUniversityByCode(String uniCode)throws CustomExcepHandler;
	
	public abstract String deleteUniversityByName(String name)throws CustomExcepHandler;
	
	public abstract List<College> getCollegesInUniversity(String uniCode) throws CustomExcepHandler;
	
	public abstract College asgnCollegetoUniversity(String collegeName,String universityName)throws CustomExcepHandler;
	
}
