package com.ey.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.exception.ResourceNotFoundException;
import com.ey.model.Prouse;
import com.ey.model.User1;
import com.ey.repository.User1repo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/project/store")  //http://localhost:8085/project/store/
public class User1controller {
	@Autowired
	private User1repo userrepo;
	
	@GetMapping("/users1")
	public List<User1> getAllUsers(){
		return userrepo.findAll();
	}
	
	@GetMapping("/users1/{id}")
	public ResponseEntity<User1> getUserById(@PathVariable String id) {
		User1 user = userrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/users1")
	public User1 createEmployee(@RequestBody User1 user) {
		return userrepo.save(user);
	}
	

}
