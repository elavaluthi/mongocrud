package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.example.demo.model.User;

public interface UserRepository extends MongoRepository<User, Integer> {
	User findByemailId(String emailId);
	 User findByemailIdAndPassword(String emailId,String password);
	

}
