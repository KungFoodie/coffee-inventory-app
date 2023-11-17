package com.coffeeshop.model.services.orderservice;

import com.coffeeshop.model.domain.*;
import com.coffeeshop.model.services.exception.OrderException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the ordering service
 * @author William Sung
 */
class OrderServiceImplTest {

    @Test
    void createOrder() throws OrderException {

        IOrderService ordering = new OrderServiceImpl();
        Employee jack = new Employee(1, "Jack", "Robinson", "Barista", "uname1", "passwd1");
        Coffee c = new Coffee(1, "Java", 1, 1, "2022-10-21", "3A");
        ArrayList<Item> items = new ArrayList<>();
        items.add(c);
        Map<Integer, Order> orders = new HashMap<>();
        Composite composite = new Composite();
        composite.setOrders(orders);
        Order newOrder = new Order(1, jack, items, false);
        composite.setOrder(newOrder);
        ordering.createOrder(composite);

    }

    @Test
    void getOrder() throws OrderException {
        IOrderService ordering = new OrderServiceImpl();
        Employee jack = new Employee(1, "Jack", "Robinson", "Barista", "uname1", "passwd1");
        Coffee c = new Coffee(1, "Java", 1, 1, "2022-10-21", "3A");
        ArrayList<Item> items = new ArrayList<>();
        items.add(c);
        Map<Integer, Order> orders = new HashMap<>();
        Composite composite = new Composite();
        composite.setOrders(orders);
        Order newOrder = new Order(1, jack, items, false);
        composite.setOrder(newOrder);
        ordering.createOrder(composite);
        composite.setId(1);
        ordering.getOrder(composite);
    }

    @Test
    void updateOrder() throws OrderException {
        IOrderService ordering = new OrderServiceImpl();
        Employee jack = new Employee(1, "Jack", "Robinson", "Barista", "uname1", "passwd1");
        Coffee c = new Coffee(1, "Java", 1, 1, "2022-10-21", "3A");
        ArrayList<Item> items = new ArrayList<>();
        items.add(c);
        Map<Integer, Order> orders = new HashMap<>();
        Composite composite = new Composite();
        composite.setOrders(orders);
        Order newOrder = new Order(1, jack, items, false);
        composite.setOrder(newOrder);
        ordering.createOrder(composite);
        composite.setId(1);
        Order updatedOrder = ordering.getOrder(composite);
        updatedOrder.setComplete(true);
        ordering.updateOrder(composite);
    }

    @Test
    void deleteOrder() throws OrderException {
        IOrderService ordering = new OrderServiceImpl();
        Employee jack = new Employee(1, "Jack", "Robinson", "Barista", "uname1", "passwd1");
        Coffee c = new Coffee(1, "Java", 1, 1, "2022-10-21", "3A");
        ArrayList<Item> items = new ArrayList<>();
        items.add(c);
        Map<Integer, Order> orders = new HashMap<>();
        Composite composite = new Composite();
        composite.setOrders(orders);
        Order newOrder = new Order(1, jack, items, false);
        composite.setOrder(newOrder);
        composite.setId(1);
        ordering.createOrder(composite);
        ordering.deleteOrder(composite);
    }
}