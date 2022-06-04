package com.stg.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.stg.entity.College;
import com.stg.entity.Stream;
import com.stg.exception.CustomExcepHandler;

public interface CollegeService {
	public abstract College createCollege(College college) throws CustomExcepHandler;
	
	public abstract College readCollegeByCode(String code) throws CustomExcepHandler;
	
	public abstract List<College> getAllColleges()throws CustomExcepHandler;
	
	public abstract College updateCollege(College college) throws CustomExcepHandler; 
	
	public abstract String deleteCollegeByCode(String clgCode) throws CustomExcepHandler;
	
	public abstract College addCertainStream(String streamCode, String CollegeCode)throws CustomExcepHandler;
}
