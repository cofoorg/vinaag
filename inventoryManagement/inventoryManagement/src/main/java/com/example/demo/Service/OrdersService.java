package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Cart;
import com.example.demo.model.Orders;

public interface OrdersService {
	public Orders getOrdersByOrderNo(Long orderNo);
	public Orders getOrderByInvoiceNo(Long invoiceNo);
	public Orders addOrder(Orders order);
	public Orders update(Long orderNo,Orders order);
	public void delete(Long invoiceNo);
	public List<Orders> getAll();
	public Orders findInvoiceByOrderNo(Long orderNo);
//	public List<Long> findInvoicesByUserId(String userId);
}
