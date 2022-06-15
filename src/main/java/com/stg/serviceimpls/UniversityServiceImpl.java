package com.stg.serviceimpls;

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

	/*---------------------------------------UPDATE---------------------------------------------------- */

	@Override
	public University updateUniversity(University university) {
		if (universityRepository.findByUniversityCode(university.getUniversityCode()) != null) {
			return universityRepository.save(university);
		} else {
			throw new CustomExcepHandler("No University Exists to Update. Give valid values.");
		}

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
