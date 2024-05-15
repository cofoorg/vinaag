package com.example.demo.model;

public class UpiPaymentRequest {
    private String upiId;
    private double totalAmount;
    private String currency;



    // Getters and setters

  	public String getCurrency() {
  		return currency;
  	}

  	public void setCurrency(String currency) {
  		this.currency = currency;
  	}

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double amount) {
        this.totalAmount = amount;
    }
}
