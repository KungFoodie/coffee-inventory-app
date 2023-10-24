package com.coffeeshop.model.domain;

import java.util.Objects;

public abstract class Item {
    protected String type;
    protected String name;
    protected int quantity;
    protected String location;
    protected String expiryDate;

    public Item() {
        this.name = "";
        this.quantity = 0;
        this.location = "";
        this.expiryDate = "";

    }

    public Item(String name, int quantity, String location, String expiryDate) {
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
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return quantity == item.quantity && Objects.equals(type, item.type) && Objects.equals(name, item.name) &&
                Objects.equals(location, item.location) && Objects.equals(expiryDate, item.expiryDate);
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
