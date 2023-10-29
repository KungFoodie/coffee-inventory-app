package com.coffeeshop.model.domain;

import java.util.Objects;

/**
 * Name: William Sung
 * Description: Abstract class to be extended for items
 */
public abstract class Item {
    protected String type;
    private int id;
    private String name;
    private int quantity;
    private int location;
    private String expiryDate;
    private String storageLoc;

    /**
     * Default constructor. Assigns all Strings to null and integers to -1
     */
    public Item() {
        this.id = -1;
        this.type = null;
        this.name = null;
        this.quantity = -1;
        this.location = -1;
        this.expiryDate = null;
        this.storageLoc = null;
    }

    /**
     * Copy Constructor.
     *
     * @param name variable to copy
     * @param quantity variable to copy
     * @param location variable to copy
     * @param expiryDate variable to copy
     */
    public Item(int id, String name, int quantity, int location, String expiryDate, String storageLoc) {
        this.type = null;
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.location = location;
        this.expiryDate = expiryDate;
        this.storageLoc = storageLoc;
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
     * Getter for id
     * @return id value
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id
     * @param id value to set
     */
    public void setId(int id) {
        this.id = id;
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
    public int getLocation() {
        return location;
    }

    /**
     * Setter for location
     * @param location value to set
     */
    public void setLocation(int location) {
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
     * Getter for storageLoc
     * @return storageLoc
     */
    public String getStorageLoc() {
        return storageLoc;
    }

    /**
     * Setter for storageLoc
     * @param storageLoc value to set
     */
    public void setStorageLoc(String storageLoc) {
        this.storageLoc = storageLoc;
    }

    /**
     * Validates the inputs as not null or not blank, then checks for valid date and formatting (YYYY-MM-DD)
     * @return true if all conditions pass, false otherwise
     */
    public Boolean validate() {
        if (this.type == null || this.name == null || this.location < 0 || this.quantity < 0 ||
                this.expiryDate == null || this.storageLoc == null)
            return false;

        if (this.type.isBlank() || this.name.isBlank() || this.expiryDate.isBlank() || this.storageLoc.isBlank())
            return false;

        // try to convert string to int and catch exception for letters
        try {
            // split the string
            String[] dateSplit = this.expiryDate.split("-");
            // check for valid lengths
            if (dateSplit[0].length() != 4 || dateSplit[1].length() != 2 ||
                    dateSplit[2].length() != 2) {
                return false;
            }
            // try to convert to integers
            int month = Integer.parseInt(dateSplit[1]);
            int day = Integer.parseInt(dateSplit[2]);
            int year = Integer.parseInt(dateSplit[0]);
            // Switch statement checks for leap year for feb, 31 day months,
            // and 30 day months as well as day is greater than 1
            switch (month) {
                case 2 -> {
                    if (day > (year % 4 == 0 ? 29 : 28) || day < 1) {
                        return false;
                    }
                    break;
                }
                case 1, 3, 5, 7, 8, 10, 12 -> {
                    if (day > 31 || day < 1) {
                        return false;
                    }
                }
                case 4, 6, 9, 11 -> {
                    if (day > 30 || day < 1) {
                        return false;
                    }
                }
                default -> {
                    return false;
                }
            }

        } catch (NumberFormatException e) {
            return false;
        }
        return true;
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

        if (this.quantity != item.quantity|| !this.type.equals(item.type) || !this.name.equals(item.name) ||
                this.location  != item.location|| !this.expiryDate.equals(item.expiryDate) || !this.storageLoc.equals(((Item) o).storageLoc))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, quantity, location, expiryDate);
    }

    @Override
    public String toString() {
        return "Item{" + "\n" +
                "id='" + id + '\'' + "\n" +
                "type='" + type + '\'' + "\n" +
                "name='" + name + '\'' + "\n" +
                "quantity=" + quantity + "\n" +
                "location='" + location + '\'' + "\n" +
                "expiryDate='" + expiryDate + '\'' + "\n" +
                "storageLoc = " + storageLoc + '\'' + "\n" +
                '}' + "\n";
    }
}
