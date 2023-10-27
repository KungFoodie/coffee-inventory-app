package com.coffeeshop.model.persistence;

import com.coffeeshop.model.domain.Coffee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemDaoTest {

    @Test
    public void dbTest () {
        ItemDao app = new ItemDao();
        Coffee c = new Coffee(1, "Java", 1, "3B", "2022-10-21");

        app.add(c);

        c.setLocation("3A");
        app.update(c);

        app.delete(c);
    }


}