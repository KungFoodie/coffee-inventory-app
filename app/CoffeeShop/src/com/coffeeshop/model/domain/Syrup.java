package com.coffeeshop.model.domain;
/**
 * Name: William Sung
 * Description: Syrup class extended from item.
 */
public class Syrup extends Item {
    /**
     * Default Constructor
     */
    public Syrup() {
        super();
        this.type = "Syrup";
    }

    /**
     * Copy Constructor
     * @param name value to copy
     * @param quantity value to copy
     * @param location value to copy
     * @param expiryDate value to copy
     */
    public Syrup(String name, int quantity, String location, String expiryDate) {
        super(name, quantity, location, expiryDate);
        this.type = "Syrup";
    }
}
