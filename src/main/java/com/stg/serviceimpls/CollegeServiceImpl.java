package com.stg.serviceimpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stg.entity.College;
import com.stg.entity.Course;
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

		University university = universityRepository.findByUniversityCode(college.getUniversity().getUniversityCode());
		if (university != null) {
			int uniId = university.getUniversityId();
			university = null;
			college.getUniversity().setUniversityId(uniId);
			return collegeRepository.save(college);
		} else {
			throw new CustomExcepHandler("Please check your values once");
		}
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

	/*---------------------------------------UPDATE---------------------------------------------------- */

	@Override
	public College updateCollege(College college) throws CustomExcepHandler {
		if (collegeRepository.findByCollegeCode(college.getCollegeCode()) != null) {
			return collegeRepository.save(college);
		} else {
			throw new CustomExcepHandler("No College found to update");
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
