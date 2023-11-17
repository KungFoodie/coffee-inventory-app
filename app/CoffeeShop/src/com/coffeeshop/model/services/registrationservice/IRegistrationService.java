/**
 * 
 */
package com.coffeeshop.model.services.registrationservice;

import com.coffeeshop.model.domain.Composite;
import com.coffeeshop.model.services.IService;
import com.coffeeshop.model.services.exception.RegistrationException;

/**
 * @author mike.prasad
 *
 */
public interface IRegistrationService extends IService
{

	public final String NAME = "IRegistrationService";

	/** Register customer into our application 
	 * @throws RegistrationException */
	public boolean registerCustomer(Composite rentalComposite) throws RegistrationException;

}
