package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;

import com.example.demo.model.User;

@Service
public class UserService {
	@Autowired
	 private UserRepository repo;
	
	public User save(User user) {
		 return repo.save(user);
	 }
	public User fetchbyemailId(String emailId) {
		 return repo.findByemailId(emailId);
	 }
	public User fetchByEmailIdAndPassword(String emailId,String password) {
		 return repo.findByemailIdAndPassword(emailId, password);
	 }
	

}
