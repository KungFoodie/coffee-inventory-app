package com.coffeeshop.model.data;

import com.coffeeshop.model.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ItemDaoTest {

    @Test
    public void dbTest () {
        ItemDao app = new ItemDao();
        Coffee c = new Coffee(1, "Java", 1, "3B", "2022-10-21");

        ArrayList<Item> stock = new ArrayList<>();
        app.add(c);
        stock = app.getAll();
        System.out.println(stock);

        stock.get(0).setLocation("3A");
        app.update(stock.get(0));
        stock = app.getAll();
        System.out.println(stock);

        for (Item i: stock)
            app.delete(i);
        stock = app.getAll();
        System.out.println(stock);

    }


}