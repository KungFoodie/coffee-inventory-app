package com.coffeeshop.model.domain;

public class Coffee extends Item {

    public Coffee() {
        super();
        this.type = "Coffee";
    }

    public Coffee(String name, int quantity, String location, String expiryDate) {
        super(name, quantity, location, expiryDate);
        this.type = "Coffee";
    }
}
