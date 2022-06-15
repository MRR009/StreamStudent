package com.stg.serviceinterfaces;

import java.util.List;

import com.stg.entity.Address;
import com.stg.exception.CustomExcepHandler;

public interface AddressService {
	
	public abstract Address addAddress(Address address )throws CustomExcepHandler;
	
	public abstract Address addAddressToCollege(Address address, String collegeCode)throws CustomExcepHandler;
	
	public abstract Address addAddressToUniversity(Address address, String universityCode)throws CustomExcepHandler;
	
	public abstract Address readAddressOfCollege(String collegeCode)throws CustomExcepHandler;
	
	public abstract Address readAddressOfUniversity(String univeristyCode)throws CustomExcepHandler;
	
	public abstract List<Address> getAllAddresses()throws CustomExcepHandler;  
	
	public abstract Address updateAddressOfCollege(String collegeCode, Address address)throws CustomExcepHandler;
	
	public abstract Address updateAddressOfUniversity(String universityCode, Address address)throws CustomExcepHandler;
	
	public abstract String deleteAddressOfCollege(String ClgCode)throws CustomExcepHandler;
	
}
