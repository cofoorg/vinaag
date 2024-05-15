package com.example.demo.controller;

import com.example.demo.Service.StripePaymentService;
import com.example.demo.model.CardPaymentRequest;
import com.example.demo.model.UpiPaymentRequest;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StripePaymentController {

    @Autowired
    private StripePaymentService stripePaymentService;

    @PostMapping("/payment/card/create")
    public ResponseEntity<String> createPaymentIntentForCard(@RequestBody CardPaymentRequest cardPaymentRequest) {
        try {
            String clientSecret = stripePaymentService.createPaymentIntentForCard(cardPaymentRequest);
            return ResponseEntity.ok(clientSecret);
        } catch (StripeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/payment/upi/create")
    public ResponseEntity<String> createPaymentIntentForUpi(@RequestBody UpiPaymentRequest upiPaymentRequest) {
        try {
            String clientSecret = stripePaymentService.createPaymentIntentForUpi(upiPaymentRequest);
            return ResponseEntity.ok(clientSecret);
        } catch (StripeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
