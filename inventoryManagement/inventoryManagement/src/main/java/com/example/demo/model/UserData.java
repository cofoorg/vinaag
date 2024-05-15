package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userdata")
public class UserData {
	@Id
	private String userId;
	private String userName;
	private String password;
	private String address;
	private Long phoneNo;
	private String userEmail;
//	private List<Long> cardNo;
//	private List<Long> invoiceNo;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
//	public List<Long> getCardNo() {
//		return cardNo;
//	}
//	public void setCardNo(List<Long> cardNo) {
//		this.cardNo = cardNo;
//	}
//	public List<Long> getInvoiceNo() {
//		return invoiceNo;
//	}
//	public void setInvoiceNo(List<Long> invoiceNo) {
//		this.invoiceNo = invoiceNo;
//	}
	
	
}

