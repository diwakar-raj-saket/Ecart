package com.ecart.caseStudy.DTO;

import java.util.List;

public class ProductRequest {

	private String name;
	private double price;
	private String detail;
	private String brand;
	private String category;
	private List<String> subCategory;
	public ProductRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<String> getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(List<String> subCategory) {
		this.subCategory = subCategory;
	}
	

}
