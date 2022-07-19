package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
	
}
