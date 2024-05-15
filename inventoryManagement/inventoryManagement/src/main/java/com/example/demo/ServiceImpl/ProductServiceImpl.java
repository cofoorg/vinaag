package com.example.demo.ServiceImpl;

import java.util.List;
import com.example.demo.Exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ProductRepo;
import com.example.demo.Service.ProductService;
import com.example.demo.model.Product;


@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepo productRepo;
	
	@Override
	public Product getProduct(String name) {
		Product s = productRepo.findByName(name);
		if(s!=null) {
			 return s; 
	 }else {
		 throw new ResourceNotFoundException();
	 }
		
	}
	
	@Override
	public Product addProduct(Product product) {
		Product s1=productRepo.findBySku(product.getSku());
		if(s1==null) {
			return  productRepo.save(product);
		}else {
			throw new ResourceNotFoundException();
		}
	}
	
	@Override
	public Product update(String sku,Product product) {
		Product s1 = productRepo.findBySku(sku);
		
		if(s1!=null) {
			s1.setSku(product.getSku());   // old to new set
			s1.setPrice(product.getPrice());
			s1.setDescription(product.getDescription());
			s1.setName(product.getName());
		return productRepo.save(s1);
		} 
		else 
		{
			throw new ResourceNotFoundException();
		} 
	}
	
	@Override
	public void delete(String sku) {
		Product s2 = productRepo.findBySku(sku);
		if(s2!=null) {
			productRepo.delete(s2);
		}
		else {
			throw new ResourceNotFoundException();
		}
			
		
	}
	
	@Override
	public List<Product> getAll(){
		return (List<Product>) productRepo.findAll();
	}

	@Override
	public Product getProductBySku(String sku) {
		
		return productRepo.findBySku(sku);
	}
}
