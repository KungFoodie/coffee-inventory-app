package com.coffeeshop.model.services.inventoryservice;

import com.coffeeshop.model.domain.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the inventory service
 * @author William Sung
 */
class InventoryServiceImplTest {

    @Test
    void getAll() {
        IInventoryService inventory = new InventoryServiceImpl();
        ArrayList<Item> allItems = inventory.getAll(Item.class);
        ArrayList<Store> allStores = inventory.getAll(Store.class);
    }

    @Test
    void add() {
        IInventoryService inventory = new InventoryServiceImpl();

        Store one = new Store(1, "Shop1", 1, "First Street", "city one", 11111, "111-111-1111");
        Coffee c = new Coffee(1, "Java", 1, 1, "2022-10-21", "3A");

        inventory.add(one, Store.class);
        inventory.add(c, Item.class);

        delete();
    }

    @Test
    void update() {
        IInventoryService inventory = new InventoryServiceImpl();


        Store one = new Store(2, "Shop1", 1, "First Street", "city one", 11111, "111-111-1111");
        Coffee c = new Coffee(1, "Java", 1, 1, "2022-10-21", "3A");

        inventory.add(one, Store.class);
        inventory.add(c, Item.class);

        ArrayList<Item> allItems = inventory.getAll(Item.class);
        ArrayList<Store> allStores = inventory.getAll(Store.class);

        c = (Coffee) allItems.get(0);
        one = allStores.get(0);

        c.setName("Hawaiian");
        one.setName("Shop2");

        inventory.update(one, Store.class);
        inventory.update(c, Item.class);

        delete();
    }

    @Test
    void delete() {
        IInventoryService inventory = new InventoryServiceImpl();

        ArrayList<Item> allItems = inventory.getAll(Item.class);
        ArrayList<Store> allStores = inventory.getAll(Store.class);

        for (Item i: allItems)
            inventory.delete(i, Item.class);

        for (Store s: allStores)
            inventory.delete(s, Store.class);

    }
}