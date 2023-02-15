package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;

import com.example.demo.model.User;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/signupservice")
	
	public User signup(@RequestBody User user) throws Exception{
		String tempemailid=user.getEmailId();
		if (tempemailid !=null && !"".equals(tempemailid)) {
			User adminobj =service.fetchbyemailId(tempemailid);
			  if (adminobj !=null) {
				  throw new Exception("it is already"+tempemailid+"exists"); 
			  }
			
		}
		User adminobj = null;
		adminobj=service.save(user);
		return adminobj;
		
	}
	@PostMapping("/adminlogin")
	public User login(@RequestBody User user )throws Exception{
		String tempemail=user.getEmailId();
		String temppassword=user.getPassword();
		User adminobj=null;
		if(tempemail!=null && temppassword !=null) {
			adminobj= service.fetchByEmailIdAndPassword(tempemail, temppassword);
		}
		if(adminobj == null) {
			throw new Exception("bad crential");
		}
		return adminobj;
	}
	
	
	

}
