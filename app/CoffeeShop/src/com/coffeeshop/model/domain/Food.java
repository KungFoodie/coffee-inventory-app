package com.coffeeshop.model.domain;
/**
 * Name: William Sung
 * Description: Food class extended from item.
 */
public class Food extends Item {

    /**
     * Default Constructor
     */
    public Food() {
        super();
        this.type = "Food";
    }

    /**
     * Copy Constructor
     * @param name value to copy
     * @param quantity value to copy
     * @param location value to copy
     * @param expiryDate value to copy
     */
    public Food(String name, int quantity, String location, String expiryDate) {
        super(name, quantity, location, expiryDate);
        this.type = "Food";
    }


}
