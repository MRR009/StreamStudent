package com.stg.serviceinterfaces;

import org.springframework.web.multipart.MultipartFile;

import com.stg.entity.Image;
import com.stg.exception.CustomIOException;

public interface ImageService {
	
	public abstract Image uploadImage(MultipartFile imageFile) throws CustomIOException;
}
