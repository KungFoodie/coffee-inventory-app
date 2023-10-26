/**
 * Name: William Sung
 * Description: Food class extended from item.
 */
package com.coffeeshop.model.domain;

public class Food extends Item {
    public Food() {
        super();
        this.type = "Food";
    }

    public Food(String name, int quantity, String location, String expiryDate) {
        super(name, quantity, location, expiryDate);
        this.type = "Food";
    }


}
