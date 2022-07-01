package com.stg.serviceimpls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stg.entity.College;
import com.stg.entity.University;
import com.stg.exception.CustomExcepHandler;
import com.stg.repository.CollegeRepository;
import com.stg.repository.UniversityRepository;
import com.stg.serviceinterfaces.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {

	@Autowired
	private UniversityRepository universityRepository;
	@Autowired
	private CollegeRepository collegeRepository;

	/*---------------------------------------CREATE---------------------------------------------------- */

	@Override
	public University createUniversity(University university) throws CustomExcepHandler {

		if (universityRepository.findByUniversityCode(university.getUniversityCode()) == null) {
			return universityRepository.save(university);
		} else {
			throw new CustomExcepHandler("University with this code already exists");
		}
	}
	
	@Override
	public University addCollegeToUniversity(String universityCode, String collegeCode) throws CustomExcepHandler {
		if (universityRepository.findByUniversityCode(universityCode) == null) {
			University tempUni = universityRepository.findByUniversityCode(universityCode);
			College tempCollege = collegeRepository.findByCollegeCode(collegeCode);
			tempUni.getColleges().add(tempCollege);
			return tempUni;
		} else {
			throw new CustomExcepHandler("University with this code already exists");
		}
	}

	/*---------------------------------------READING---------------------------------------------------- */

	@Override
	public University readUniversityByCode(String code) throws CustomExcepHandler {
		University tempUniversity = universityRepository.findByUniversityCode(code);

		if (tempUniversity != null) {
			return universityRepository.findByUniversityCode(code);

		} else {

			throw new CustomExcepHandler("University with this code does not exist");
		}

	}

	@Override
	public List<University> getAllUniversities() throws CustomExcepHandler {
		if (universityRepository.findAll().size() > 0) {
			return universityRepository.findAll();
		} else {
			throw new CustomExcepHandler("No data Found");
		}

	}
	
	public List<College> getCollegesInUniversity(String uniCode) throws CustomExcepHandler{
		if(universityRepository.findByUniversityCode(uniCode) != null) {
			return universityRepository.findByUniversityCode(uniCode).getColleges();
		} else {
			throw new CustomExcepHandler("No universities availble with the given uniCode");
		}
		
	}
	
	@Override
	public List<College> getCollegesWithUniversities(List<String> univeristyCodes) throws CustomExcepHandler {
		List<Integer> universityIds = new ArrayList<Integer>();
		List<Integer> collegeIds = new ArrayList<Integer>();
		if(univeristyCodes != null) {
			for (String code : univeristyCodes) {
				universityIds.add(universityRepository.findByUniversityCode(code).getUniversityId());
			}
			
		}
		collegeIds = universityRepository.getCollegesWithUniversities(universityIds);
		return collegeRepository.getCollegesWithStream(collegeIds);
		
	}
	
	
	@Override
	public University readUniversityByName(String name) throws CustomExcepHandler {
		// TODO Auto-generated method stub
		return universityRepository.findByUniversityName(name);
	}

	/*---------------------------------------UPDATE---------------------------------------------------- */

	@Override
	public University updateUniversity(University university) {
		if (universityRepository.findByUniversityCode(university.getUniversityCode()) != null) {
			return universityRepository.save(university);
		} else {
			throw new CustomExcepHandler("No University Exists to Update. Give valid values.");
		}

	}
	
	@Override
	public University updateUniversityName(String universityName, String newName) throws CustomExcepHandler {
		if(universityRepository.findByUniversityName(universityName) != null){
			int universityId = universityRepository.findByUniversityName(universityName).getUniversityId();
			universityRepository.updateUniversityName(universityId, universityName);
			 return universityRepository.findByUniversityId(universityId);
		} else {
			throw new CustomExcepHandler("No University Found");
		}
	}

	@Override
	public University updateUniversityCode(String universityName, String newCode) throws CustomExcepHandler {
		if(universityRepository.findByUniversityName(universityName) != null){
			int universityId = universityRepository.findByUniversityName(universityName).getUniversityId();
			universityRepository.updateUniveristyCode(universityId, newCode);
			 return universityRepository.findByUniversityId(universityId);
		} else {
			throw new CustomExcepHandler("No University Found");
		}
	}

	@Override
	public University updateUniversityEst(String universityName, int newEstb) throws CustomExcepHandler {
		if(universityRepository.findByUniversityName(universityName) != null){
			int universityId = universityRepository.findByUniversityName(universityName).getUniversityId();
			universityRepository.updateUniversityEst(universityId, newEstb);
			 return universityRepository.findByUniversityId(universityId);
		} else {
			throw new CustomExcepHandler("No University Found");
		}
	}
	
	@Override
	public College asgnCollegetoUniversity(String collegeName, String universityName) throws CustomExcepHandler {
		int collegeId = collegeRepository.findByCollegeName(collegeName).getCollegeId();
		int universityId = universityRepository.findByUniversityName(universityName).getUniversityId();
		universityRepository.asgnCollegetoUniversity(collegeId, universityId);
		return collegeRepository.findByCollegeName(collegeName);
	}


	/*---------------------------------------DELETE---------------------------------------------------- */

	@Override
	@Transactional
	public String deleteUniversityByCode(String uniCode) throws CustomExcepHandler {
		if (universityRepository.findByUniversityCode(uniCode) != null) {
			universityRepository.deleteByUniversityCode(uniCode);
			return "deleted";
		} else {
			throw new CustomExcepHandler("Could not found University with the given code. University Not found.");
		}

	}

	@Override
	@Transactional
	public String deleteUniversityByName(String name) throws CustomExcepHandler {
		if (universityRepository.findByUniversityName(name) != null) {
			universityRepository.deleteByUniversityName(name);
			return "deleted university by given name";
		} else {
			throw new CustomExcepHandler("Could not found University with the given name. University Not found.");
		}

	}

	

	

	

	

	

	/*---------------------------------------END---------------------------------------------------- */

}
