package com.coffeeshop.model.services.factory;

import com.coffeeshop.model.services.inventoryservice.IInventoryService;
import com.coffeeshop.model.services.inventoryservice.InventoryServiceImpl;
import com.coffeeshop.model.services.loginservice.ILoginService;
import com.coffeeshop.model.services.loginservice.LoginServiceImpl;
import com.coffeeshop.model.services.orderservice.IOrderService;
import com.coffeeshop.model.services.orderservice.OrderServiceImpl;

public class ServiceFactory {

    public ILoginService getLoginService()
    {
        return new LoginServiceImpl();
    }

    public IInventoryService getInventoryService()
    {
        return new InventoryServiceImpl();
    }

    public IOrderService getOrderService()
    {
        return new OrderServiceImpl();
    }
}
