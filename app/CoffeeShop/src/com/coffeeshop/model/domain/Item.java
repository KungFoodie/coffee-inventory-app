/**
 * Name: William Sung
 * Description: Abstract class to be extended for items
 */
package com.coffeeshop.model.domain;

import java.util.Objects;

public abstract class Item {
    protected String type;
    protected String name;
    protected int quantity;
    protected String location;
    protected String expiryDate;

    /**
     * Default constructor. Assigns all Strings to null and integers to -1
     */
    public Item() {
        this.type = null;
        this.name = null;
        this.quantity = -1;
        this.location = null;
        this.expiryDate = null;

    }

    /**
     * Copy Constructor.
     *
     * @param name variable to copy
     * @param quantity variable to copy
     * @param location variable to copy
     * @param expiryDate variable to copy
     */
    public Item(String name, int quantity, String location, String expiryDate) {
        this.type = null;
        this.name = name;
        this.quantity = quantity;
        this.location = location;
        this.expiryDate = expiryDate;
    }

    /**
     * Getter for type
     * @return type value
     */
    public String getType() {
        return type;
    }

    /**
     * Getter for name
     * @return name value
     */
    public String getName() {

        return name;
    }

    /**
     * Setter for name
     * @param name value to set
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * Getter for quantity
     * @return quantity value
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for quantity
     * @param quantity value to set
     */
    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    /**
     * Getter for location
     * @return location value
     */
    public String getLocation() {

        return location;
    }

    /**
     * Setter for location
     * @param location value to set
     */
    public void setLocation(String location) {

        this.location = location;
    }

    /**
     * Getter for expiryDate
     * @return expiryDate value
     */
    public String getExpiryDate() {

        return expiryDate;
    }

    /**
     * Setter for expiryDate
     * @param expiryDate value to set
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Overridden equals method. Checks for nulls and values to be equal
     * @param o value to compare to this object
     * @return false if values are nulls or not equal, true otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Item item))
            return false;

        Item other = (Item) o;

        if ((other.quantity == -1) || (this.quantity == -1) || (this.quantity != item.quantity))
            return false;
        if ((other.type == null) || (this.type == null) || !type.equals(item.type))
            return false;
        if ((other.name == null) || (this.name == null) || !name.equals(item.name))
            return false;
        if ((other.location == null) || (this.location == null) || !location.equals(item.location))
            return false;
        if ((other.expiryDate == null) || (this.expiryDate == null) || expiryDate.equals(item.expiryDate))
            return false;
        return true;
    }

    @Override
    public int hashCode() {

        return Objects.hash(type, name, quantity, location, expiryDate);
    }

    @Override
    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", location='" + location + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                '}';
    }
}
