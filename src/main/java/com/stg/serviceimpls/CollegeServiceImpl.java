package com.stg.serviceimpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stg.entity.College;
import com.stg.entity.College.collType;
import com.stg.entity.Course;
import com.stg.entity.Course.coursType;
import com.stg.entity.Stream;
import com.stg.entity.University;
import com.stg.exception.CustomExcepHandler;
import com.stg.repository.CollegeRepository;
import com.stg.repository.CourseRepository;
import com.stg.repository.StreamRepository;
import com.stg.repository.UniversityRepository;
import com.stg.serviceinterfaces.CollegeService;

@Service
public class CollegeServiceImpl implements CollegeService {
	@Autowired
	private CollegeRepository collegeRepository;

	@Autowired
	private UniversityRepository universityRepository;

	@Autowired
	private StreamRepository streamRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	/*---------------------------------------CREATE---------------------------------------------------- */

	@Override
	public College createCollege(College college) throws CustomExcepHandler {

		//University university = universityRepository.findByUniversityCode(college.getUniversity().getUniversityCode());
		if (college != null) {
			//int uniId = university.getUniversityId();
			collegeRepository.setDefaultForColumn();
			collegeRepository.setForeignKeyChecks();
			return collegeRepository.save(college);
		} else {
			throw new CustomExcepHandler("Please check your values once");
		}
	}
	
	@Override
	public College AssignCollegeToUniversity(String clgCode, String uniCode) throws CustomExcepHandler {
		College college = collegeRepository.findByCollegeCode(uniCode);
		college.getUniversity().setUniversityCode(uniCode);
		return college;
	}

	@Override
	public College addCertainStream(String streamCode, String CollegeCode) throws CustomExcepHandler {
		College tempCollege = null;
		College college = collegeRepository.findByCollegeCode(CollegeCode);
		Stream stream = streamRepository.findByStreamCode(streamCode);
		
		if(college.getStreamsInCollege().contains(stream)) {
		for (Stream stream2 : college.getStreamsInCollege()) {
			if (stream2.getStreamCode().equalsIgnoreCase(streamCode)) {
				throw new CustomExcepHandler("Stream with this Code Already Exists");
			} else {
				college.getStreamsInCollege().add(stream);
				stream.getCollegesWithStream().add(college);
				tempCollege = collegeRepository.save(college);
			}
		}} else {
			college.getStreamsInCollege().add(stream);
			stream.getCollegesWithStream().add(college);
			tempCollege = collegeRepository.save(college);
		}

		if (tempCollege != null) {
			return tempCollege;
		} else{
			throw new CustomExcepHandler("Cant do this operation");
		}

	}
	
	@Override
	public College addCertainCourse(String courseCode, String CollegeCode) throws CustomExcepHandler {
		College tempCollege = null;
		College college = collegeRepository.findByCollegeCode(CollegeCode);
		Course course = courseRepository.findByCourseCode(courseCode);
		
		if(college.getCoursesInCollege().contains(course)) {
		for (Stream stream2 : college.getStreamsInCollege()) {
			if (stream2.getStreamCode().equalsIgnoreCase(courseCode)) {
				throw new CustomExcepHandler("Course with this Code Already Exists");
			} else {
				college.getCoursesInCollege().add(course);
				course.getCollegesWithCourse().add(college);
				tempCollege = collegeRepository.save(college);
			}
		}} else {
			college.getCoursesInCollege().add(course);
			course.getCollegesWithCourse().add(college);
			tempCollege = collegeRepository.save(college);
		}

		if (tempCollege != null) {
			return tempCollege;
		} else{
			throw new CustomExcepHandler("Cant do this operation");
		}
	}

	/*---------------------------------------READ---------------------------------------------------- */

	@Override
	public College readCollegeByCode(String code) throws CustomExcepHandler {
		College tempCollege = collegeRepository.findByCollegeCode(code);
		if (tempCollege != null) {
			System.out.println(tempCollege.getUniversity().getUniversityCode());
			return collegeRepository.findByCollegeCode(code);
		} else {
			throw new CustomExcepHandler("No college Found with the given Code");
		}
	}

	@Override
	public List<College> getAllColleges() throws CustomExcepHandler {
		if (collegeRepository.findAll().size() > 0) {
			return collegeRepository.findAll();
		} else {
			throw new CustomExcepHandler("No data found");
		}

	}
	
	@Override
	public College readCollegeByName(String collegeName) throws CustomExcepHandler {
		
		return collegeRepository.findByCollegeName(collegeName);
	}

	/*---------------------------------------UPDATE---------------------------------------------------- */

	@Override
	public College updateCollege(College college) throws CustomExcepHandler {
		if (collegeRepository.findByCollegeCode(college.getCollegeCode()) != null) {
			return collegeRepository.save(college);
		} else {
			throw new CustomExcepHandler("No College found to update");
		}

	}
	
