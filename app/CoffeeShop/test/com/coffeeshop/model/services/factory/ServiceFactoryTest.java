package com.coffeeshop.model.services.factory;

import com.coffeeshop.model.business.exception.ServiceLoadException;
import com.coffeeshop.model.services.inventoryservice.IInventoryService;
import com.coffeeshop.model.services.inventoryservice.InventoryServiceImpl;
import com.coffeeshop.model.services.loginservice.ILoginService;
import com.coffeeshop.model.services.loginservice.LoginServiceImpl;
import com.coffeeshop.model.services.orderservice.IOrderService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceFactoryTest {

    ServiceFactory serviceFactory;

    @BeforeEach
    public void setUp() throws Exception {
        serviceFactory = ServiceFactory.getInstance();
    }


    /**
     * Test Factory to return the loginservice and assert it by
     * checking it is an instance of LoginServiceImpl
     *
     * This should be true since LoginServiceImpl implements ILoginService
     */
    @Test
    public void testGetLoginService() {
        ILoginService loginService;
        try {
            loginService = (ILoginService)serviceFactory.getService(ILoginService.NAME);
            assertTrue(loginService instanceof LoginServiceImpl);
            System.out.println("testGetLoginService PASSED");
        } catch (ServiceLoadException e) {
            e.printStackTrace();
            fail("ServiceLoadException");
        }
    }

    @Test
    public void testGetInventoryService() {
        IInventoryService inventoryService;
        try {
            inventoryService = (IInventoryService) serviceFactory.getService(IInventoryService.NAME);
            assertTrue(inventoryService instanceof InventoryServiceImpl<?>);
            System.out.println("testGetInventoryService PASSED");
        } catch (ServiceLoadException e) {
            e.printStackTrace();
            fail("ServiceLoadException");
        }
    }

    @Test
    public void testGetOrderService() {
        IOrderService orderService;
        try {
            orderService = (IOrderService) serviceFactory.getService(IOrderService.NAME);
            assertTrue(orderService instanceof IOrderService);
            System.out.println("testGetOrderService PASSED");
        } catch (ServiceLoadException e) {
            e.printStackTrace();
            fail("ServiceLoadException");
        }
    }
}