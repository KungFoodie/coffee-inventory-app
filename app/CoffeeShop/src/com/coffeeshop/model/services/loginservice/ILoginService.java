package com.coffeeshop.model.services.loginservice;

import com.coffeeshop.model.domain.Employee;
import com.coffeeshop.model.services.IService;

public interface ILoginService extends IService {
    public final String NAME = "ILoginService";
    public boolean authenticateCustomer(Employee person);

}