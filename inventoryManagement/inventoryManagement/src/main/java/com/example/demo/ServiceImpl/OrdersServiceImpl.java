package com.example.demo.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.OrdersRepo;
import com.example.demo.Service.OrdersService;
import com.example.demo.model.Card;
import com.example.demo.model.Cart;
import com.example.demo.model.Orders;

@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	private OrdersRepo ordersRepo;

	@Override
	public Orders getOrdersByOrderNo(Long orderNo) {
		
		return ordersRepo.findByOrderNo(orderNo);
	}
	
	@Override
	public Orders findInvoiceByOrderNo(Long orderNo) {
		return ordersRepo.findInvoiceByOrderNo(orderNo);
	}

	@Override
	public Orders getOrderByInvoiceNo(Long invoiceNo) {
		
		return ordersRepo.findByInvoiceNo(invoiceNo);
	}

	@Override
	public Orders addOrder(Orders order) {

		return ordersRepo.save(order);
	}

	@Override
	public Orders update(Long orderNo, Orders order) {
		
		Orders s3=ordersRepo.findByOrderNo(orderNo);
		
//		s3.setOrderNo(order.getOrderNo());
		s3.setAmount(order.getAmount());
		s3.setCgst(order.getCgst());
		s3.setDate(order.getDate());
		s3.setSgst(order.getSgst());
		s3.setTotalAmount(order.getTotalAmount());
		s3.setItems(order.getItems());
		s3.setPaymentMode(order.getPaymentMode());
		
		return ordersRepo.save(s3);
	}

	@Override
	public void delete(Long invoiceNo) {
		ordersRepo.deleteById(invoiceNo);
		
	}

	@Override
	public List<Orders> getAll() {
		
		return ordersRepo.findAll();
	}

//	@Override
//	public List<Long> findInvoicesByUserId(String userId) {
//		
//		return ordersRepo.findInvoicesByUserId(userId);
//	}
	
	
}
