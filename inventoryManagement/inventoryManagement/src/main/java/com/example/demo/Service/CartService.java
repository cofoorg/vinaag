package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Cart;


public interface CartService {
	public Cart addProduct(Cart product);
	public Cart update(String sku,Cart product);
	public void delete(String sku);
	public List<Cart> getAll();
	public List<Integer> totalPrice();
//	public List<Cart> findCartByUserId(String userId);
}
