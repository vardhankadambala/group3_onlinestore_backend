package com.ey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ey.model.User;

@Repository
public interface Userrepo extends JpaRepository<User, Long>  {
	
}
