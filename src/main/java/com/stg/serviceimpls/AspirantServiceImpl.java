package com.stg.serviceimpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stg.entity.Aspirant;
import com.stg.exception.CustomExcepHandler;
import com.stg.repository.AspirantRepository;
import com.stg.serviceinterfaces.AspirantService;

@Service
public class AspirantServiceImpl implements AspirantService {
	@Autowired
	private AspirantRepository aspirantRepository;

	/*---------------------------------------CREATE---------------------------------------------------- */

	@Override
	public Aspirant createAspirant(Aspirant aspirant)throws CustomExcepHandler {
		return null;

	}

	/*---------------------------------------READ---------------------------------------------------- */

	@Override
	public Aspirant readyByUsername(String username)throws CustomExcepHandler {

		if (aspirantRepository.findByUsername(username) != null) {
			return aspirantRepository.findByUsername(username);
		} else {
			throw new CustomExcepHandler("Student With this roll number not found");
		}

	}

	@Override
	public List<Aspirant> getAllAspirants()throws CustomExcepHandler {
		if(aspirantRepository.findAll().size()>0) {
			return aspirantRepository.findAll();
		}else {
			throw new CustomExcepHandler("No Data Found");
		}
		
	}

	/*---------------------------------------UPDATE----------------------------------------------------*/

	@Override
	public Aspirant updateAspirant(Aspirant aspirant)throws CustomExcepHandler{
		return null;

		// return tempStud;
	}

	@Override
	public Aspirant updatePassword(String username , String password)throws CustomExcepHandler {

		Aspirant aspirant = aspirantRepository.findByUsername(username);
		if (aspirant != null) {
			aspirant.setPassword(password);
			return aspirantRepository.save(aspirant);
		} else {
			throw new CustomExcepHandler("User not found. Cannot update Data");
		}

	}

	/*---------------------------------------DELETE---------------------------------------------------- */
	@Transactional
	@Override
	public String removeByUsername(String username)throws CustomExcepHandler {
		if (aspirantRepository.findByUsername(username) != null) {
			String aspirantName = aspirantRepository.findByUsername(username).getAspirantName();
			aspirantRepository.deleteByUsername(username);
			return "Aspirant " + aspirantName + "data with removed";
		} else {
			throw new CustomExcepHandler("User not deleted, could not found student");
		}

	}

	/*---------------------------------------END---------------------------------------------------- */

}
