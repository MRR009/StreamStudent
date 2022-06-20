package com.stg.entity;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.stg.entity.University;

public class MySerializer extends StdSerializer<University> {
	
	public MySerializer() {
		this(null);
	}

	protected MySerializer(Class<University> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void serialize(University value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}
