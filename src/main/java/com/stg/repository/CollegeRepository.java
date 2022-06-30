package com.stg.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stg.entity.College;

public interface CollegeRepository extends JpaRepository<College, String> {
	
	//@Query(value="SELECT * FROM college where college_code = :clg_code", nativeQuery=true)
	public College findByCollegeCode(String code);
	
	//@Query(value="DELETE FROM college  WHERE college_code = :clg_code", nativeQuery=true)
	public void deleteByCollegeCode(String code);
	
	@Query(value = "SELECT c FROM College c WHERE c.collegeId IN :collegeIds ")
	public List<College> getCollegesWithStream(List<Integer> collegeIds);
	
}
