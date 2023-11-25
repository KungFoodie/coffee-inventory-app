package com.coffeeshop.model.business.manager;


import com.coffeeshop.model.business.exception.ServiceLoadException;
import com.coffeeshop.model.domain.*;
import com.coffeeshop.model.services.exception.InventoryException;
import com.coffeeshop.model.services.exception.LoginException;
import com.coffeeshop.model.services.exception.OrderException;
import com.coffeeshop.model.services.exception.RegistrationException;
import com.coffeeshop.model.services.factory.ServiceFactory;
import com.coffeeshop.model.services.inventoryservice.IInventoryService;
import com.coffeeshop.model.services.loginservice.ILoginService;
import com.coffeeshop.model.services.orderservice.IOrderService;
import com.coffeeshop.model.services.registrationservice.IRegistrationService;

/**
 * This Manager class provides two key functionalities: 1. Has the properties
 * files loaded by the PropertyManager 2. Calls the ServiceFactory class and
 * executes the services being requested by the controller.
 *
 * Manager classes in reality provide a define set of functionality and govern
 * the overall processing of the application.
 *
 * @author Mike.Prasad
 *
 */

public class CoffeeShopManager extends ManagerSuperType {

	private static CoffeeShopManager _instance;

	/**
	 * keep the constructor private to prevent instantiation by outside callers.
	 */
	private CoffeeShopManager() {
		// construct object . . .
	}

	/**
	 * Assures that there is only one FleetRentalManager created.
	 * 
	 * @return FleetRentalManager instance
	 */
	public static synchronized CoffeeShopManager getInstance() {
		if (_instance == null) {
			_instance = new CoffeeShopManager();
		}
		return _instance;
	}

	/**
	 * Generic method that all clients of this class can call to perform certain
	 * actions.
	 * 
	 * @param commandString
	 *            Holds the service name to be invoked *
	 * @param composite
	 *            Holds application specific domain state
	 * @return false if action failed true if action is successful
	 */
	@Override
	public boolean performAction(String commandString,
			Composite composite) {
		boolean action = false;
		if (commandString.equals("RegisterCustomer")) {
			action = registerCustomer(IRegistrationService.NAME,
					composite);
		} else if (commandString.equals("LoginCustomer")) {
			action = loginCustomer(ILoginService.NAME, composite);
		} else {
			String[] command = commandString.split("-");
			if (command.length == 2) {
				if (command[1].equals("Item") || command[1].equals("Store") || command[1].equals("Employee") || command[1].equals("Order")) {
					action = crudInventory(commandString, composite);
				}
//				} else if (command[1].equals("Order")) {
//					action = crudOrder(commandString, composite);
//				}
			}
		}

		return action;
	}

	/**
	 * Method delegates to the ServiceFactory to execute a service. Good part of
	 * this approach is that the Manager knows the service by a string name -
	 * thus achieving the decoupling effect that we so desire in the MVC
	 * approach.
	 *
	 * @param commandString
	 *            contains the service that needs to be performed
	 * @param composite
	 *            contains the customer registration info needed
	 *
	 *            QUESTION TO STUDENTS: IS THIS WORTH PROPAGATING EXCEPTION TO
	 *            CALLER(View/Controller), OR SHOULD IT BE HANDLED LIKE BELOW?
	 *            Would propagating exception to the View/Controller in this tie
	 *            Presentation Layer to Model semantics? Is that considered
	 *            tight coupling?
	 *
	 */
	private boolean registerCustomer(String commandString,
			Composite composite) {
		boolean isRegistered = false;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		IRegistrationService iRegistrationService;

		try {
			iRegistrationService = (IRegistrationService) serviceFactory
					.getService(commandString);
			isRegistered = iRegistrationService
					.registerCustomer(composite);
		} catch (ServiceLoadException e1) {
			System.out.println("CoffeeShopManager::registerCustomer failed");
		} catch (RegistrationException e) {
			System.out.println("CoffeeShopManager::registerCustomer failed");
		}

		return isRegistered;

	}// end registerCustomer

