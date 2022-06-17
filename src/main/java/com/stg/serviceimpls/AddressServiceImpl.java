package com.stg.serviceimpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.Address;
import com.stg.exception.CustomExcepHandler;
import com.stg.repository.AddressRepository;
import com.stg.repository.CollegeRepository;
import com.stg.repository.UniversityRepository;
import com.stg.serviceinterfaces.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CollegeRepository collegeRepository;
	
	@Autowired
	private UniversityRepository universityRepository;
	
	/*---------------------------------------CREATE---------------------------------------------------- */

	@Override
	public Address addAddress(Address address) throws CustomExcepHandler {	
			return addressRepository.save(address);
	}

	@Override
	public Address addAddressToCollege(Address address, String collegeCode) throws CustomExcepHandler {
		int collegeId = collegeRepository.findByCollegeCode(collegeCode).getCollegeId();
		addressRepository.save(address);
		addressRepository.updateCollegeAddress(collegeId, address.getAddressId());
		return address;
	}

	@Override
	public Address addAddressToUniversity(Address address, String universityCode) throws CustomExcepHandler {
		int universityId = universityRepository.findByUniversityCode(universityCode).getUniversityId();
		System.out.println((universityId));
		addressRepository.save(address);
		addressRepository.updateUniversityAddress(universityId, address.getAddressId());
		return address;
	}
	
	/*---------------------------------------READ---------------------------------------------------- */

	@Override
	public Address readAddressOfCollege(String collegeCode) throws CustomExcepHandler {
		if(collegeRepository.findByCollegeCode(collegeCode)== null) {
			throw new CustomExcepHandler("No college Found with the given Code");
		} else {
			if( collegeRepository.findByCollegeCode(collegeCode).getAddress()== null) {
				throw new CustomExcepHandler("No Addresses Found ");
			} else {
				return collegeRepository.findByCollegeCode(collegeCode).getAddress();
			}
		}
		
	}

	@Override
	public Address readAddressOfUniversity(String univeristyCode) throws CustomExcepHandler {
		if(universityRepository.findByUniversityCode(univeristyCode)== null) {
			throw new CustomExcepHandler("No university Found with the given Code");
		} else {
			if( universityRepository.findByUniversityCode(univeristyCode).getAddress()== null) {
				throw new CustomExcepHandler("No Addresses Found ");
			} else {
				return universityRepository.findByUniversityCode(univeristyCode).getAddress();
			}
		}
	}

	@Override
	public List<Address> getAllAddresses() throws CustomExcepHandler {
		
		return addressRepository.findAll();
	}
	
	/*---------------------------------------UPDATE---------------------------------------------------- */

	@Override
	public Address updateAddressOfCollege(String collegeCode, Address address) throws CustomExcepHandler {
		if(collegeRepository.findByCollegeCode(collegeCode)== null) {
			throw new CustomExcepHandler("No college Found with the given Code");
		}else {
			if( collegeRepository.findByCollegeCode(collegeCode).getAddress()== null) {
				return addressRepository.save(address);
			}else {
				throw new CustomExcepHandler("No Addresses Found ");
			}
		}
		
	}

	@Override
	public Address updateAddressOfUniversity(String universityCode, Address address) throws CustomExcepHandler {
		if(universityRepository.findByUniversityCode(universityCode)== null) {
			throw new CustomExcepHandler("No college Found with the given Code");
		}else {
			if( universityRepository.findByUniversityCode(universityCode).getAddress()== null) {
				return addressRepository.save(address);
			}else {
				throw new CustomExcepHandler("No Addresses Found ");
			}
		}
	}

	/*---------------------------------------DELETE---------------------------------------------------- */
	@Override
	public String deleteAddressOfCollege(String ClgCode) throws CustomExcepHandler {
		return null;
	}

	
	/*---------------------------------------END---------------------------------------------------- */
}
