package com.example.demo.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Card;
@Repository
public interface CardRepo extends JpaRepository<Card,Long>{
	@Query(value = "select * from cards where user_id=?",nativeQuery=true)
	Optional<Card> findByUserId(String userId);
	
	@Query(value="select * from cards where name-?",nativeQuery=true)
	Card findByName(String name);
	
	@Query(value="select * from cards where card_no-?",nativeQuery=true)
	Card findByCardNo(Long cardNo);
	
	@Query(value="select card_no from cards where user_id-?",nativeQuery=true)
	List<Long> findCardsByuserId(String userId);
	
}

