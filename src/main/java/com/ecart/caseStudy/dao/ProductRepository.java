package com.ecart.caseStudy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecart.caseStudy.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>	{
	List<Product> findAllByCategory(String category);
}
