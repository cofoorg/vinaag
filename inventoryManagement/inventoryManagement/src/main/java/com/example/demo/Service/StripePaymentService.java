package com.example.demo.Service;

import com.example.demo.model.CardPaymentRequest;
import com.example.demo.model.UpiPaymentRequest;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripePaymentService {

    @Value("sk_test_51PAmpwSDKdxIuryKrGEQ7G4vHwJbFqK6oNJaON43qIGGmiRsy2iK4pWtwiX94wdEdY8EFhsJf1doD7c6tpdj28vQ00gmmuLE4k")
    private String secretKey;

    public String createPaymentIntentForCard(CardPaymentRequest cardPaymentRequest) throws StripeException {
        Stripe.apiKey = secretKey;

        Map<String, Object> params = new HashMap<>();
        params.put("amount", cardPaymentRequest.getTotalAmount() * 100); // amount in cents
        params.put("currency", cardPaymentRequest.getCurrency());
        params.put("payment_method_types", "card");

        PaymentIntent paymentIntent = PaymentIntent.create(params);

        return paymentIntent.getClientSecret();
    }

    public String createPaymentIntentForUpi(UpiPaymentRequest upiPaymentRequest) throws StripeException {
        Stripe.apiKey = secretKey;

        Map<String, Object> params = new HashMap<>();
        params.put("amount", upiPaymentRequest.getTotalAmount() * 100); // amount in cents
        params.put("currency", upiPaymentRequest.getCurrency());
        params.put("payment_method_types", "upi");

        PaymentIntent paymentIntent = PaymentIntent.create(params);

        return paymentIntent.getClientSecret();
    }
}

