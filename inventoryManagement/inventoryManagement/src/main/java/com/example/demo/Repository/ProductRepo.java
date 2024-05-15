package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{
	@Query(value = "select * from Product where name=?",nativeQuery=true)
	Product findByName(String name);
	
	@Query(value = "select * from Product where sku=?",nativeQuery=true)
	Product findBySku(String sku);
}
