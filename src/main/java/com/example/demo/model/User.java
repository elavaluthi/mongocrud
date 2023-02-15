package com.example.demo.model;

import org.springframework.aot.generate.GeneratedTypeReference;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private String emailId;
	private String name;
	private String password;
	

}
