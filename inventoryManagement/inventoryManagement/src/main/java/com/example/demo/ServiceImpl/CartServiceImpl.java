package com.example.demo.ServiceImpl;
import com.example.demo.Exception.ResourceNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CartRepo;
import com.example.demo.Service.CartService;
import com.example.demo.model.Cart;
@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepo cartRepo;
	
	@Override
	public Cart addProduct(Cart product) {
		return  cartRepo.save(product);
	}

	@Override
	public Cart update(String sku, Cart product) {
		Cart s1 = cartRepo.findBySku(sku);
		if(s1!=null) {
			s1.setQuantity(product.getQuantity());   // old to new set
		return cartRepo.save(s1);
		} 
		else 
		{
			throw new ResourceNotFoundException();
		} 
		
	}

	@Override
	public void delete(String sku) {
		Cart s2 = cartRepo.findBySku(sku);
		if(s2!=null) {
			cartRepo.delete(s2);
		}
		else {
			throw new ResourceNotFoundException();
		}
		
		
	}

	@Override
	public List<Cart> getAll() {
		return (List<Cart>) cartRepo.findAll();
	}
	
	@Override
	public List<Integer> totalPrice() {
		return cartRepo.totalPrice();
	}
	
//	@Override
//	public List<Cart> findCartByUserId(String userId){
//		return cartRepo.findCartByUserId(userId);
//	}

}
