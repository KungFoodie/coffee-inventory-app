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
