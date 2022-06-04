package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.College;
import com.stg.entity.Stream;
import com.stg.serviceinterfaces.StreamService;
@CrossOrigin(value="http://localhost:4200/")
@RestController
@RequestMapping(value = "stream")
public class StreamController {

	@Autowired
	private StreamService streamService;

	/*---------------------------------------CREATE---------------------------------------------------- */

	@PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Stream createStream(@RequestBody Stream stream) {
		return streamService.createStream(stream);
	}

	@PostMapping(value = "addstreaminonecollege", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Stream addStreamInOneCollege(@RequestBody Stream stream,@RequestParam String collegeCode) {
		return streamService.addStreamInCollege(stream, collegeCode);
	}

	/*---------------------------------------READ---------------------------------------------------- */

	@GetMapping(value = "getbycode")
	public Stream readStreamByCode(@RequestParam String strmCode) {
		return streamService.readStreamByCode(strmCode);
	}

	@GetMapping(value = "getall")
	public List<Stream> getAllStreams() {
		return streamService.getAllStreams();
	}
	
	@GetMapping(value="collegeswithstream")
	public List<College> getCollegsWithStream(@RequestParam String strmCode){
		return streamService.getCollegesWithStream(strmCode);
	}

	/*---------------------------------------UPDATE---------------------------------------------------- */

	@PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Stream updateStream(@RequestBody Stream stream) {
		return streamService.updateStream(stream);
	}

	@PutMapping(value = "updatebycode")
	public Stream updateStreamByCode(@RequestParam String streamCode, @RequestParam String newName) {
		return streamService.upateStreamNameByCode(streamCode, newName);
	}

	/*---------------------------------------DELETE---------------------------------------------------- */

	@DeleteMapping(value = "deletebycode")
	public String deleteStreamByCode(@RequestParam String code) {
		return streamService.deleteStreamByCode(code);
	}

	/*---------------------------------------END---------------------------------------------------- */
}
