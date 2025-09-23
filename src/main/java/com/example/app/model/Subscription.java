package com.example.app.model;

public final class Subscription{
    private final String name;
    private final double price;
    private final String renewalDate;

    public Subscription(String name, double price, String renewalDate) {
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
