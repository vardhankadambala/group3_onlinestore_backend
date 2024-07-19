package com.ey.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ey.model.Prouse;

import java.util.*;


public interface Prouserepo extends CrudRepository<Prouse, Long> {
	
	@Query(value = "select * from prouse1", nativeQuery = true)
	public List<Prouse> getProUsers();
	
	
	@Query("select u from Prouse u where u.userName=:n")
	public List<Prouse> getProUserBYUserName(@Param("n") String userName);
	
	@Query("delete from Prouse u where u.userName=:n")
	public List<Prouse> deleteByUserName(@Param("n") String userName);
	
	@Query("select u from Prouse u where u.proName=:n")
	public Prouse getProUserBYProName(@Param("n") String proName);

}
