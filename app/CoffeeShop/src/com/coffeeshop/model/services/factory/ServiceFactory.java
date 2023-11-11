package com.coffeeshop.model.services.factory;

import com.coffeeshop.model.business.exception.ServiceLoadException;
import com.coffeeshop.model.services.IService;
import com.coffeeshop.model.services.inventoryservice.IInventoryService;
import com.coffeeshop.model.services.inventoryservice.InventoryServiceImpl;
import com.coffeeshop.model.services.loginservice.ILoginService;
import com.coffeeshop.model.services.loginservice.LoginServiceImpl;
import com.coffeeshop.model.services.orderservice.IOrderService;
import com.coffeeshop.model.services.orderservice.OrderServiceImpl;

public class ServiceFactory {

    private ServiceFactory() {

    }

    private static ServiceFactory serviceFactory = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return serviceFactory;
    }

    public IService getService(String serviceName) throws ServiceLoadException {
        try {
            // Class is a parametrizable class. By writing Class<?>, we're declaring a Class object
            // which can be of any type (? is a wildcard).
            // Reference about Generics and Wildcards:http://docs.oracle.com/javase/tutorial/java/generics/wildcards.html
            Class<?> c = Class.forName(getImplName(serviceName));
            return (IService) c.newInstance();
        } catch (Exception excp) {
            serviceName = serviceName + " not loaded";
            throw new ServiceLoadException(serviceName, excp);
        }
    }

    private String getImplName(String serviceName) throws Exception {

        java.util.Properties props = new java.util.Properties();

        String propertyFileLocation = System.getProperty("prop_location");

        System.out.println("Property File Location passed : "
                + propertyFileLocation);
        java.io.FileInputStream fis = new java.io.FileInputStream(
                propertyFileLocation);

        props.load(fis);
        fis.close();
        return props.getProperty(serviceName);
    }


}
