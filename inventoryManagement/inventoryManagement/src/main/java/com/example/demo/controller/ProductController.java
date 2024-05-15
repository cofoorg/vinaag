package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ProductService;
import com.example.demo.model.Product;

@RestController
@CrossOrigin
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/product")
	public Product login(@RequestParam String name) {
		
		return productService.getProduct(name); 
	}
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		
		return productService.addProduct(product);
	}
	
	@PutMapping("/product/{sku}")
	public Product update(@PathVariable String sku , @RequestBody Product product ) {
		
		return productService.update(sku,product);
	}
	@DeleteMapping("/product/{sku}")
	public String delete(@PathVariable String sku) {
		productService.delete(sku);
		return "data deleted";
	}
	
	@GetMapping("/allproducts")
	public List<Product> getAll() {
		return productService.getAll();
	}
	
	@GetMapping("/product/{sku}")
	public Product getProduct(@PathVariable String sku) {
		return productService.getProductBySku(sku);
	}
}
