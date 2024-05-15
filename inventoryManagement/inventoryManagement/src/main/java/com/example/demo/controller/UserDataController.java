package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserDataService;
import com.example.demo.model.UserData;

@RestController
@CrossOrigin
public class UserDataController {
	@Autowired
	UserDataService userDataService;
	
	@GetMapping("/user")
	public UserData getUser(@RequestParam String userId) {
		
		return userDataService.getUserByUserId(userId); 
	}
	
	@PostMapping("/user")
	public UserData addUser(@RequestBody UserData user) {
		
		return userDataService.addUser(user);
	}
	
	@PutMapping("/user/{userId}")
	public UserData update(@PathVariable String userId , @RequestBody UserData user ) {
		
		return userDataService.updateUser(userId,user);
	}
	@DeleteMapping("/user/{userId}")
	public String delete(@PathVariable String userId) {
		userDataService.delete(userId);
		return "data deleted";
	}
	
	@GetMapping("/userdata")
	public List<UserData> getAll() {
		return userDataService.getAll();
	}
	
}

