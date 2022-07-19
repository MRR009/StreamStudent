package com.stg.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stg.entity.Image;
import com.stg.exception.CustomIOException;
import com.stg.serviceinterfaces.ImageService;

@CrossOrigin(value="http://localhost:4200/")
@RestController
@RequestMapping(value = "image")
public class ImageController {
	
	ImageService imageService;
	
	@PostMapping(value= "upload", consumes = MediaType.ALL_VALUE)
	public Image uploadImage(@RequestPart MultipartFile imageFile) {
		
		Image img = new Image();
		
		try {
			img = imageService.uploadImage(imageFile);
		} catch (CustomIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
}
