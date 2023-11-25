package com.coffeeshop.model.services.inventoryservice;

import com.coffeeshop.model.domain.Item;
import com.coffeeshop.model.services.IService;
import com.coffeeshop.model.services.exception.InventoryException;

import java.util.ArrayList;
import java.util.Map;

/**
 * Interface for the inventory service
 * @author William Sung
 */
public interface IInventoryService<T> extends IService {
    public final String NAME = "IInventoryService";
    Map<T, T> getAll(Class<T> type) throws InventoryException;
    Boolean add(T item, Class<T> type) throws InventoryException;
    Boolean update(T item, Class<T> type) throws InventoryException;
    Boolean delete(T item, Class<T> type) throws InventoryException;
}
