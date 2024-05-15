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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CartService;
import com.example.demo.model.Cart;

@RestController
@CrossOrigin
public class CartController {
	@Autowired
	CartService cartService;
	
	@PostMapping("/cart")
	public Cart addProduct(@RequestBody Cart product) {
		
		return cartService.addProduct(product);
	}
	
	@PutMapping("/cart/{sku}")
	public Cart update(@PathVariable String sku , @RequestBody Cart product ) {
		
		return cartService.update(sku,product);
	}
	@DeleteMapping("/cart/{sku}")
	public String delete(@PathVariable String sku) {
		cartService.delete(sku);
		return "data deleted";
	}
	
	@GetMapping("/cartproducts")
	public List<Cart> getAll() {
		return cartService.getAll();
	}
	
//	@GetMapping("/{userId}")
//	public List<Cart> findCartByUserId(@PathVariable String userId){
//		return cartService.findCartByUserId(userId);
//	}
	
	@GetMapping("/amount")
	public List<Integer> totalPrice() {
		return cartService.totalPrice();
	}

}
