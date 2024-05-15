package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserData;
@Repository
public interface UserDataRepo extends JpaRepository<UserData,String>{
	@Query(value = "select * from userdata where user_id=?",nativeQuery=true)
	UserData findByUserId(String userId);
	
}

