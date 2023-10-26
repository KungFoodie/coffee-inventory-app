package com.coffeeshop.model.domain;
/**
 * Name: William Sung
 * Description: Syrup class extended from item.
 */
public class Syrup extends Item {
    public Syrup() {
        super();
        this.type = "Syrup";
    }

    public Syrup(String name, int quantity, String location, String expiryDate) {
        super(name, quantity, location, expiryDate);
        this.type = "Syrup";
    }
}
