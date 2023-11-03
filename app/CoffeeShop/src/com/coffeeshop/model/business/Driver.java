package com.coffeeshop.model.business;

import com.coffeeshop.model.domain.*;
import com.coffeeshop.model.services.factory.ServiceFactory;
import com.coffeeshop.model.services.inventoryservice.IInventoryService;
import com.coffeeshop.model.services.orderservice.IOrderService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    public static void main(String[] args) {
        System.out.println("Creating new location...");
        Store one = new Store(1, "Shop1", 1, "First Street", "city one", 11111, "111-111-1111");

        System.out.println("Creating new coffee item...");
        Coffee c = new Coffee(1, "Java", 1, 1, "2022-10-21", "3A");

        System.out.println("Making services");
        ServiceFactory factory = new ServiceFactory();
        IInventoryService inventory = factory.getInventoryService();
        IOrderService ordering = factory.getOrderService();

        System.out.println("Adding item and store...");
        inventory.add(c, Item.class);
        inventory.add(one, Store.class);

        System.out.println("Making a new order");
        Map<Integer, Order> orders = new HashMap<>();

        Employee jack = new Employee(1, "Jack", "Robinson", "Barista", "uname1", "passwd1");

        ordering.createOrder(orders, 1, jack,
                (Item) inventory.getAll(Item.class).get(0));

        System.out.println("New order made:");
        System.out.println(ordering.getOrder(orders, 1));

        System.out.println("Updating order 1:");
        Order updatedOrder = orders.get(1);
        updatedOrder.setComplete(true);
        ordering.updateOrder(orders, updatedOrder);
        System.out.println(ordering.getOrder(orders, 1));

        System.out.println("Deleting Order 1");
        ordering.deleteOrder(orders,orders.get(1));

        ArrayList<Item> allItems = inventory.getAll(Item.class);
        ArrayList<Store> allStores = inventory.getAll(Store.class);

        for (Item i: allItems)
            inventory.delete(i, Item.class);

        for (Store s: allStores)
            inventory.delete(s, Store.class);
    }

}
