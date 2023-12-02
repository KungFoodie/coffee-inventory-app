package com.coffeeshop.presentation;

import com.coffeeshop.model.business.exception.ServiceLoadException;
import com.coffeeshop.model.business.manager.CoffeeShopManager;
import com.coffeeshop.model.domain.*;
import com.coffeeshop.model.services.exception.InventoryException;
import com.coffeeshop.model.services.exception.OrderException;

import java.util.*;

public class Driver {

    public static void main(String[] args) throws InventoryException, OrderException, ServiceLoadException {

        Scanner input = new Scanner(System.in);
        int choice = -1;
        Composite composite = new Composite();
        while (choice != 3) {
            System.out.println("-----Coffee Shop Application-----");
            System.out.println("1. Order Service");
            System.out.println("2. Inventory Service");
            System.out.println("3. Exit");
            try {
                System.out.print("Please make a choice: ");
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please make a valid choice.");
                input.next();
            }

            if (choice == 1) {
                orderMenu(composite);
            } else if (choice == 2) {
                inventoryMenu(composite);
            }

        }
    }

    private static void inventoryMenu(Composite composite) {

        int choice = -1;
        Scanner input = new Scanner(System.in);
        boolean completed = false;
        while (choice != 5) {
            System.out.println("-----Inventory Actions-----");
            System.out.println("1. Create an item");
            System.out.println("2. Retrieve items");
            System.out.println("3. Update an item");
            System.out.println("4. Delete an item");
            System.out.println("5. Exit to main menu");
            System.out.print("Please make a choice: ");
            choice = input.nextInt();

            CoffeeShopManager coffeeShopManager = CoffeeShopManager.getInstance();
            coffeeShopManager.performAction("getAll-Item", composite);
            Map<Integer, Item> items = composite.getItems();
            int id;
            String name;
            int quantity;
            int location;
            String expiry;
            String storage;


            if (choice == 1) {

                int typeChoice = -1;
                while (typeChoice > 3 || typeChoice < 1) {
                    System.out.println("Type \n1. Coffee\n2. Food\n3. Syrup");
                    System.out.print("Type: ");
                    typeChoice = input.nextInt();
                }


                System.out.print("Name: ");
                name = input.next();
                System.out.print("Quantity: ");
                quantity = input.nextInt();
                System.out.print("Location ID: ");
                location = input.nextInt();
                System.out.print("Expiry Date: ");
                expiry = input.next();
                System.out.print("Storage ID: ");
                storage = input.next();

                System.out.println();
                Item add = null;

                switch (typeChoice) {
                    case 1:
                        add = new Coffee(1, name, quantity, location, expiry, storage);
                        break;
                    case 2:
                        add = new Food(1, name, quantity, location, expiry, storage);
                        break;
                    case 3:
                        add = new Syrup(1, name, quantity, location, expiry, storage);
                        break;
                    default:
                        System.out.println("Invalid item type");
                }
                composite.setItem(add);
                completed = coffeeShopManager.performAction("add-Item", composite);
            }

            if (choice == 2) {

                completed = coffeeShopManager.performAction("getAll-Item", composite);
                items = composite.getItems();
                System.out.println("----Full Inventory----");
                for (int key: items.keySet()){
                    Item i = items.get(key);
                    System.out.println("Item ID: " + key);
                    System.out.println("Type: " + i.getType());
                    System.out.println("Name: " + i.getName());
                    System.out.println("Quantity " + i.getQuantity());
                    System.out.println("Store ID: " + i.getStore());
                    System.out.println("Expiry Date: " + i.getExpiryDate());
                    System.out.println("Shelf ID: " + i.getStorageLoc());
                    System.out.println("-----------------------------------");
                }
            }

            if (choice == 3) {
                coffeeShopManager.performAction("getAll-Item", composite);
                items = composite.getItems();
                Item updateThis = null;
                int updateID = -1;
                while (updateThis == null) {
                    System.out.println("Enter item ID to update (-1 to cancel): ");
                    updateID = input.nextInt();
                    if (updateID == -1) {
                        break;
                    }
                    updateThis = items.get(updateID);
                }
                if (updateID == -1) {
                    break;
                }

                System.out.println("Retrieved Item: ");
                System.out.println(updateThis);

                System.out.println("Please input updated information");
                System.out.print("Name: ");
                input.next();
                name = input.nextLine();
                System.out.print("Quantity: ");
                quantity = input.nextInt();
                System.out.print("Location ID: ");
                location = input.nextInt();
                System.out.print("Expiry Date: ");
                expiry = input.next();
                System.out.print("Storage ID: ");
                storage = input.next();

                updateThis.setName(name);
                updateThis.setQuantity(quantity);
                updateThis.setStore(location);
                updateThis.setExpiryDate(expiry);
                updateThis.setStorageLoc(storage);

                composite.setItem(updateThis);


                completed = coffeeShopManager.performAction("update-Item", composite);
            }

            if (choice == 4 ) {
                coffeeShopManager.performAction("getAll-Item", composite);
                items = composite.getItems();
                Item deleteThis = null;
                int deleteID = -1;
                while (deleteThis == null) {
                    System.out.println("Enter item ID to delete (-1 to cancel): ");
                    deleteID = input.nextInt();
                    if (deleteID == -1) {
                        break;
                    }
                    deleteThis = items.get(deleteID);
                }
                if (deleteID == -1) {
                    break;
                }

                composite.setItem(deleteThis);

                completed = coffeeShopManager.performAction("delete-Item", composite);
            }

            if (!completed) {
                System.out.println("Failed to perform action. Please try again.");
            }
        }
    }

