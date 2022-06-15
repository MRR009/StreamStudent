package com.stg.serviceimpls;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stg.entity.College;
import com.stg.entity.Stream;
import com.stg.exception.CustomExcepHandler;
import com.stg.repository.CollegeRepository;
import com.stg.repository.StreamRepository;
import com.stg.serviceinterfaces.StreamService;

@Service
public class StreamServiceImpl implements StreamService {
	@Autowired
	private StreamRepository streamRepository;

	@Autowired
	private CollegeRepository collegeRepository;

	/*---------------------------------------CREATE---------------------------------------------------- */

	@Override
	public Stream createStream(Stream stream) throws CustomExcepHandler {

		if (streamRepository.findByStreamCode(stream.getStreamCode()) == null) {
			return streamRepository.save(stream);
		} else {
			throw new CustomExcepHandler("Stream with this Code Already Exists");
		}

	}

	@Override
	public Stream addStreamInCollege(Stream stream, String collegeCode) throws CustomExcepHandler {
		Stream tempStream = null;
		College college = collegeRepository.findByCollegeCode(collegeCode);
		if (streamRepository.findByStreamCode(stream.getStreamCode()) == null) {
			stream.getCollegesWithStream().add(college);
			college.getStreamsInCollege().add(stream);
			tempStream = streamRepository.save(stream);
		}
		return tempStream;
	}

	/*---------------------------------------READ---------------------------------------------------- */

	@Override
	public Stream readStreamByCode(String streamCode) throws CustomExcepHandler {
		if (streamRepository.findByStreamCode(streamCode) == null) {
			throw new CustomExcepHandler("Stream with the given code not found");
		} else {
			return streamRepository.findByStreamCode(streamCode);
		}
	}

	@Override
	public List<Stream> getAllStreams() {

		return streamRepository.findAll();
	}
	
	@Override
	public List<College> getCollegesWithStream(String strmCode) throws CustomExcepHandler {
		if(streamRepository.findByStreamCode(strmCode) != null) {
			return streamRepository.findByStreamCode(strmCode).getCollegesWithStream().stream().collect(Collectors.toList());
		} else {
			throw new CustomExcepHandler("Stream with the given code not found");
		}
		
	}

	/*---------------------------------------UPDATE---------------------------------------------------- */

	@Override
	public Stream updateStream(Stream stream) throws CustomExcepHandler {
		if (streamRepository.findByStreamCode(stream.getStreamCode()) == null) {
			return streamRepository.save(stream);
		} else {
			throw new CustomExcepHandler("Cannot update stream. Couldnt find stream with the given stream code");
		}

	}

	@Override
	public Stream upateStreamNameByCode(String streamCode, String changedname) throws CustomExcepHandler {
		if (streamRepository.findByStreamCode(streamCode) == null) {
			Stream stream = streamRepository.findByStreamCode(streamCode);
			stream.setStreamName(changedname);
			return streamRepository.save(stream);
		} else {
			throw new CustomExcepHandler("Cannot update stream. Couldnt find stream with the given stream code");
		}

	}

	/*---------------------------------------DELETE---------------------------------------------------- */
	
	@Transactional
	@Override
	public String deleteStreamByCode(String strmCode) throws CustomExcepHandler {
		if (streamRepository.findByStreamCode(strmCode) == null) {
			streamRepository.removeByStreamCode(strmCode);
			return "Stream Deleted";
		} else {
			throw new CustomExcepHandler("Cannot delete stream. Couldnt find stream with the given stream code");
		}
	}



	/*---------------------------------------END---------------------------------------------------- */
}
