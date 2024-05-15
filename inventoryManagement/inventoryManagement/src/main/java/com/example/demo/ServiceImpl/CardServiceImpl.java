package com.example.demo.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CardRepo;
import com.example.demo.Service.CardService;
import com.example.demo.model.Card;

@Service
public class CardServiceImpl implements CardService{
	@Autowired
	CardRepo cardRepo;
	
	@Override
	public Optional<Card> getCardsByUserId(String userId) {
		Optional<Card> s1 =cardRepo.findByUserId(userId);
		return s1;
	}
	
	@Override
	public List<Long> findCardsByUserId(String userId){
		return cardRepo.findCardsByuserId(userId);
	}
	
	@Override
	public Card findByCardNo(Long cardNo) {
		Card s3=cardRepo.findByCardNo(cardNo);
		return s3;
	}

	@Override
	public Card addCard(Card product) {
		// TODO Auto-generated method stub
		return cardRepo.save(product);
	}

//	

	@Override
	public void delete(Long cardNo) {
		// TODO Auto-generated method stub
		Card s4=cardRepo.findByCardNo(cardNo);
		cardRepo.delete(s4);
	}

	@Override
	public List<Card> getAll() {
		// TODO Auto-generated method stub
		return cardRepo.findAll();
	}

}