    private static void orderMenu(Composite composite) {
        CoffeeShopManager coffeeShopManager = CoffeeShopManager.getInstance();
        coffeeShopManager.performAction("getAll-Item", composite);
        coffeeShopManager.performAction("getAll-Order", composite);
        coffeeShopManager.performAction("getAll-Employee", composite);
        Map<Integer, Item> items = composite.getItems();
        Map<Integer, Order> orders = composite.getOrders();
        Map<Integer, Employee> employees = composite.getEmployees();
        ArrayList<Item> itemsToMake = new ArrayList<>();
        Item makeItem = null;
        Employee employee = null;
        int choice = -1;
        Scanner input = new Scanner(System.in);
        boolean completed = false;
        while (choice != 5) {
            System.out.println("-----Order Actions-----");
            System.out.println("1. Create");
            System.out.println("2. Retrieve");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit to main menu");
            System.out.print("Please make a choice: ");
            choice = input.nextInt();


            int id;
            int employeeid;
            int itemid;
            boolean complete = false;

            if (choice == 1) {
                System.out.println("----Employees----");
                int i = 1;
                for (int key: employees.keySet()) {
                    System.out.println("ID: " + employees.get(key).getId() + " Name: " + employees.get(key).getFname());
                }
                while (employee == null) {
                    System.out.print("Enter Employee ID to make order: ");
                    employeeid = input.nextInt();
                    employee = employees.get(employeeid);
                }

                while (!complete) {
                    for (int key : items.keySet()) {
                        System.out.println("ID: " + items.get(key).getId() + " Name: " + items.get(key).getName());
                    }
                    while (makeItem == null) {
                        System.out.print("Enter Item ID: ");
                        itemid = input.nextInt();
                        makeItem = items.get(itemid);
                    }
                    itemsToMake.add(makeItem);
                    System.out.print("Add another item (y/n): ");
                    complete = input.next().equals("n");
                    makeItem = null;
                }

                Order newOrder = new Order(1, employee, itemsToMake, false);
                composite.setOrder(newOrder);
                completed = coffeeShopManager.performAction("add-Order", composite);

            }

            if (choice == 2) {
                coffeeShopManager.performAction("getAll-Item", composite);
                coffeeShopManager.performAction("getAll-Order", composite);
                coffeeShopManager.performAction("getAll-Employee", composite);
                completed = coffeeShopManager.performAction("getAll-Order", composite);
                orders = composite.getOrders();
                for (int key: orders.keySet()) {
                    System.out.println("----Orders----");
                    System.out.println("ID: " + key);
                    System.out.println("Employee Assigned: " + orders.get(key).getBarista().getFname());
                    System.out.println("Order Items");
                    for (Item i: orders.get(key).getItemsToMake()) {
                        System.out.println(i.getName());
                    }
                    System.out.println("Order complete: " + (orders.get(key).isComplete() ? "Yes": "No"));
                    System.out.println("-----------------------------------");
                }
            }

            if (choice == 3) {
                coffeeShopManager.performAction("getAll-Item", composite);
                coffeeShopManager.performAction("getAll-Order", composite);
                coffeeShopManager.performAction("getAll-Employee", composite);

                orders = composite.getOrders();
                for (int key: orders.keySet()) {
                    System.out.println("----Orders----");
                    System.out.println("ID: " + key);
                    System.out.println("Employee Assigned: " + orders.get(key).getBarista().getFname());
                    System.out.println("Order Items");
                    for (Item i: orders.get(key).getItemsToMake()) {
                        System.out.println(i.getName());
                    }
                    System.out.println("Order complete: " + (orders.get(key).isComplete() ? "Yes": "No"));
                    System.out.println("-----------------------------------");
                }

                Order updateOrder = null;
                while (updateOrder == null) {
                    System.out.print("Enter order ID to update: ");
                    int updateID = input.nextInt();
                    updateOrder = orders.get(updateID);
                }

                System.out.println("Retrieved Order: ");

                System.out.println("ID: " + updateOrder.getId());
                System.out.println("Employee Assigned: " + updateOrder.getBarista().getFname());
                System.out.println("Order Items");
                for (Item i: updateOrder.getItemsToMake()) {
                    System.out.println(i.getName());
                }
                System.out.println("Order complete: " + (updateOrder.isComplete() ? "Yes": "No"));
                System.out.println("-----------------------------------");
                System.out.println("Please enter updated information: ");
                System.out.println("----Employees----");
                int i = 1;
                for (int key: employees.keySet()) {
                    System.out.println("ID: " + employees.get(key).getId() + " Name: " + employees.get(key).getFname());
                }
                while (employee == null) {
                    System.out.print("Enter Employee ID to make order: ");
                    employeeid = input.nextInt();
                    employee = employees.get(employeeid);
                }

                while (!complete) {
                    for (int key : items.keySet()) {
                        System.out.println("ID: " + items.get(key).getId() + " Name: " + items.get(key).getName());
                    }
                    while (makeItem == null) {
                        System.out.print("Enter Item ID: ");
                        itemid = input.nextInt();
                        makeItem = items.get(itemid);
                    }
                    itemsToMake.add(makeItem);
                    System.out.print("Add another item (y/n): ");
                    complete = input.next().equals("n");
                    makeItem = null;
                }

                System.out.print("Order Complete (y/n): ");
                boolean completedOrder = input.next().equals("y");
                updateOrder.setBarista(employee);
                updateOrder.setItemsToMake(itemsToMake);
                updateOrder.setComplete(completedOrder);
                composite.setOrder(updateOrder);

                completed = coffeeShopManager.performAction("update-Order", composite);
            }

            if (choice == 4 ) {
                coffeeShopManager.performAction("getAll-Item", composite);
                coffeeShopManager.performAction("getAll-Order", composite);
                coffeeShopManager.performAction("getAll-Employee", composite);

                orders = composite.getOrders();
                for (int key: orders.keySet()) {
                    System.out.println("----Orders----");
                    System.out.println("ID: " + key);
                    System.out.println("Employee Assigned: " + orders.get(key).getBarista().getFname());
                    System.out.println("Order Items");
                    for (Item i: orders.get(key).getItemsToMake()) {
                        System.out.println(i.getName());
                    }
                    System.out.println("Order complete: " + (orders.get(key).isComplete() ? "Yes": "No"));
                    System.out.println("-----------------------------------");
                }

                Order updateOrder = null;
                while (updateOrder == null) {
                    System.out.print("Enter order ID to delete: ");
                    int updateID = input.nextInt();
                    updateOrder = orders.get(updateID);
                }

                System.out.println("Deleted Order: ");

                System.out.println("ID: " + updateOrder.getId());
                System.out.println("Employee Assigned: " + updateOrder.getBarista().getFname());
                System.out.println("Order Items");
                for (Item i: updateOrder.getItemsToMake()) {
                    System.out.println(i.getName());
                }
                System.out.println("Order complete: " + (updateOrder.isComplete() ? "Yes": "No"));
                System.out.println("-----------------------------------");

                composite.setOrder(updateOrder);
                completed = coffeeShopManager.performAction("delete-Order", composite);
            }

            if (!completed) {

                System.out.println("Failed to perform action. Please try again.");
            }

        }
    }

}
