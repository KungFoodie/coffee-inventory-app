package com.coffeeshop.model.services.orderservice;

import com.coffeeshop.model.domain.Composite;
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
     * @param composite contains current state of application
     * @return true if success, otherwise false
     */
    @Override
    public Boolean createOrder(Composite composite) throws OrderException {
        Map<Integer , Order> orders = composite.getOrders();
        if (orders == null)
            throw new OrderException("Orders cannot be null");

        Order newOrder = composite.getOrder();
        orders.put(newOrder.getId(), newOrder);
        return true;
    }

    /**
     * Gets an order from a list of orders.
     * @param composite contains current state of application
     * @return specific order, null if not found
     */
    @Override
    public Order getOrder(Composite composite) throws OrderException {
        int id = composite.getId();
        Map<Integer , Order> orders = composite.getOrders();
        if (orders == null)
            throw new OrderException("Orders cannot be null");

        if (id <= 0)
            throw new OrderException("ID must be greater than 0");

        return orders.get(id);
    }

    /**
     * Updates an order in a list of order
     * @param composite contains current state of application
     * @return true if success, otherwise false
     */
    @Override
    public Boolean updateOrder(Composite composite) throws OrderException {
        Map<Integer , Order> orders = composite.getOrders();
        Order order = composite.getOrder();
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
     * @param composite contains current state of application
     * @return true if success, otherwise false
     */
    @Override
    public Boolean deleteOrder(Composite composite) throws OrderException {
        Map<Integer , Order> orders = composite.getOrders();
        Order order = composite.getOrder();
        if (orders == null)
            throw new OrderException("Orders cannot be null");

        if (order == null)
            throw new OrderException("Order cannot be null");

        orders.remove(order.getId());
        return true;
    }
}
