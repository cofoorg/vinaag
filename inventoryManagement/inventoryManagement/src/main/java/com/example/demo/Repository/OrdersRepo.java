package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cart;
import com.example.demo.model.Orders;

@Repository
public interface OrdersRepo extends JpaRepository<Orders,Long>{
	@Query(value = "select * from orders where invoice_no=?",nativeQuery=true)
	Orders findByInvoiceNo(Long invoiceNo);

//	@Query(value="select * from orders where order_no=?",nativeQuery=true)
//	Optional<Orders> findByOrderNo(Long orderNo);
	
	@Query(value="select order_no from orders where invoice_no=?",nativeQuery=true)
	List<Long> findInvoicesByUserId(String invoiceNo);
	
	@Query(value="insert into orders (amount,items) values(amount,order)",nativeQuery=true)
	Orders saveOrder(Long amount,List<Cart> order);
	
	@Query(value = "select * from orders where order_no=?",nativeQuery=true)
	Orders findInvoiceByOrderNo(Long orderNo);
	
	Orders findByOrderNo(Long orderNo);
}
