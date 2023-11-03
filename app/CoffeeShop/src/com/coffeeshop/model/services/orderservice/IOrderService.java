package com.coffeeshop.model.services.orderservice;

import com.coffeeshop.model.domain.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * Interface for placing an order.
 */
public interface IOrderService {
    /**
     * Creates an order
     * @param orders map to place new order in
     * @param id ID number to assign to order
     * @param emp Employee to assign to order
     * @param item Item to make for order
     * @return true if successful, otherwise false
     */
    Boolean createOrder(Map<Integer , Order> orders, int id, Employee emp, Item item);

    /**
     * Gets an order from a list of orders.
     * @param orders list of orders
     * @param id order to retrieve by id
     * @return specific order
     */
    Order getOrder(Map<Integer , Order> orders, int id);

    /**
     * Updates an order in a list of order
     * @param orders list of orders
     * @param order order to update in list
     * @return true if success, otherwise false
     */
    Boolean updateOrder(Map<Integer , Order> orders, Order order);

    /**
     * Deletes an order from a list of orders
     * @param orders list of orders
     * @param order order to delete
     * @return true if success, otherwise false
     */
    Boolean deleteOrder(Map<Integer , Order> orders, Order order);
}
