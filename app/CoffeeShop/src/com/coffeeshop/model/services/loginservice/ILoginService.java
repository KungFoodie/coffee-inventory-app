package com.coffeeshop.model.services.loginservice;

import com.coffeeshop.model.domain.Employee;

public interface ILoginService {

    public boolean authenticateCustomer(Employee person);

}