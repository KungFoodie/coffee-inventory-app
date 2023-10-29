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
    public Coffee(int id, String name, int quantity, int location, String expiryDate, String storageLoc) {
        super(id, name, quantity, location, expiryDate, storageLoc);
        this.type = "Coffee";
    }
}
