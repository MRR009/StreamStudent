 package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stg.entity.College;
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
	
	public University findByUniversityId(int id);

	public University findByUniversityCode(String code);
	
	public University findByUniversityName(String name);
	
	@Query(value = "SELECT college_id FROM college WHERE university_fk IN ?1", nativeQuery = true)
	public List<Integer> getCollegesWithUniversities(List<Integer> universityIds);

	
	public void deleteByUniversityCode(String uniCode);
	
	
	public void deleteByUniversityName(String name);
	
	
	@Modifying
	@Transactional
	@Query(value="UPDATE university SET university_name = :university_name WHERE university_id = :university_id", nativeQuery = true)
	public void updateUniversityName(@Param("university_id") int univeristyId, @Param("university_name") String universityName);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE university SET university_code = :university_code WHERE university_id = :university_id", nativeQuery = true)
	public void updateUniveristyCode(@Param("university_id") int univeristyId,@Param("university_code") String universityCode);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE university SET established_in = :university_Est WHERE university_id = :university_id", nativeQuery = true)
	public void updateUniversityEst(@Param("university_id") int univeristyId,@Param("university_Est") int univeristyEst);

	@Modifying
	@Transactional
	@Query(value="UPDATE college SET university_fk = :university_id WHERE college_id = :college_id", nativeQuery = true)
	public void asgnCollegetoUniversity(@Param("college_id") int collegeId, @Param("university_id") int universityId);

}
