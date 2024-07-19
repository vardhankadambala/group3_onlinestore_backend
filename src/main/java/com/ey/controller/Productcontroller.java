package com.ey.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.model.Product;
import com.ey.repository.Productrepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/project/store")
public class Productcontroller {
	@Autowired
	private Productrepo productrepo;
	
	@GetMapping("/products")
	public List<Product> getAllEmployees(){
		return productrepo.findAll();
	}
	
	@PostMapping("/products")
	public Product createEmployee(@RequestBody Product product) {
		return productrepo.save(product);
	}
	
}
