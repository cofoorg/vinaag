package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Product;


public interface ProductService {
	public Product getProductBySku(String sku);
	public Product getProduct(String name);
	public Product addProduct(Product product);
	public Product update(String sku,Product product);
	public void delete(String sku);
	public List<Product> getAll();
}
