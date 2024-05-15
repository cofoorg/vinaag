package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.UserData;

public interface UserDataService {
	public UserData getUserByUserId(String userId);
	public UserData addUser(UserData user);
	public UserData updateUser(String userId,UserData user);
	public void delete(String userId);
	public List<UserData> getAll(); 
}

