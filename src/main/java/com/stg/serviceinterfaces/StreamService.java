package com.stg.serviceinterfaces;

import java.util.List;

import com.stg.entity.College;
import com.stg.entity.Stream;
import com.stg.exception.CustomExcepHandler;

public interface StreamService {
	
	public abstract Stream createStream(Stream stream )throws CustomExcepHandler;
	
	public abstract Stream addStreamInCollege(Stream stream, String collegeCode)throws CustomExcepHandler;
	
	public abstract List<College> getCollegesWithStreams(List<String> streamCodes)throws CustomExcepHandler;
	
	public abstract Stream readStreamByCode(String code)throws CustomExcepHandler;
	
	public abstract Stream readStreamByName(String name)throws CustomExcepHandler;
	
	public abstract List<Stream> getAllStreams()throws CustomExcepHandler;
	
	public abstract Stream updateStream(Stream Stream)throws CustomExcepHandler;  
	
	public abstract Stream updateStreamName(String streamName, String newName) throws CustomExcepHandler;
	public abstract Stream updateStreamCode(String streamName, String newCode) throws CustomExcepHandler;
	
	public abstract Stream upateStreamNameByCode(String streamCode, String changedname)throws CustomExcepHandler;
	
	public abstract String deleteStreamByCode(String strmCode)throws CustomExcepHandler;
	
	public abstract List<College> getCollegesWithStream(String strmCode) throws CustomExcepHandler;
}
