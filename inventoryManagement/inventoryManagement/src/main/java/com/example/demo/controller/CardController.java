package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CardService;
import com.example.demo.model.Card;

@RestController
@CrossOrigin
public class CardController {
	@Autowired
	CardService cardService;
	
	@GetMapping("/usercards")
	public Optional<Card> getCardByUserId(@RequestParam String userId) {
		return cardService.getCardsByUserId(userId); 
	}
	
	@PostMapping("/card")
	public Card addCard(@RequestBody Card card) {
		return cardService.addCard(card);
	}
	
	@GetMapping("/card")
	public Card getCard(@RequestParam Long cardNo) {
		return cardService.findByCardNo(cardNo);
	}
	
	@DeleteMapping("/card/{cardNo}")
	public String delete(@PathVariable Long cardNo) {
		cardService.delete(cardNo);
		return "data deleted";
	}
	
	@GetMapping("/allcards")
	public List<Card> getAll() {
		return cardService.getAll();
	}
	
}

