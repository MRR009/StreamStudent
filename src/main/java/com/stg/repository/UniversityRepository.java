 package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stg.entity.University;
@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {
	
	//@Query("SELECT u FROM university u where u.university_code = :univ_code")
	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query(value="DELETE FROM university  WHERE university_code = :uni_code",
	 * nativeQuery=true) public void deleteUniByCode(@Param("uni_code") String
	 * code);
	 */

	public University findByUniversityCode(String code);
	
	public University findByUniversityName(String name);

	
	public void deleteByUniversityCode(String uniCode);
	
	
	public void deleteByUniversityName(String name);
}
