package com.coffeeshop.model.domain;

import java.io.Serializable;

/**
 * Class contains employee information in system.
 * @author William Sung
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String fname;
    private String lname;
    private String role;
    private String uname;
    private String passwd;

    /**
     * Default Constructor
     */
    public Employee () {
        this.id = -1;
        this.fname = null;
        this.lname = null;
        this.role = null;
        this.uname = null;
        this.passwd = null;
    }

    /**
     * Copy Constructor
     * @param id Value to copy
     * @param fname Value to copy
     * @param lname Value to copy
     * @param role Value to copy
     * @param uname Value to copy
     * @param passwd Value to copy
     */
    public Employee(int id, String fname, String lname, String role, String uname, String passwd) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.role = role;
        this.uname = uname;
        this.passwd = passwd;
    }

    /**
     * Getter for employee ID
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for ID
     * @param id value to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for first name
     * @return fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * Setter for first name
     * @param fname value to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * Getter for last name
     * @return value to set
     */
    public String getLname() {
        return lname;
    }

    /**
     * Setter for last name
     * @param lname value to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * Getter for role
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * Setter for role
     * @param role value to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Getter for user name
     * @return uname
     */
    public String getUname() {
        return uname;
    }

    /**
     * setter for username
     * @param uname value to set
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * Getter for password
     * @return passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * Setter for password
     * @param passwd value to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;

        if (id != employee.id) return false;
        if (!fname.equals(employee.fname)) return false;
        if (!lname.equals(employee.lname)) return false;
        if (!role.equals(employee.role)) return false;
        if (!uname.equals(employee.uname)) return false;
        return passwd.equals(employee.passwd);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fname.hashCode();
        result = 31 * result + lname.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + uname.hashCode();
        result = 31 * result + passwd.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", role='" + role + '\'' +
                ", uname='" + uname + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
