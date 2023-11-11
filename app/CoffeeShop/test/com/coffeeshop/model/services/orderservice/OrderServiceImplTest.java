package com.coffeeshop.model.services.orderservice;

import com.coffeeshop.model.domain.Coffee;
import com.coffeeshop.model.domain.Employee;
import com.coffeeshop.model.domain.Item;
import com.coffeeshop.model.domain.Order;
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
        ordering.createOrder(orders, 1, jack, items);

    }

    @Test
    void getOrder() throws OrderException {
        IOrderService ordering = new OrderServiceImpl();
        Employee jack = new Employee(1, "Jack", "Robinson", "Barista", "uname1", "passwd1");
        Coffee c = new Coffee(1, "Java", 1, 1, "2022-10-21", "3A");
        ArrayList<Item> items = new ArrayList<>();
        items.add(c);
        Map<Integer, Order> orders = new HashMap<>();
        ordering.createOrder(orders, 1, jack, items);

        ordering.getOrder(orders, 1);
    }

    @Test
    void updateOrder() throws OrderException {
        IOrderService ordering = new OrderServiceImpl();
        Employee jack = new Employee(1, "Jack", "Robinson", "Barista", "uname1", "passwd1");
        Coffee c = new Coffee(1, "Java", 1, 1, "2022-10-21", "3A");
        ArrayList<Item> items = new ArrayList<>();
        items.add(c);
        Map<Integer, Order> orders = new HashMap<>();
        ordering.createOrder(orders, 1, jack, items);
        Order updatedOrder = ordering.getOrder(orders, 1);
        updatedOrder.setComplete(true);
        ordering.updateOrder(orders, updatedOrder);
    }

    @Test
    void deleteOrder() throws OrderException {
        IOrderService ordering = new OrderServiceImpl();
        Employee jack = new Employee(1, "Jack", "Robinson", "Barista", "uname1", "passwd1");
        Coffee c = new Coffee(1, "Java", 1, 1, "2022-10-21", "3A");
        ArrayList<Item> items = new ArrayList<>();
        items.add(c);
        Map<Integer, Order> orders = new HashMap<>();
        ordering.createOrder(orders, 1, jack, items);
        ordering.deleteOrder(orders, ordering.getOrder(orders,1));
    }
}