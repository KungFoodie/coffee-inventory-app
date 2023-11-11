package com.coffeeshop.model.services.orderservice;

import com.coffeeshop.model.domain.Employee;
import com.coffeeshop.model.domain.Item;
import com.coffeeshop.model.domain.Order;
import com.coffeeshop.model.services.exception.OrderException;

import java.util.ArrayList;
import java.util.Map;

/**
 * Implementation of ordering interface
 * @author William SUng
 */
public class OrderServiceImpl implements IOrderService {
    /**
     * Creates an order
     * @param orders map to place new order in
     * @param id ID for new order
     * @param emp  Employee to assign to order
     * @param item Item to make for order
     * @return true if success, otherwise false
     */
    @Override
    public Boolean createOrder(Map<Integer , Order> orders, int id, Employee emp, ArrayList<Item> item) throws OrderException {
        if (orders == null)
            throw new OrderException("Orders cannot be null");

        if (id <= 0)
            throw new OrderException("ID must be greater than 0");

        if (emp == null)
            throw new OrderException("Employee cannot be null");

        if (item == null)
            throw new OrderException("Item cannot be null");

        Order newOrder = new Order(id, emp, item, false);
        orders.put(id, newOrder);
        return true;
    }

    /**
     * Gets an order from a list of orders.
     *
     * @param orders list of orders
     * @param id     order to retrieve by id
     * @return specific order, null if not found
     */
    @Override
    public Order getOrder(Map<Integer , Order> orders, int id) throws OrderException {
        if (orders == null)
            throw new OrderException("Orders cannot be null");

        if (id <= 0)
            throw new OrderException("ID must be greater than 0");

        return orders.get(id);
    }

    /**
     * Updates an order in a list of order
     *
     * @param orders list of orders
     * @param order  order to update in list
     * @return true if success, otherwise false
     */
    @Override
    public Boolean updateOrder(Map<Integer , Order> orders, Order order) throws OrderException {
        if (orders == null)
            throw new OrderException("Orders cannot be null");

        if (order == null)
            throw new OrderException("Order cannot be null");

        Order orderToUpdate = orders.get(order.getId());
        if (orderToUpdate == null)
            return false;

        orders.replace(order.getId(), order);
        return true;
    }

    /**
     * Deletes an order from a list of orders
     *
     * @param orders list of orders
     * @param order  order to delete
     * @return true if success, otherwise false
     */
    @Override
    public Boolean deleteOrder(Map<Integer , Order> orders, Order order) throws OrderException {
        if (orders == null)
            throw new OrderException("Orders cannot be null");

        if (order == null)
            throw new OrderException("Order cannot be null");

        orders.remove(order.getId());
        return true;
    }
}
