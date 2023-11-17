package com.coffeeshop.model.services.loginservice;


import com.coffeeshop.model.domain.Composite;
import com.coffeeshop.model.domain.Employee;
import com.coffeeshop.model.services.exception.LoginException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoginServiceImpl implements ILoginService {


	public boolean authenticateCustomer(Composite composite)
			throws LoginException {

		boolean isValid = false;
		ObjectInputStream input = null;
		try {
			input = new ObjectInputStream (new FileInputStream("RegisteredCustomer.out"));
			Employee savedCustomer = (Employee) input.readObject();

			Employee inEmployee = composite.getStaff();
			if (inEmployee != null)
			{
				if (savedCustomer.equals(inEmployee))
					isValid = true;
				else
					isValid = false;
			}
			else
			{
				/*
				 * NOTE:
				 *
				 * 1. Instead of throwing an exception, an alternate way(appropriate) would be to return a
				 * false from the method.
				 * 2. Throwing the exception here just to illustrate the use of it.
				 */
				throw new LoginException ("Null Customer passed to LoginServiceImpl::login");
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println ("File containing registered users not found!");
			throw new LoginException ("File containing registered users not found!", fnfe);
		} catch (IOException ioe) {
			System.out.println ("IOException while accessing file containing registered users!");
			throw new LoginException ("IOException while accessing file containing registered users!", ioe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println ("ClassNotFoundException while reading file containing registered users!");
			throw new LoginException ("ClassNotFoundException while reading file containing registered users!", cnfe);
		}
		finally
		{
			if (input != null)
			{
				try {
					input.close();
				} catch (IOException e) {
					// Can't do much here if exceptions occur, other then logging
					e.printStackTrace();
				}
			}
		}//end try/catch/finally
		return isValid;
	} //end login

}