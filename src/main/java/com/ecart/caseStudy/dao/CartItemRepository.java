package com.ecart.caseStudy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecart.caseStudy.entity.Cart;
import com.ecart.caseStudy.entity.CartItem;
import com.ecart.caseStudy.entity.Product;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    CartItem findByCartAndProduct(Cart cart, Product product);

}

