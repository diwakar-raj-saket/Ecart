package com.ecart.caseStudy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecart.caseStudy.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{

}
