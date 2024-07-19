package com.ey.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.exception.ResourceNotFoundException;
import com.ey.model.Prouse;
import com.ey.repository.Prouserepo;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/project/store")  //http://localhost:8085/project/store/
public class Prousecontroller {
	@Autowired
	private Prouserepo prouserepo;
	
	@GetMapping("/prouse")
	public List<Prouse> getAllUsers(){
		return prouserepo.getProUsers();
	}
	
	@PostMapping("/prouse")
	public Prouse createEmployee(@RequestBody Prouse prouse) {
		int val=prouse.getProPrice()*prouse.getProQty();
		prouse.setProPrice(val);
		return prouserepo.save(prouse);
	}
	
	@GetMapping("/prouse/{userName}")
	public List<Prouse> getUserByUsername(@PathVariable String userName){
		List<Prouse> l=prouserepo.getProUserBYUserName(userName);
		return l;
	}
	
	
	@PutMapping("/prouse/{id}/{proQty}")
	public ResponseEntity<Prouse> updateQty(@PathVariable Long id, @PathVariable Integer proQty){
		Prouse user = prouserepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		//System.out.println(user);
		
		int a=user.getProPrice()/user.getProQty();
		System.out.println(a);
		user.setProQty(proQty);
		int val=a*user.getProQty();
		user.setProPrice(val);
		Prouse updateduser = prouserepo.save(user);

		return ResponseEntity.ok(updateduser);
	}
	
	@Transactional
	@DeleteMapping("/prousername")
	public ResponseEntity<Map<String, Boolean>> BuyAllProducts(){
		prouserepo.deleteAll();
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@Transactional
	@DeleteMapping("/prouserid/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id){
		Prouse prouse =prouserepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		prouserepo.delete(prouse);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
	}
	
}
