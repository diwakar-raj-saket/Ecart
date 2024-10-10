package com.ecart.caseStudy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.caseStudy.DTO.ProductRequest;
import com.ecart.caseStudy.dao.ProductRepository;
import com.ecart.caseStudy.entity.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductService {
    
	@Autowired
	ProductRepository productRepository;
	public Optional<Product> addProduct(ProductRequest request) {
		Product product = new Product();
		product.setName(request.getName());
		product.setPrice(request.getPrice());
		product.setCategory(request.getCategory());
		product.setDetail(request.getDetail());
		product.setBrand(request.getBrand());
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            product.setSubCategory(objectMapper.writeValueAsString(request.getSubCategory()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
		Product product1 = productRepository.save(product);
		return Optional.ofNullable(product1);
	}
	public Optional<Product> updateProduct(Product request) {
		Product product = productRepository.save(request);
		
		return Optional.ofNullable(product);
	}
	public Product getProduct(int productId) {
		Optional<Product> product = productRepository.findById(productId);
		return product.get();
	}

	public List<Product> getProductsByCategory(String category){
		List<Product> products = productRepository.findAllByCategory(category);
		return products;
	}
}
