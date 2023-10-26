package com.coffeeshop.model.domain;
/**
 * Name: William Sung
 * Description: Coffee class extended from item.
 */
public class Coffee extends Item {

    /**
     * Default Constructor
     */
    public Coffee() {
        super();
        this.type = "Coffee";
    }

    /**
     * Copy Constructor
     * @param name value to copy
     * @param quantity value to copy
     * @param location value to copy
     * @param expiryDate value to copy
     */
    public Coffee(String name, int quantity, String location, String expiryDate) {
        super(name, quantity, location, expiryDate);
        this.type = "Coffee";
    }
}
