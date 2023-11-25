package com.coffeeshop.model.data;

import com.coffeeshop.model.domain.*;
import com.coffeeshop.model.services.data.ItemDao;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ItemDaoTest {

    /**
     * Test the database operations by displaying, adding, updating, and removing an item.
     */
    @Test
    public void dbTest () {
        ItemDao app = new ItemDao();
        Coffee c = new Coffee(1, "Java", 1, 1, "2022-10-21", "3A");

        Map<Integer, Item> stock;
        app.add(c);
        stock = app.getAll();
        System.out.println(stock);
        Object[] keys = stock.keySet().toArray();


        stock.get(keys[0]).setStore(1);
        app.update(stock.get(keys[0]));
        stock = app.getAll();
        System.out.println(stock);

        for (int i: stock.keySet()) {
            app.delete(stock.get(i));
        }

        stock = app.getAll();
        System.out.println(stock);

    }

}