package com.coffeeshop.model.services.inventoryservice;

import com.coffeeshop.model.domain.*;

import com.coffeeshop.model.services.exception.InventoryException;
import com.coffeeshop.model.services.factory.ServiceFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the inventory service
 * @author William Sung
 */
class InventoryServiceImplTest {

    private ServiceFactory serviceFactory;
    @Test
    void getAll() throws InventoryException {

        IInventoryService inventory = new InventoryServiceImpl();

        try {
            Map<Integer, Item>allItems = inventory.getAll(null);
        } catch (InventoryException e) {
            System.out.println("Inventory Exception Test Caught");
        }

        try {
            Map<Integer, Item> allItems = inventory.getAll(Item.class);
            Map<Integer, Store> allStores = inventory.getAll(Store.class);
            Map<Integer, Employee> allEmployees = inventory.getAll(Employee.class);
            Map<Integer, Order> allOrders = inventory.getAll(Order.class);
        } catch (InventoryException e) {
            System.out.println("Failed Test");
        }
    }

    @Test
    void add() throws InventoryException {
        IInventoryService inventory = new InventoryServiceImpl();

        Store one = new Store(1, "Shop1", 1, "First Street", "city one", 11111, "111-111-1111");
        Coffee c = new Coffee(1, "Java", 1, 1, "2022-10-21", "3A");


        try {
            assertTrue(inventory.add(one, Store.class));
            assertTrue(inventory.add(c, Item.class));
        } catch (InventoryException e) {
            System.out.println("Test failed");
        }
        delete();
    }

    @Test
    void update() throws InventoryException {
        IInventoryService inventory = new InventoryServiceImpl();


        Store one = new Store(2, "Shop1", 1, "First Street", "city one", 11111, "111-111-1111");
        Coffee c = new Coffee(1, "Java", 1, 1, "2022-10-21", "3A");

        inventory.add(one, Store.class);
        inventory.add(c, Item.class);

        Map<Integer, Item> allItems = inventory.getAll(Item.class);
        Map<Integer, Store> allStores = inventory.getAll(Store.class);

        Object[] keys = allItems.keySet().toArray();
        c = (Coffee) allItems.get(keys[0]);
        one = allStores.get(one.getLocationID());

        c.setName("Hawaiian");
        one.setName("Shop2");

        inventory.update(one, Store.class);
        inventory.update(c, Item.class);

        delete();
    }

    @Test
    void delete() throws InventoryException {
        IInventoryService inventory = new InventoryServiceImpl();

        Map<Integer, Item> allItems = inventory.getAll(Item.class);
        Map<Integer, Store> allStores = inventory.getAll(Store.class);

        for (int i: allItems.keySet())
            inventory.delete(allItems.get(i), Item.class);

        for (int s: allStores.keySet())
            inventory.delete(allStores.get(s), Store.class);

    }
}