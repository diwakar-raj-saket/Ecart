package com.ecart.caseStudy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecart.caseStudy.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Integer>{

}
