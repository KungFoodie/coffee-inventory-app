package com.coffeeshop.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

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
    private Store store;
    private Item item;
    private int id;
    private Map<Integer, Item> items;
    private Map<Integer, Store> stores;
    private Map<Integer , Order> orders;
    private Map<Integer, Employee> employees;

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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<Integer, Order> orders) {
        this.orders = orders;
    }

    public Map<Integer, Item> getItems() {
        return items;
    }

    public void setItems(Map<Integer, Item> items) {
        this.items = items;
    }

    public Map<Integer, Store> getStores() {
        return stores;
    }

    public void setStores(Map<Integer, Store> stores) {
        this.stores = stores;
    }

    public Map<Integer, Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<Integer, Employee> employees) {
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
