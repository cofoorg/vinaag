package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Card;

public interface CardService {
	public Optional<Card> getCardsByUserId(String sku);
	public Card addCard(Card product);
	public Card findByCardNo(Long cardNo);
	public void delete(Long cardNo);
	public List<Card> getAll();
	public List<Long> findCardsByUserId(String userId);
}
