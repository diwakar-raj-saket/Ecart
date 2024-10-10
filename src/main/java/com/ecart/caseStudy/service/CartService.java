package com.ecart.caseStudy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.caseStudy.dao.CartItemRepository;
import com.ecart.caseStudy.dao.CartRepository;
import com.ecart.caseStudy.entity.Cart;
import com.ecart.caseStudy.entity.CartItem;
import com.ecart.caseStudy.entity.Product;
import com.ecart.caseStudy.entity.User;

@Service
public class CartService {
	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	CartItemRepository cartItemRepository;

	public CartItem addToCart(int quantity, int UserId, int ProductId) {
		CartItem addedItem;
		Optional<User> user = userService.getProfile(UserId);
		User user1 = user.get();
		Product product = productService.getProduct(ProductId);
		System.out.println("till here0");
		Cart cart = user1.getCart();
		if (cart == null) {
			cart = new Cart();
			cart.setUser(user1);
			cartRepository.save(cart);
			System.out.println("till here0.01");
		}

		CartItem existingCartItem = cartItemRepository.findByCartAndProduct(cart, product);

		if (existingCartItem != null) {
			if(quantity==0)quantity++;
			quantity+=	existingCartItem.getQuantity();
			existingCartItem.setQuantity(quantity);
			addedItem = cartItemRepository.save(existingCartItem);
			System.out.println("till here1");

		} else {
			CartItem cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setQuantity(1);
			cartItem.setCart(cart);
			addedItem = cartItemRepository.save(cartItem);
			System.out.println("till here2");	
		}
		System.out.println("till here3");	
		return addedItem;
	}

	public String removeFromCart(int UserId, int ProductId) {

		Optional<User> user = userService.getProfile(UserId);
		User user1 = user.get();
		Product product = productService.getProduct(ProductId);
		Cart cart = user1.getCart();
		CartItem itemToRemove = cartItemRepository.findByCartAndProduct(cart, product);
		cartItemRepository.delete(itemToRemove);
		return itemToRemove.getProduct().getName();
	}

	public Cart getCart(int userId) {
		Optional<User> user = userService.getProfile(userId);
		User user1 = user.get();
		Cart cart = user1.getCart();
		return cart;
	}

}
