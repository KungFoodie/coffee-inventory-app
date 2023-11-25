package com.coffeeshop.presentation;

import com.coffeeshop.model.business.exception.ServiceLoadException;
import com.coffeeshop.model.business.manager.CoffeeShopManager;
import com.coffeeshop.model.domain.*;
import com.coffeeshop.model.services.exception.InventoryException;
import com.coffeeshop.model.services.exception.OrderException;
import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    public static void main(String[] args) throws InventoryException, OrderException, ServiceLoadException {

        CoffeeShopManager coffeeShopManager = CoffeeShopManager.getInstance();

        Employee barista = new Employee(1, "Jack", "Robinson", "Barista", "JackR1", "JackPass");
        Composite composite = new Composite();

        System.out.println("----Testing Data Services----");


        Store one = new Store(1, "Shop1", 1, "First Street", "city one", 11111, "111-111-1111");
        Coffee c = new Coffee(1, "Java", 1, 1, "2022-10-21", "3A");
        Map<Integer, Item> items = new HashMap<>();
        Map<Integer, Order> orders = new HashMap<>();

        items.put(c.getId(), c);
        ArrayList<Item> itemsToMake = new ArrayList<>();
        for (int i: items.keySet())
            itemsToMake.add(items.get(i));

        Order newOrder = new Order(1, barista, itemsToMake, false);

        composite.setOrder(newOrder);
        composite.setStaff(barista);
        composite.setItems(items);
        composite.setOrders(orders);
        composite.setId(1);
        composite.setItem(c);
        composite.setStore(one);

        coffeeShopManager.performAction("add-Item", composite);
        coffeeShopManager.performAction("add-Store", composite);
        coffeeShopManager.performAction("add-Employee", composite);
        coffeeShopManager.performAction("add-Order", composite);
        coffeeShopManager.performAction("update-Item", composite);
        coffeeShopManager.performAction("update-Store", composite);
        coffeeShopManager.performAction("update-Employee", composite);
        coffeeShopManager.performAction("update-Order", composite);
        coffeeShopManager.performAction("getAll-Item", composite);
        coffeeShopManager.performAction("getAll-Store", composite);
        coffeeShopManager.performAction("getAll-Order", composite);
        coffeeShopManager.performAction("getAll-Employee", composite);
        coffeeShopManager.performAction("delete-Item", composite);
        coffeeShopManager.performAction("delete-Store", composite);
        coffeeShopManager.performAction("delete-Order", composite);
        coffeeShopManager.performAction("delete-Employee", composite);

        Map <Integer, Employee> employeeMap = composite.getEmployees();
        orders = composite.getOrders();

        for (int i: employeeMap.keySet()) {
            System.out.println(employeeMap.get(i));
        }

        for (int i: orders.keySet())
            System.out.println(orders.get(i));

//        System.out.println("-----SUCCESS TEST-----");
//
//        isRegistered = coffeeShopManager.performAction(
//                "RegisterCustomer", composite);
//
//        message = isRegistered ? "CoffeeShopManager::main - Successfully registered employee"
//                : "CoffeeShopManager::main - Failed to registered employee";
//        System.out.println(message);
//
//        isUpdated = coffeeShopManager.performAction("add-Item", composite);
//        message = isUpdated ? "CoffeeShopManager::main - Successfully added Item"
//                : "CoffeeShopManager::main - Failed to add item";
//        System.out.println(message);
//
//        isUpdated = coffeeShopManager.performAction("getAll-Item", composite);
//        message = isUpdated ? "CoffeeShopManager::main - Successfully got all items"
//                : "CoffeeShopManager::main - Failed to get all items";
//        System.out.println(message);
//
//        isUpdated = coffeeShopManager.performAction("update-Item", composite);
//        message = isUpdated ? "CoffeeShopManager::main - Successfully updated item"
//                : "CoffeeShopManager::main - Failed to update item";
//        System.out.println(message);
//
//        isUpdated = coffeeShopManager.performAction("delete-Item", composite);
//        message = isUpdated ? "CoffeeShopManager::main - Successfully deleted item"
//                : "CoffeeShopManager::main - Failed to delete item";
//        System.out.println(message);
//
//        isUpdated = coffeeShopManager.performAction("add-Store", composite);
//        message = isUpdated ? "CoffeeShopManager::main - Successfully added store"
//                : "CoffeeShopManager::main - Failed to add store";
//        System.out.println(message);
//
//        isUpdated = coffeeShopManager.performAction("getAll-Store", composite);
//        message = isUpdated ? "CoffeeShopManager::main - Successfully got all stores"
//                : "CoffeeShopManager::main - Failed to get all stores";
//        System.out.println(message);
//
//        isUpdated = coffeeShopManager.performAction("update-Store", composite);
//        message = isUpdated ? "CoffeeShopManager::main - Successfully updated store"
//                : "CoffeeShopManager::main - Failed to update store";
//        System.out.println(message);
//
//        isUpdated = coffeeShopManager.performAction("delete-Store", composite);
//        message = isUpdated ? "CoffeeShopManager::main - Successfully deleted store"
//                : "CoffeeShopManager::main - Failed to delete store";
//        System.out.println(message);
//
//        isUpdated = coffeeShopManager.performAction("create-Order", composite);
//        message = isUpdated ? "CoffeeShopManager::main - Successfully created order"
//                : "CoffeeShopManager::main - Failed to create order";
//        System.out.println(message);
//
//        isUpdated = coffeeShopManager.performAction("get-Order", composite);
//        message = isUpdated ? "CoffeeShopManager::main - Successfully got order"
//                : "CoffeeShopManager::main - Failed to get order";
//        System.out.println(message);
//
//        isUpdated = coffeeShopManager.performAction("update-Order", composite);
//        message = isUpdated ? "CoffeeShopManager::main - Successfully updated order"
//                : "CoffeeShopManager::main - Failed to update order";
//        System.out.println(message);
//
//        isUpdated = coffeeShopManager.performAction("delete-Order", composite);
//        message = isUpdated ? "CoffeeShopManager::main - Successfully deleted order"
//                : "CoffeeShopManager::main - Failed to delete order";
//        System.out.println(message);


    }

}
