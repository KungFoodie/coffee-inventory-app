package com.coffeeshop.model.services.factory;

import com.coffeeshop.model.services.loginservice.ILoginService;
import com.coffeeshop.model.services.loginservice.LoginServiceImpl;

public class ServiceFactory {

    public ILoginService getLoginService()
    {
        return new LoginServiceImpl();
    }
}
