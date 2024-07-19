package com.ey.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ey.model.User1;

import java.util.*;


public interface Loginrepo extends CrudRepository<User1, String> {
	@Query(value = "select * from use1r", nativeQuery = true)
	public List<User1> getUsers();
	
	@Query("select u from User1 u where u.userName=:n")
	public User1 getUserBYUserName(@Param("n") String userName);
	
	@Query("select u.userPass from User1 u where u.userName=:n")
	public String getUserPassBYUserName(@Param("n") String userName);
	

}