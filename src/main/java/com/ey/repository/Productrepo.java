package com.ey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ey.model.Product;

@Repository
public interface Productrepo extends JpaRepository<Product, Long> {

}
