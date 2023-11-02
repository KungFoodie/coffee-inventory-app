package com.coffeeshop.model.services.loginservice;

import com.coffeeshop.model.domain.Employee;

public class LoginServiceImpl implements ILoginService {

	@Override
	public boolean authenticateCustomer(Employee person) {
		return false;
	}
}
