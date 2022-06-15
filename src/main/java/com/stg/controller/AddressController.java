package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Address;
import com.stg.exception.CustomExcepHandler;
import com.stg.serviceinterfaces.AddressService;

@CrossOrigin(value="http://localhost:4200/")
@RestController
@RequestMapping(value = "address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	/*---------------------------------------CREATE---------------------------------------------------- */
	@PostMapping(value="add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Address addAddress(@RequestBody Address address) {
		return addressService.addAddress(address);
	}
	
	@PostMapping(value="addcollegeaddress", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Address addAddressToCollege(@RequestBody Address address,@RequestParam String collegeCode) {
		return addressService.addAddressToCollege(address, collegeCode);
	}
	
	@PostMapping(value="adduniversityaddress", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Address addAddressToUniversity(@RequestBody Address address,@RequestParam String universityCode) {
		return addressService.addAddressToUniversity(address, universityCode);
	}
	
	/*---------------------------------------READ---------------------------------------------------- */

	@GetMapping(value="getcollegeaddress")
	public Address readAddressOfCollege(@RequestParam String collegeCode) {
		return addressService.readAddressOfCollege(collegeCode);
	}
	
	@GetMapping(value="getuniversityaddress")
	public Address readAddressOfUniversity(@RequestParam String univeristyCode) {
		return addressService.readAddressOfUniversity(univeristyCode);
	}
	
	@GetMapping(value="getalladdresses")
	public List<Address> getAllAddresses(){
		return addressService.getAllAddresses();
	}
	
	/*---------------------------------------UPDATE---------------------------------------------------- */
	
	@PutMapping(value="updatecollegeaddress", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Address updateAddressOfCollege(@RequestParam String collegeCode,@RequestBody Address address) {
		return addressService.updateAddressOfCollege(collegeCode, address);
	}
	
	@PutMapping(value="updateuniversityaddress", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Address updateAddressOfUniversity(@RequestParam String universityCode,@RequestBody Address address) {
		return addressService.updateAddressOfUniversity(universityCode, address);
	}
	
	/*---------------------------------------DELETE---------------------------------------------------- */
	
	public String deleteAddressOfCollege(String ClgCode){
		
		return null;
	}

	
	/*---------------------------------------END---------------------------------------------------- */
}
