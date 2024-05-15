package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.CardRepo;
import com.example.demo.Repository.OrdersRepo;
import com.example.demo.Repository.UserDataRepo;
import com.example.demo.Service.UserDataService;
import com.example.demo.model.UserData;
@Service
public class UserDataServiceImpl implements UserDataService{
	@Autowired
	private UserDataRepo userDataRepo;
//	@Autowired
//	private OrdersRepo ordersRepo;
//	@Autowired 
//	private CardRepo cardRepo;
	
	
	@Override
	public UserData getUserByUserId(String userId) {
		UserData s = userDataRepo.findByUserId(userId);
		if(s!=null) {
			 return s; 
	 }else {
		 throw new ResourceNotFoundException();
	 }
	}

	@Override
	public UserData addUser(UserData user) {
		UserData s1=userDataRepo.findByUserId(user.getUserId());
//		s1.setCardNo(cardRepo.findCardsByuserId(user.getUserId()));
//		s1.setInvoiceNo(ordersRepo.findInvoicesByUserId(user.getUserId()));
		
		if(s1==null) {
			return  userDataRepo.save(s1);
		}else {
			throw new ResourceNotFoundException();
		}
	}

	@Override
	public UserData updateUser(String userId, UserData user) {
		UserData s1 = userDataRepo.findByUserId(userId);
		
		if(s1!=null) {
			s1.setUserName(user.getUserName());   // old to new set
			s1.setPassword(user.getPassword());
			s1.setAddress(user.getAddress());
			s1.setPhoneNo(user.getPhoneNo());
			s1.setUserEmail(user.getUserEmail());
//			s1.setCardNo(cardRepo.findCardsByuserId(userId));
//			s1.setInvoiceNo(ordersRepo.findInvoicesByUserId(userId));
		return userDataRepo.save(s1);
		} 
		else 
		{
			throw new ResourceNotFoundException();
		}
	}

	@Override
	public void delete(String userId) {
		UserData s1=userDataRepo.findByUserId(userId);
		userDataRepo.delete(s1);
	}

	@Override
	public List<UserData> getAll() {
		return userDataRepo.findAll();
	}

}


