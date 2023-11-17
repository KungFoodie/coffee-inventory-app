package com.coffeeshop.model.services.loginservice;

import com.coffeeshop.model.domain.Composite;
import com.coffeeshop.model.domain.Employee;
import com.coffeeshop.model.services.IService;
import com.coffeeshop.model.services.exception.LoginException;

public interface ILoginService extends IService {
    public final String NAME = "ILoginService";
    public boolean authenticateCustomer(Composite c) throws LoginException;

}