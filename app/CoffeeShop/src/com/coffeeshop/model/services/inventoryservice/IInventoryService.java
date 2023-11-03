package com.coffeeshop.model.services.inventoryservice;

import com.coffeeshop.model.domain.Item;

import java.util.ArrayList;

/**
 * Interface for the inventory service
 * @author William Sung
 */
public interface IInventoryService<T> {

    ArrayList<T> getAll(Class<T> type);
    Boolean add(T item, Class<T> type);
    Boolean update(T item, Class<T> type);
    Boolean delete(T item, Class<T> type);
}
