package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.OrdersService;
import com.example.demo.model.Cart;
import com.example.demo.model.Orders;

@RestController
@CrossOrigin
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	@GetMapping("/orders")
	public Orders getOrderByInvoiceNo(@RequestParam Long invoiceNo) {
		return ordersService.getOrderByInvoiceNo(invoiceNo); 
	}
	
	@PostMapping("/orders")
	public Orders addProduct(@RequestBody Orders order) {
		return ordersService.addOrder(order);
	}
	
	@GetMapping("/order/{orderNo}")
	public Orders findInvoiceByOrderNo(@PathVariable Long orderNo) {
		return ordersService.findInvoiceByOrderNo(orderNo);
	} 
	
	@PutMapping("/orders/{orderNo}")
	public Orders update(@PathVariable Long orderNo , @RequestBody Orders order ) {
		return ordersService.update(orderNo,order);
	}
	
	@DeleteMapping("/orders/{invoiceNo}")
	public String delete(@PathVariable Long invoiceNo) {
		ordersService.delete(invoiceNo);
		return "data deleted";
	}
	
	@GetMapping("/allOrders")
	public List<Orders> getAll() {
		return ordersService.getAll();
	}
//	
	@GetMapping("/orders/{userId}")
	public Orders getOrdersByOrderNo(@PathVariable Long orderNo) {
		return ordersService.getOrdersByOrderNo(orderNo);
	}
}
