package com.ey.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.exception.ResourceNotFoundException;
import com.ey.model.User1;
import com.ey.repository.Loginrepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/project/store")  //http://localhost:8085/project/store/
public class Logincontroll {
	@Autowired
	private Loginrepo loginrepo;

	@GetMapping("/login/{userName}")
	public User1 getUserByUserName(@PathVariable String userName) {
		User1 user=loginrepo.findById(userName)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with Username :" + userName));;
				return user;
	}

	@GetMapping("/login1/{userName}/{userPass}")
    public String loginByUserName(@PathVariable String userName, @PathVariable String userPass) {
		User1 user=loginrepo.findById(userName)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with Username :" + userName));;;
		String pass=user.getUserPass();
		String response="";
		 if ( pass.equals(userPass)){
			 
			 response="sucess";
			 } 
		 else {
				 response="fail";	
	     }
	
		return response;
		
	}
}
