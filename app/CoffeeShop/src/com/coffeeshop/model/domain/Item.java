package com.coffeeshop.model.domain;

import java.util.Objects;

public abstract class Item {
    protected String type;
    protected String name;
    protected int quantity;
    protected String location;
    protected String expiryDate;

    public Item() {
        this.type = null;
        this.name = null;
        this.quantity = -1;
        this.location = null;
        this.expiryDate = null;

    }

    public Item(String name, int quantity, String location, String expiryDate) {
        this.type = null;
        this.name = name;
        this.quantity = quantity;
        this.location = location;
        this.expiryDate = expiryDate;
    }

    public String getType() {
        return type;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public String getExpiryDate() {

        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

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
