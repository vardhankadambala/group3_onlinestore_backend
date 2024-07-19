package com.ey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ey.model.User1;

@Repository
public interface User1repo extends JpaRepository<User1, String>  {
	
}
