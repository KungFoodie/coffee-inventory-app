package com.coffeeshop.model.services.data;
import java.util.*;

/**
 * Name: William Sung
 * Interface for DAO
 */
public interface Dao<T> {

    Map<T, T> getAll();
    Boolean add(T item);
    Boolean update(T item);
    Boolean delete(T item);

}

