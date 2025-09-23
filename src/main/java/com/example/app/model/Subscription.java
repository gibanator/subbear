package com.example.app.model;

public final class Subscription{
    private final String renewalDate;
    private final double price;
    private final String name;

    public Subscription(String renewalDate, double price, String name) {
        this.renewalDate = renewalDate;
        this.price = price;
        this.name = name;
    }

    public String getRenewalDate() {
        return renewalDate;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
