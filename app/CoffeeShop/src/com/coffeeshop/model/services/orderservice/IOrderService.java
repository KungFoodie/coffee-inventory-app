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
     * @param composite contains current state of application
     * @return true if successful, otherwise false
     */
    Boolean createOrder(Composite composite) throws OrderException;

    /**
     * Gets an order from a list of orders.
     * @param composite contains current state of application
     * @return specific order
     */
    Order getOrder(Composite composite) throws OrderException;

    /**
     * Updates an order in a list of order
     * @param composite contains current state of application
     * @return true if success, otherwise false
     */
    Boolean updateOrder(Composite composite) throws OrderException;

    /**
     * Deletes an order from a list of orders
     * @param composite contains current state of application
     * @return true if success, otherwise false
     */
    Boolean deleteOrder(Composite composite) throws OrderException;
}
