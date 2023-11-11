package com.coffeeshop.model.domain;

import java.io.Serializable;

/**
 * Composite object that holds the inventory information
 * @author William Sung
 */
public class Composite implements Serializable {
    private static final long serialVersionUID = 1L;
    /** holds the items in inventory */
    private Coffee beans;
    private Food foods;
    private Syrup syrups;
    private Employee staff;
    private Order order;

    public Composite() {}

    /**
     * @return beans
     */
    public Coffee getBeans() {
        return beans;
    }

    /**
     * @param beans value to set
     */
    public void setBeans(Coffee beans) {
        this.beans = beans;
    }

    /**
     * @return foods
     */
    public Food getFoods() {
        return foods;
    }

    /**
     * @param foods value to set
     */
    public void setFoods(Food foods) {
        this.foods = foods;
    }

    /**
     * @return syrup
     */
    public Syrup getSyrups() {
        return syrups;
    }

    /**
     * @param syrups value to set
     */
    public void setSyrups(Syrup syrups) {
        this.syrups = syrups;
    }

    public Employee getStaff() {
        return staff;
    }

    public void setStaff(Employee staff) {
        this.staff = staff;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Composite{" +
                "beans=" + beans +
                ", foods=" + foods +
                ", syrups=" + syrups +
                ", staff=" + staff +
                ", order=" + order +
                '}';
    }
}
