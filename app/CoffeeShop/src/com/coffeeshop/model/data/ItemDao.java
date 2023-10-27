package com.coffeeshop.model.data;

import com.coffeeshop.model.domain.*;
import java.sql.*;
import java.util.*;

public class ItemDao implements Dao {

    private ArrayList<Item> items;
    private Connection connection;
    private Statement statement;
    private ResultSet result;

    /**
     * Default Constructor. Initializes the connection to the database.
     */
    public ItemDao() {
        this.items = new ArrayList<Item>();
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
     * Gets all rows from table inventory and adds to list
     * Headers: id, type, name, quantity, location, date
     *
     * @return list of Items, null on error
     */
    @Override
    public ArrayList<Item> getAll() {

        try {
            this.statement = connection.createStatement();

            // Exceute a select SQL command on the inventory table
            this.result = statement.executeQuery(
                    "select * from inventory");

            // Iterate through all rows and print the values from each
            while (this.result.next()) {
                switch (this.result.getString(2).toLowerCase()) {
                    case "food":
                        Food f = new Food(result.getInt(1),
                                result.getString(3),
                                result.getInt(4),
                                result.getString(5),
                                result.getString(6));
                        items.add(f);
                        break;
                    case "coffee":
                        Coffee c = new Coffee(result.getInt(1),
                                result.getString(3),
                                result.getInt(4),
                                result.getString(5),
                                result.getString(6));
                        items.add(c);
                        break;
                    case "syrup":
                        Syrup s = new Syrup(result.getInt(1),
                                result.getString(3),
                                result.getInt(4),
                                result.getString(5),
                                result.getString(6));
                        items.add(s);
                        break;
                }
            }
            return items;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Adds an item object into the database
     *
     * @param item item to be added
     * @return true on success, false on failure
     */
    @Override
    public Boolean add(Object item) {
        try {
            this.statement = connection.createStatement();

            Item newItem = (Item) item;

            // build sql command
            String sqlCommand = "insert into inventory (inventoryid, type, "
                    + "name, quantity, location, expiry) values ";
            String params = new StringBuilder().append("(null, '").append(newItem.getType()).append("', '").
                    append(newItem.getName()).append("', '").
                    append(newItem.getQuantity()).append("', '").append(newItem.getLocation()).append("', '").
                    append(newItem.getExpiryDate()).append("');").toString();
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
     * Updates a row in the database table inventory
     *
     * @param item item to be used to update
     * @return true on success, false on failure
     */
    @Override
    public Boolean update(Object item) {
        try {
            this.statement = connection.createStatement();

            Item newItem = (Item) item;

            // build sql command
            String sqlCommand = "update inventory set ";
            String params = new StringBuilder().append("type = '").append(newItem.getType()).append("', name = '").
                    append(newItem.getName()).append("', quantity = ").append(newItem.getQuantity()).
                    append(", location = '").append(newItem.getLocation()).append("', expiry = '").
                    append(newItem.getExpiryDate()).append("' where inventoryid = '").
                    append(newItem.getId()).append("';").toString();
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
     * Deletes a row from the database based on primary key id.
     *
     * @param item  object to delete based on id
     * @return true on success, false on failure
     */
    @Override
    public Boolean delete(Object item) {
        try {
            this.statement = connection.createStatement();

            Item newItem = (Item) item;

            // build sql command
            String sqlCommand = "delete from inventory ";
            String params = "where inventoryid = '" + newItem.getId() + "';";
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
