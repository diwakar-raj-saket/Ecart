package com.ecart.caseStudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.caseStudy.DTO.ChangeQuantity;
import com.ecart.caseStudy.entity.Cart;
import com.ecart.caseStudy.entity.CartItem;
import com.ecart.caseStudy.service.CartService;

@RestController
public class CartController {
	@Autowired
	CartService cartService;
	@PostMapping("/cart/{userId}/add/{productId}")
	public ResponseEntity<?> addToCart(@PathVariable int userId, @PathVariable int productId){
		CartItem cartItem =cartService.addToCart( 0,userId, productId);
		return ResponseEntity.ok(cartItem);
	}
	@PostMapping("/cart/{userId}/changeQuantity/{productId}")
	public ResponseEntity<?> changeQuantity(@PathVariable int userId, @PathVariable int productId,@RequestBody ChangeQuantity quantity){
		CartItem cartItem =cartService.addToCart(quantity.getQuantity(), userId, productId);
		return ResponseEntity.ok(cartItem);
	}
	@PostMapping("/cart/{userId}/remove/{productId}")
	public  ResponseEntity<?> removeItem(@PathVariable int userId ,@PathVariable int productId){
		String productName = cartService.removeFromCart(userId,productId);
		return ResponseEntity.ok(productName);
	}
	@GetMapping("/cart/{userId}/getCart")
	public ResponseEntity<?> getCart(@PathVariable int userId){
	     Cart cart = cartService.getCart(userId);
		return ResponseEntity.ok(cart);
	}
}
