package com.coffeeshop.model.services.data;

import com.coffeeshop.model.domain.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeDao implements Dao {
    private Map<Integer, Employee> employees;
    private Connection connection;
    private Statement statement;
    private ResultSet result;
    public EmployeeDao() {
        this.employees = new HashMap<>();
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
    public Map<Integer, Employee> getAll() {
        try {
            this.statement = connection.createStatement();

            // Exceute a select SQL command on the inventory table
            this.result = statement.executeQuery(
                    "select * from employees");

            while (this.result.next()) {
                Employee emp = new Employee(result.getInt(1), result.getString(2), result.getString(3),
                        result.getString(4), result.getString(5), result.getString(6));
                this.employees.put(emp.getId(), emp);
            }
            return this.employees;
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

            Employee newItem = (Employee) item;

            // build sql command
            String sqlCommand = "insert into employees (id, fname, "
                    + "lname, role, uname, passwd) values ";
            String params = new StringBuilder().append("(").append(newItem.getId()).append(", '").
                    append(newItem.getFname()).append("', '").
                    append(newItem.getLname()).append("', '").
                    append(newItem.getRole()).append("', '").append(newItem.getUname()).append("', '").
                    append(newItem.getPasswd()).append("');").toString();
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

            Employee newItem = (Employee) item;

            // build sql command
            String sqlCommand = "update employees set ";
            String params = new StringBuilder().append("fname = '").append(newItem.getFname()).append("', lname = '").
                    append(newItem.getLname()).append("', role = '").append(newItem.getRole()).
                    append("', uname = '").append(newItem.getUname()).append("', passwd = '").
                    append(newItem.getPasswd()).append("' where id = ").
                    append(newItem.getId()).append(";").toString();
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

            Employee newItem = (Employee) item;

            // build sql command
            String sqlCommand = "delete from employees ";
            String params = "where id = '" + newItem.getId() + "';";
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
