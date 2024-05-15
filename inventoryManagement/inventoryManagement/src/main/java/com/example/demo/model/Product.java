package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Product {
	@Id
	private String sku;
	private float price;
	private String description;
	private String name;
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float f) {
		this.price = f;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
