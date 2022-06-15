package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.Aspirant;

public interface AspirantRepository extends JpaRepository<Aspirant, Integer> {
	
	
	public Aspirant findByAspirantName(String studentName);
	
	public Aspirant findByAspirantEmail(String aspirantEmail);
	
	public Aspirant findByUsername(String username);
	
	public String deleteByUsername(String username);
}
