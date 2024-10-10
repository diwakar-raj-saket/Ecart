package com.ecart.caseStudy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.caseStudy.DTO.ProductRequest;
import com.ecart.caseStudy.entity.Product;
import com.ecart.caseStudy.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;

	@PostMapping("/products/addProduct")
	public ResponseEntity<?> addProduct(@RequestBody ProductRequest request){
		Optional<Product> product = productService.addProduct(request);
		if(product.isPresent()) {
			return ResponseEntity.ok(product.get());
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping("/products/update")
	public ResponseEntity<?> updateProduct(@RequestBody Product request){
		Optional<Product> product = productService.updateProduct(request);
		if(product.isPresent()) {
			return ResponseEntity.ok(product);
		}
		else return ResponseEntity.notFound().build();
	}
	@GetMapping("/products/getById/{productId}")
	public ResponseEntity<?> getProduct(@PathVariable int productId){
		Product product = productService.getProduct(productId);
		return ResponseEntity.ok(product);
	}
	@GetMapping("/products/{category}")
	public ResponseEntity<?>getProductByCategory(@PathVariable String category){
		List<Product> products = productService.getProductsByCategory(category);
		return ResponseEntity.ok(products);
	}
	
}
