package com.ecart.caseStudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.caseStudy.entity.Order;
import com.ecart.caseStudy.service.CartService;
import com.ecart.caseStudy.service.OrderService;
import com.ecart.caseStudy.service.ProductService;
import com.ecart.caseStudy.service.UserService;

@RestController
public class OrderController {
	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;
	@Autowired 
	CartService cartService;
	@Autowired
	OrderService orderService;
	
	@GetMapping("/order/{userId}/createOrder")
	public ResponseEntity<?>createOrder(@PathVariable int userId){
		Order order = orderService.createOrder(userId);
		return ResponseEntity.ok(order);
	}
	@GetMapping("/order/{userId}/getOrders")
	public ResponseEntity<?>getOrderHistory(@PathVariable int userId){
		List<Order>orders = orderService.getOrderHistory(userId);
		return ResponseEntity.ok(orders);
	}
}
