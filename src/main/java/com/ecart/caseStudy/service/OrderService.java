package com.ecart.caseStudy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.caseStudy.dao.OrderItemRepository;
import com.ecart.caseStudy.dao.OrderRepository;
import com.ecart.caseStudy.entity.Cart;
import com.ecart.caseStudy.entity.CartItem;
import com.ecart.caseStudy.entity.Order;
import com.ecart.caseStudy.entity.OrderItem;
import com.ecart.caseStudy.entity.User;

@Service
public class OrderService {
	@Autowired
	UserService userService;
	@Autowired
	OrderItemRepository orderItemRepository;
	@Autowired
	OrderRepository orderRepository;
    public Order createOrder(int userId){
    	Optional<User> user = userService.getProfile(userId);
		User user1 = user.get();
		Cart cart = user1.getCart();
		List<CartItem>cartItems = cart.getCartItems();
		Order order = new Order();
		order.setUser(user1);
		order.setOrderStatus("Ordered");
		Order order1 = orderRepository.save(order);
		OrderItem orderItem = new OrderItem();
		for(CartItem item:cartItems) {
			orderItem.setOrder(order1);
			orderItem.setProduct(item.getProduct());
			orderItem.setQuantity(item.getQuantity());
			orderItemRepository.save(orderItem);
		}
   
		
		return order1;
    }
    public List<Order> getOrderHistory(int userId){
    	Optional<User> user = userService.getProfile(userId);
		User user1 = user.get();
		List<Order>orders = user1.getOrders();   
		return orders;
    }
}
