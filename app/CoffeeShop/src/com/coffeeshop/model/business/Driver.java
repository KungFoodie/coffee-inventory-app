package com.coffeeshop.model.business;

import com.coffeeshop.model.business.exception.ServiceLoadException;
import com.coffeeshop.model.services.exception.InventoryException;
import com.coffeeshop.model.services.exception.OrderException;
import com.coffeeshop.model.services.factory.ServiceFactory;
import com.coffeeshop.model.services.inventoryservice.IInventoryService;
import com.coffeeshop.model.services.loginservice.ILoginService;
import com.coffeeshop.model.services.orderservice.IOrderService;

public class Driver {

    public static void main(String[] args) throws InventoryException, OrderException, ServiceLoadException {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ILoginService loginService;
        System.out.println("Testing ServiceLoadException...");

        try {
            loginService = (ILoginService) serviceFactory.getService("bob");
            System.out.println("testGetLoginService PASSED");
        } catch (ServiceLoadException e) {
            System.out.println("ServiceLoadException Caught");
        }

        System.out.println("Testing InventoryServiceException...");
        IInventoryService inventoryService;
        try {
            inventoryService = (IInventoryService) serviceFactory.getService(IInventoryService.NAME);
            try {
                inventoryService.add(null, null);
            } catch (InventoryException e) {
                System.out.println("InventoryServiceException Caught");
            }
        } catch (ServiceLoadException e) {
            e.printStackTrace();
        }

        System.out.println("Testing OrderServiceException...");
        IOrderService orderService;
        try {
            orderService = (IOrderService) serviceFactory.getService(IOrderService.NAME);
            try {
                orderService.createOrder(null, -1, null, null);
            } catch (OrderException e) {
                System.out.println("OrderServiceException Caught");
            }
        } catch (ServiceLoadException e) {
            e.printStackTrace();
        }

    }

}