	/**
	 * Invokes appropriate service to login the customer
	 * 
	 * @param commandString
	 *            contains the service that needs to be performed
	 * @param composite
	 *            contains the customer login information
	 * @return true if login information passed is valid false if login
	 *         information passed is invalid
	 */
	private boolean loginCustomer(String commandString,
			Composite composite) {
		boolean isAuthenticated = false;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ILoginService iLoginService;

		try {
			iLoginService = (ILoginService) serviceFactory
					.getService(commandString);
			isAuthenticated = iLoginService
					.authenticateCustomer(composite);
		} catch (ServiceLoadException e1) {
			System.out.println("CoffeeShopManager::login failed"); // defaulting
																	// to
																	// isAuthenticated
																	// to false
		} catch (LoginException e) {
			System.out.println("CoffeeShopManager::login failed"); // defaulting
																	// to
																	// isAuthenticated
																	// to false
		}

		return isAuthenticated;
	} // end loginCustomer

	private boolean crudInventory(String commandString, Composite composite) {
		boolean updated = false;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		IInventoryService inventoryService;

		try {
			inventoryService = (IInventoryService) serviceFactory.getService(IInventoryService.NAME);
			switch (commandString) {
				case "add-Item":
					updated = inventoryService.add(composite.getItem(), Item.class);
					break;
				case "delete-Item":
					updated = inventoryService.delete(composite.getItem(), Item.class);
					break;
				case "update-Item":
					updated = inventoryService.update(composite.getItem(), Item.class);
					break;
				case "getAll-Item":
					composite.setItems(inventoryService.getAll(Item.class));
					updated = true;
					break;
				case "add-Store":
					inventoryService.add(composite.getStore(), Store.class);
					updated = true;
					break;
				case "delete-Store":
					updated = inventoryService.delete(composite.getStore(), Store.class);
					break;
				case "update-Store":
					updated = inventoryService.update(composite.getStore(), Store.class);
					break;
				case "getAll-Store":
					composite.setStores(inventoryService.getAll(Store.class));
					updated = true;
					break;
				case "add-Employee":
					updated = inventoryService.add(composite.getStaff(), Employee.class);
					break;
				case "delete-Employee":
					updated = inventoryService.delete(composite.getStaff(), Employee.class);
					break;
				case "update-Employee":
					updated = inventoryService.update(composite.getStaff(), Employee.class);
					break;
				case "getAll-Employee":
					composite.setEmployees(inventoryService.getAll(Employee.class));
					updated = true;
					break;
				case "add-Order":
					updated = inventoryService.add(composite.getOrder(), Order.class);
					break;
				case "delete-Order":
					updated = inventoryService.delete(composite.getOrder(), Order.class);
					break;
				case "update-Order":
					updated = inventoryService.update(composite.getOrder(), Order.class);
					break;
				case "getAll-Order":
					composite.setOrders(inventoryService.getAll(Order.class));
					updated = true;
					break;
				default:
					System.out.println("Invalid Operation");

			}

		} catch (ServiceLoadException e1) {
			System.out.println("CoffeeShopManager::Inventory Operation failed"); // defaulting

		} catch (InventoryException e) {
			System.out.println("CoffeeShopManager::Inventory Operation failed"); // defaulting

		}

		return updated;
	}

	private boolean crudOrder(String commandString, Composite composite) {
		boolean updated = false;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		IOrderService orderService;

		try {
			orderService = (IOrderService) serviceFactory.getService(IOrderService.NAME);
			switch (commandString) {
				case "create-Order":
					updated = orderService.createOrder(composite);
					break;
				case "get-Order":
					composite.setOrder(orderService.getOrder(composite));
					updated = true;
					break;
				case "update-Order":
					updated = orderService.updateOrder(composite);
					break;
				case "delete-Order":
					updated = orderService.deleteOrder(composite);
					break;
				default:
					System.out.println("Invalid Operation");

			}

		} catch (ServiceLoadException e1) {
			System.out.println("CoffeeShopManager::Order Operation failed"); // defaulting

		} catch (OrderException e) {
			System.out.println("CoffeeShopManager::Order Operation failed");
		}

		return updated;
	}
}