	@Override
	public College updateCollegeName(String collegeName, String newName) throws CustomExcepHandler {
		if(collegeRepository.findByCollegeName(collegeName) != null){
			int collegeId = collegeRepository.findByCollegeName(collegeName).getCollegeId();
			collegeRepository.updateCollegeName(collegeId, collegeName);
			 return collegeRepository.findByCollegeId(collegeId);
		} else {
			throw new CustomExcepHandler("No Course Found");
		}
	}

	@Override
	public College updateCollegeCode(String collegeName, String newCode) throws CustomExcepHandler {
		if(collegeRepository.findByCollegeName(collegeName) != null){
			int collegeId = collegeRepository.findByCollegeName(collegeName).getCollegeId();
			collegeRepository.updateCollegeCode(collegeId, newCode);
			 return collegeRepository.findByCollegeId(collegeId);
		} else {
			throw new CustomExcepHandler("No Course Found");
		}
	}

	@Override
	public College updateEstablishedIn(String collegeName, int newEstabYear) throws CustomExcepHandler {
		if(collegeRepository.findByCollegeName(collegeName) != null){
			int collegeId = collegeRepository.findByCollegeName(collegeName).getCollegeId();
			collegeRepository.updateCollegeEst(collegeId, newEstabYear);
			 return collegeRepository.findByCollegeId(collegeId);
		} else {
			throw new CustomExcepHandler("No Course Found");
		}
	}

	@Override
	public College updateCollegeInfo(String collegeName, String newColegeInfo) throws CustomExcepHandler {
		if(collegeRepository.findByCollegeName(collegeName) != null){
			int collegeId = collegeRepository.findByCollegeName(collegeName).getCollegeId();
			collegeRepository.updateCollegeInfo(collegeId, newColegeInfo);
			 return collegeRepository.findByCollegeId(collegeId);
		} else {
			throw new CustomExcepHandler("No Course Found");
		}
	}

	@Override
	public College updateCollegeType(String collegeName, collType newType) throws CustomExcepHandler {
		if(collegeRepository.findByCollegeName(collegeName) != null){
			int collegeId = collegeRepository.findByCollegeName(collegeName).getCollegeId();
			collegeRepository.updateCollegeName(collegeId, collegeName);
			 return collegeRepository.findByCollegeId(collegeId);
		} else {
			throw new CustomExcepHandler("No Course Found");
		}
	}

	@Override
	public College updateCollegeDescription(String collegeName, String newCollegeDescription) throws CustomExcepHandler {
		if(collegeRepository.findByCollegeName(collegeName) != null){
			int collegeId = collegeRepository.findByCollegeName(collegeName).getCollegeId();
			collegeRepository.updateCollegeDescription(collegeId, newCollegeDescription);
			 return collegeRepository.findByCollegeId(collegeId);
		} else {
			throw new CustomExcepHandler("No Course Found");
		}
	}

	@Override
	public College updateCollegeLogo(String collegeName, String newCollegeLogo) throws CustomExcepHandler {
		if(collegeRepository.findByCollegeName(collegeName) != null){
			int collegeId = collegeRepository.findByCollegeName(collegeName).getCollegeId();
			collegeRepository.updateCollegeLogo(collegeId, newCollegeLogo);
			 return collegeRepository.findByCollegeId(collegeId);
		} else {
			throw new CustomExcepHandler("No Course Found");
		}
	}

	@Override
	public College updateCollegeImage(String collegeName, String newCollegeImage) throws CustomExcepHandler {
		if(collegeRepository.findByCollegeName(collegeName) != null){
			int collegeId = collegeRepository.findByCollegeName(collegeName).getCollegeId();
			collegeRepository.updateCollegeImage(collegeId, newCollegeImage);
			 return collegeRepository.findByCollegeId(collegeId);
		} else {
			throw new CustomExcepHandler("No Course Found");
		}
	}

	@Override
	public College updateCollegeLink(String collegeName, String newCollegeLink) throws CustomExcepHandler {
		if(collegeRepository.findByCollegeName(collegeName) != null){
			int collegeId = collegeRepository.findByCollegeName(collegeName).getCollegeId();
			collegeRepository.updateCollegeLink(collegeId, newCollegeLink);
			 return collegeRepository.findByCollegeId(collegeId);
		} else {
			throw new CustomExcepHandler("No Course Found");
		}
	}

	/*---------------------------------------DELETE---------------------------------------------------- */

	@Transactional
	@Override
	public String deleteCollegeByCode(String clgCode) throws CustomExcepHandler {
		if (collegeRepository.findByCollegeCode(clgCode) != null) {
			collegeRepository.deleteByCollegeCode(clgCode);
			return "Requested College Deleted";
		} else {
			throw new CustomExcepHandler("No College Found to Delete");
		}

	}

	

	

	

}
