package com.ecart.caseStudy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecart.caseStudy.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer>{

}
