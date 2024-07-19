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
import com.ey.model.User;
import com.ey.repository.Userrepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/project/store")  //http://localhost:8085/project/store/
public class Usercontroller {
	@Autowired
	private Userrepo userrepo;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userrepo.findAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = userrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/users")
	public User createEmployee(@RequestBody User user) {
		return userrepo.save(user);
	}
	

}
