package com.coffeeshop.model.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class assigns an employee to a job to make a specific item in an order
 * @author William Sung
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Employee barista;
    private ArrayList<Item> itemsToMake;
    private boolean complete;

    /**
     * Default Constructor
     */
    public Order () {
        this.id = -1;
        this.barista = null;
        this.itemsToMake = null;
        this.complete = false;
    }

    /**
     * Copy Constructor
     * @param id Value to copy
     * @param barista Value to copy
     * @param itemsToMake Value to copy
     * @param complete Value to copy
     */
    public Order(int id, Employee barista, ArrayList<Item> itemsToMake, boolean complete) {
        this.id = id;
        this.barista = barista;
        this.itemsToMake = itemsToMake;
        this.complete = complete;
    }

    /**
     * Getter for order ID
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for ID
     * @param id value to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for employee
     * @return emp
     */
    public Employee getBarista() {
        return barista;
    }

    /**
     * Setter for emp.
     * @param barista value to set
     */
    public void setBarista(Employee barista) {
        this.barista = barista;
    }

    /**
     * Getter for itemToMake
     * @return itemToMake
     */
    public ArrayList<Item> getItemsToMake() {
        return itemsToMake;
    }

    /**
     * Setter for itemToMake
     * @param itemsToMake value to set
     */
    public void setItemsToMake(ArrayList<Item> itemsToMake) {
        this.itemsToMake = itemsToMake;
    }

    /**
     * getter for completion status
     * @return complete
     */
    public boolean isComplete() {
        return complete;
    }

    /**
     * Setter for completion status
     * @param complete value to set
     */
    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;

        if (id != order.id) return false;
        if (complete != order.complete) return false;
        if (!barista.equals(order.barista)) return false;
        return itemsToMake.equals(order.itemsToMake);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + barista.hashCode();
        result = 31 * result + itemsToMake.hashCode();
        result = 31 * result + (complete ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", barista=" + barista +
                ", itemsToMake=" + itemsToMake +
                ", complete=" + complete +
                '}';
    }
}
