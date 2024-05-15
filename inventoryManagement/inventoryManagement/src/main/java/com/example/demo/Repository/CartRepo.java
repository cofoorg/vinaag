package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Cart;

public interface CartRepo extends JpaRepository<Cart,String>{
	@Query(value = "select * from Cart where sku=?",nativeQuery=true)
	Cart findBySku(String sku);
	
	@Query(value="select price from Cart",nativeQuery=true)
	List<Integer> totalPrice();
	
//	@Query(value="select * from Cart where user_id=?",nativeQuery=true)
//	List<Cart> findCartByUserId(String userId);
	
}
