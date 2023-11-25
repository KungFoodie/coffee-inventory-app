package com.coffeeshop.model.services.data;

import com.coffeeshop.model.domain.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrderDao implements Dao {

    private Map<Integer, Order> orders;
    private Connection connection;
    private Statement statement;
    private ResultSet result;

    public OrderDao() {
        this.orders = new HashMap<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/coffeeshop", "coffeeshop",
                    "coffeeshop123");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }

    /**
     * @return
     */
    @Override
    public Map<Integer, Order> getAll() {
        try {
            this.statement = connection.createStatement();

            // Exceute a select SQL command on the inventory table
            this.result = statement.executeQuery(
                    "select * from orders");

            while (this.result.next()) {

                int empid = Integer.parseInt(result.getString(2));
                Dao data = new EmployeeDao();
                Map<Integer, Employee> employees = data.getAll();
                Employee employee = employees.get(empid);

                String[] itemIDs = result.getString(3).split(",");
                ArrayList<Item> items = new ArrayList<>();
                data = new ItemDao();
                Map<Integer, Item> databaseItems = data.getAll();
                for (String item: itemIDs) {
                    items.add(databaseItems.get(Integer.parseInt(item)));
                }

                int id = result.getInt(1);
                boolean complete = (result.getInt(4) == 1);
                Order order = new Order(id, employee, items, complete);
                this.orders.put(order.getId(), order);
            }
            return this.orders;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * @param item
     * @return
     */
    @Override
    public Boolean add(Object item) {

        try {
            this.statement = connection.createStatement();

            // build sql command
            String sqlCommand = "insert into orders (id, employeeid, "
                    + "itemids, completion) values ";

            Order order = (Order) item;

            ArrayList<Item> items = order.getItemsToMake();
            Employee employee = order.getBarista();
            int id = order.getId();
            boolean complete = order.isComplete();
            String itemIDs = "";
            for (Item itemBuilder: items) {
                itemIDs += itemBuilder.getId() + ",";
            }
            int completeInt = complete ? 1:0;

            String params = new StringBuilder().append("(").append(id).append(", '").
                    append(employee.getId()).append("', '").
                    append(itemIDs).append("', '").
                    append(completeInt).append("');").toString();
            String sql = sqlCommand + params;

            // execute command
            statement.execute(sql);

        } catch (SQLException e) {
            System.err.println(e);
            return false;

        }
        return true;
    }

    /**
     * @param item
     * @return
     */
    @Override
    public Boolean update(Object item) {

        try {
            this.statement = connection.createStatement();

            Order order = (Order) item;

            ArrayList<Item> items = order.getItemsToMake();
            Employee employee = order.getBarista();
            int id = order.getId();
            boolean complete = order.isComplete();
            String itemIDs = "";
            for (Item itemBuilder: items) {
                itemIDs += itemBuilder.getId() + ",";
            }
            int completeInt = complete ? 1:0;


            // build sql command
            String sqlCommand = "update orders set ";
            String params = new StringBuilder().append("employeeid = '").append(employee.getId()).
                    append("', itemids = '").append(itemIDs).append("', completion = ").append(completeInt)
                    .append(" where id = '").append(id).append("';").toString();
            String sql = sqlCommand + params;

            // execute command
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    /**
     * @param item
     * @return
     */
    @Override
    public Boolean delete(Object item) {
        try {
            this.statement = connection.createStatement();

            Order order = (Order) item;

            // build sql command
            String sqlCommand = "delete from orders ";
            String params = "where id = '" + order.getId() + "';";
            String sql = sqlCommand + params;

            // execute command
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
        return true;
    }
}
