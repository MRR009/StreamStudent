package com.stg.serviceinterfaces;

import java.util.List;

import com.stg.entity.Aspirant;
import com.stg.exception.CustomExcepHandler;

public interface AspirantService {
	
	public abstract Aspirant createAspirant(Aspirant aspirant)throws CustomExcepHandler;
	
	public abstract Aspirant readyByUsername(String username)throws CustomExcepHandler;
	
	public abstract List<Aspirant> getAllAspirants()throws CustomExcepHandler;
	
	public abstract Aspirant updateAspirant(Aspirant aspirant)throws CustomExcepHandler;
	
	public abstract Aspirant updatePassword(String username , String password)throws CustomExcepHandler;

	public abstract String removeByUsername(String username)throws CustomExcepHandler;
	
}
