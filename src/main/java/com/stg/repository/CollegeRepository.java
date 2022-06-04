package com.stg.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.College;

public interface CollegeRepository extends JpaRepository<College, String> {
	
	//@Query(value="SELECT * FROM college where college_code = :clg_code", nativeQuery=true)
	public College findByCollegeCode(String code);
	
	//@Query(value="DELETE FROM college  WHERE college_code = :clg_code", nativeQuery=true)
	public void deleteByCollegeCode(String code);
	
}
