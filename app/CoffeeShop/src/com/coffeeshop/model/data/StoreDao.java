package com.coffeeshop.model.data;

import com.coffeeshop.model.domain.*;

import java.sql.*;
import java.util.ArrayList;

public class StoreDao implements Dao {


    private ArrayList<Store> locations;
    private Connection connection;
    private Statement statement;
    private ResultSet result;

    /**
     * Default Constructor. Initializes the connection to the database.
     */
    public StoreDao() {
        this.locations = new ArrayList<Store>();
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
     * Gets all rows from table locations and adds to list
     * Headers: id, name, streetno, streetname, city, zip, phone
     *
     * @return list of locations, null on error
     */
    @Override
    public ArrayList<Store> getAll() {

        try {
            this.statement = connection.createStatement();

            // Exceute a select SQL command on the inventory table
            this.result = statement.executeQuery(
                    "select * from locations");

            // Iterate through all rows and print the values from each
            while (this.result.next()) {
                Store l = new Store(result.getInt(1), result.getString(2),
                        result.getInt(3), result.getString(4), result.getString(5),
                        result.getInt(6), result.getString(7));
                locations.add(l);
            }
            return locations;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Adds a location object into the database
     *
     * @param item location to be added
     * @return true on success, false on failure
     */
    @Override
    public Boolean add(Object item) {
        try {
            this.statement = connection.createStatement();

            Store l = (Store) item;

            // build sql command
            String sqlCommand = "insert into locations (id, name, streetno, streetname, city, zip, phone) values ";
            String params = new StringBuilder().append("('").append(l.getLocationID()).append("', '")
                    .append(l.getName()).append("', '").append(l.getStreetNo()).append("', '")
                    .append(l.getStreetName()).append("', '").append(l.getCity()).append("', '")
                    .append(l.getZip()).append("', '").append(l.getPhone()).append("');").toString();
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
     * Updates a row in the database table locations
     *
     * @param item item to be used to update
     * @return true on success, false on failure
     */
    @Override
    public Boolean update(Object item) {
        try {
            this.statement = connection.createStatement();

            Store l = (Store) item;

            // build sql command
            String sqlCommand = "update locations set ";
            String params = new StringBuilder().append(" name = '").append(l.getName()).append("', streetno = '").
                    append(l.getStreetNo()).append("', streetname = '").append(l.getStreetName()).append("', city = '").
                    append(l.getCity()).append("', zip = '").append(l.getZip()).append("', phone = '").
                    append(l.getPhone()).append("' where id = '").
                    append(l.getLocationID()).append("';").toString();
            String sql = sqlCommand + params;
            System.out.println(sql);
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

            Store l = (Store) item;

            // build sql command
            String sqlCommand = "delete from locations ";
            String params = "where id = '" + l.getLocationID() + "';";
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
