package com.coffeeshop.model.domain;

import java.io.Serializable;

/**
 * Description: Food class extended from item.
 * @author William Sung
 */
public class Food extends Item implements Serializable {
    private static final long serialVersionUID = 1L;
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
    public Food(int id, String name, int quantity, int location, String expiryDate, String storageLoc) {
        super(id, name, quantity, location, expiryDate, storageLoc);
        this.type = "Food";
    }


}
