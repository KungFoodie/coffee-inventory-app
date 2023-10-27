package com.coffeeshop.model.persistence;
import java.util.*;

/**
 * Name: William Sung
 * Interface for DAO
 */
public interface Dao<T> {

    ArrayList<T> getAll();
    Boolean add(T item);
    Boolean update(T item);
    Boolean delete(T item);

}

