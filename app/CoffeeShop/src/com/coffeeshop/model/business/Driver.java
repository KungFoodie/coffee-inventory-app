package com.coffeeshop.model.business;

import com.coffeeshop.model.data.ItemDao;
import com.coffeeshop.model.data.StoreDao;
import com.coffeeshop.model.domain.Coffee;
import com.coffeeshop.model.domain.Item;
import com.coffeeshop.model.domain.Store;

public class Driver {

    public static void main(String[] args) {
        System.out.println("Creating new location...");
        Store one = new Store(1, "Shop1", 1, "First Street", "city one", 11111, "111-111-1111");

        System.out.println("Creating new coffee item...");
        Coffee c = new Coffee(1, "Java", 1, 1, "2022-10-21", "3A");

        System.out.println("adding new items to databases...");
        ItemDao itemData = new ItemDao();
        StoreDao locData = new StoreDao();

        itemData.add(c);
        locData.add(one);

        System.out.println(itemData.getAll());
        System.out.println(locData.getAll());

        System.out.println("Updating DB items...");
        one.setName("Updated Name");
        itemData.getAll().get(0).setName("Updated Name");
        itemData.update(itemData.getAll().get(0));
        locData.update(one);

        System.out.println(itemData.getAll());
        System.out.println(locData.getAll());

        System.out.println("Deleting all items");
        for (Item i: itemData.getAll())
            itemData.delete(i);

        for (Store l: locData.getAll())
            locData.delete(l);

        System.out.println(itemData.getAll());
        System.out.println(locData.getAll());

    }

}
