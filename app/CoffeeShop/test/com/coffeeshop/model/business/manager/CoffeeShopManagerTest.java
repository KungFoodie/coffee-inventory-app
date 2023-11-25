package com.coffeeshop.model.business.manager;

import com.coffeeshop.model.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeShopManagerTest {

    @Test
    void getInstance() {
        CoffeeShopManager manager = CoffeeShopManager.getInstance();
        assertTrue(manager instanceof CoffeeShopManager);
    }

    @Test
    void performAction() {
        CoffeeShopManager manager = CoffeeShopManager.getInstance();
        Employee barista = new Employee(1, "Jack", "Robinson", "Barista", "JackR1", "JackPass");
        Composite composite = new Composite();

        Store one = new Store(1, "Shop1", 1, "First Street", "city one", 11111, "111-111-1111");
        Coffee c = new Coffee(1, "Java", 1, 1, "2022-10-21", "3A");
        ArrayList<Item> items = new ArrayList<>();
        Map<Integer, Item> itemMap = new HashMap<>();
        items.add(c);
        itemMap.put(c.getId(), c);
        Map<Integer, Order> orders = new HashMap<>();
        Order newOrder = new Order(1, barista, items, false);

        composite.setOrder(newOrder);
        composite.setStaff(barista);
        composite.setItems(itemMap);
        composite.setOrders(orders);
        composite.setId(1);
        composite.setItem(c);
        composite.setStore(one);

        assertFalse(manager.performAction("badcommand", new Composite()));
        assertTrue(manager.performAction("add-Item", composite));
        assertTrue(manager.performAction("add-Store", composite));
        assertTrue(manager.performAction("create-Order", composite));
        assertTrue(manager.performAction("update-Order", composite));

    }
}