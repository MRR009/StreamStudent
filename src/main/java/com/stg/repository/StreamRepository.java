package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.Stream;

public interface StreamRepository extends JpaRepository<Stream, Integer> {

	public Stream findByStreamCode(String streamCode);

	public Stream findBystreamName(String streamName);

	public String removeByStreamCode(String streamCode);
}
