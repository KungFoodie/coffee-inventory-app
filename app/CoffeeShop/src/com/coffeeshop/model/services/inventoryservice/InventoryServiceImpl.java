package com.coffeeshop.model.services.inventoryservice;

import com.coffeeshop.model.domain.*;
import com.coffeeshop.model.services.data.*;

import java.util.ArrayList;

/**
 * Class implements the inventory service interface.
 * @author William Sung
 */
public class InventoryServiceImpl<T> implements IInventoryService<T> {

    /**
     * Gets all items in inventory
     * @param type class type to retrieve
     * @return list of objects from table
     */
    @Override
    public ArrayList<T> getAll(Class<T> type) {
        Dao data = null;
        if (type == Item.class)
            data = new ItemDao();

        if (type == Store.class)
            data = new StoreDao();

        if (data == null)
            return null;

        return data.getAll();
    }

    /**
     * Adds an item to the correct table in the database
     * @param item item to be added
     * @param type class type to be added
     * @return
     */
    @Override
    public Boolean add(T item, Class<T> type) {
        Dao data = null;
        if (type == Item.class)
            data = new ItemDao();

        if (type == Store.class)
            data = new StoreDao();

        if (data == null)
            return false;
        return data.add(item);
    }

    /**
     * Updates an item in the database
     * @param item item to update
     * @param type type of item to update
     * @return true on success, false otherwise
     */
    @Override
    public Boolean update(T item, Class<T> type) {
        Dao data = null;
        if (type == Item.class)
            data = new ItemDao();

        if (type == Store.class)
            data = new StoreDao();

        if (data == null)
            return false;
        return data.update(item);
    }

    /**
     * Deletes an item from the database
     * @param item item to delete
     * @param type type of item
     * @return true on success, false otherwise
     */
    @Override
    public Boolean delete(T item, Class<T> type) {
        Dao data = null;
        if (type == Item.class)
            data = new ItemDao();

        if (type == Store.class)
            data = new StoreDao();

        if (data == null)
            return false;
        return data.delete(item);
    }
}
