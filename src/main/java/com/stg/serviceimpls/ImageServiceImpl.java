package com.stg.serviceimpls;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stg.entity.Image;
import com.stg.exception.CustomExcepHandler;
import com.stg.exception.CustomIOException;
import com.stg.repository.ImageRepository;
import com.stg.serviceinterfaces.ImageService;

@Service
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	ImageRepository imageRepository;

	@Override
	public Image uploadImage(MultipartFile imageFile) throws CustomIOException {
		Image image = new Image();
		try {
			image.setImageName(imageFile.getOriginalFilename());
			image.setImageType( imageFile.getContentType()); 
			image.setPic(imageFile.getBytes()); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return imageRepository.save(image);
	}

}
