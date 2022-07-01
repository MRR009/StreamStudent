package com.stg.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.stg.entity.College;

public interface CollegeRepository extends JpaRepository<College, String> {
	
	public College findByCollegeId(int collegeId);
	
	//@Query(value="SELECT * FROM college where college_code = :clg_code", nativeQuery=true)
	public College findByCollegeCode(String code);
	
	public College findByCollegeName(String collegeName); 
	
	//@Query(value="DELETE FROM college  WHERE college_code = :clg_code", nativeQuery=true)
	public void deleteByCollegeCode(String code);
	
	@Modifying
	@Transactional
	@Query(value="SET FOREIGN_KEY_CHECKS=0;", nativeQuery = true)
	public void setForeignKeyChecks();
	
	@Modifying
	@Transactional
	@Query(value="ALTER TABLE course ALTER stream_fk SET DEFAULT 0;", nativeQuery = true)
	public void setDefaultForColumn();
	
	@Query(value = "SELECT c FROM College c WHERE c.collegeId IN :collegeIds ")
	public List<College> getCollegesWithStream(List<Integer> collegeIds);
	
	
	@Modifying
	@Transactional
	@Query(value="UPDATE college SET college_name = :college_name WHERE college_id = :college_id", nativeQuery = true)
	public void updateCollegeName(@Param("college_id") int collegeId,@Param("college_name") String collegeName);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE college SET college_code = :college_code WHERE college_id = :college_id", nativeQuery = true)
	public void updateCollegeCode(@Param("college_id") int courseId,@Param("college_code") String collegeCode);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE college SET established_in = :established_in WHERE college_id = :college_id", nativeQuery = true)
	public void updateCollegeEst(@Param("college_id") int courseFee, @Param("established_in") int establishedIn);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE college SET college_info = :college_info WHERE college_id = :college_id", nativeQuery = true)
	public void updateCollegeInfo(@Param("college_id") int courseId,@Param("college_info") String collegeInfo);
	
	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query(
	 * value="UPDATE college SET course_duration = :course_duration WHERE course_id = :course_id"
	 * , nativeQuery = true) public void updateCollegeType(@Param("college_id") int
	 * courseId,@Param("college_type") int collegeType);
	 */
	
	@Modifying
	@Transactional
	@Query(value="UPDATE college SET college_description = :college_description WHERE college_id = :college_id", nativeQuery = true)
	public void updateCollegeDescription(@Param("college_id") int courseId,@Param("college_description") String collegeDescription);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE college SET college_logo = :college_logo WHERE college_id = :college_id", nativeQuery = true)
	public void updateCollegeLogo(@Param("college_id") int courseId,@Param("college_logo") String collegeLogo);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE college SET college_image = :college_image WHERE college_id = :college_id", nativeQuery = true)
	public void updateCollegeImage(@Param("college_id") int courseId,@Param("college_image") String collegeImage);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE college SET college_link = :college_link WHERE college_id = :college_id", nativeQuery = true)
	public void updateCollegeLink(@Param("college_id") int courseId,@Param("college_link") String collegeLink);
	
}
