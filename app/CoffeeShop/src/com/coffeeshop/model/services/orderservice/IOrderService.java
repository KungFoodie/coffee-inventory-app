package com.coffeeshop.model.services.orderservice;

import com.coffeeshop.model.domain.*;
import com.coffeeshop.model.services.IService;
import com.coffeeshop.model.services.exception.OrderException;

import java.util.ArrayList;
import java.util.Map;

/**
 * Interface for placing an order.
 * @author William Sung
 */
public interface IOrderService extends IService {
    public final String NAME = "IOrderService";
    /**
     * Creates an order
     * @param orders map to place new order in
     * @param id ID number to assign to order
     * @param emp Employee to assign to order
     * @param item Item to make for order
     * @return true if successful, otherwise false
     */
    Boolean createOrder(Map<Integer , Order> orders, int id, Employee emp, ArrayList<Item> item) throws OrderException;

    /**
     * Gets an order from a list of orders.
     * @param orders list of orders
     * @param id order to retrieve by id
     * @return specific order
     */
    Order getOrder(Map<Integer , Order> orders, int id) throws OrderException;

    /**
     * Updates an order in a list of order
     * @param orders list of orders
     * @param order order to update in list
     * @return true if success, otherwise false
     */
    Boolean updateOrder(Map<Integer , Order> orders, Order order) throws OrderException;

    /**
     * Deletes an order from a list of orders
     * @param orders list of orders
     * @param order order to delete
     * @return true if success, otherwise false
     */
    Boolean deleteOrder(Map<Integer , Order> orders, Order order) throws OrderException;
}
