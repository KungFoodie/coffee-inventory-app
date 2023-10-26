package com.coffeeshop.model.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeTest {

    @Test
    public void testValidate() {

        Coffee beans = new Coffee();
        assertFalse(beans.validate());

        beans.name = "Java";
        assertFalse(beans.validate());

        beans.location = "3A";
        assertFalse(beans.validate());

        beans.quantity = 1;
        assertFalse(beans.validate());

        beans.expiryDate = "2222-22-22";
        assertFalse(beans.validate());

        beans.expiryDate = "222-10-22";
        assertFalse(beans.validate());

        beans.expiryDate = "2024-10-51";
        assertFalse(beans.validate());

        beans.expiryDate = "2023-02-29";
        assertFalse(beans.validate());

        beans.expiryDate = "2024-10-22";
        assertTrue(beans.validate());

        beans.expiryDate = "2024-02-29";
        assertTrue(beans.validate());

    }

    @Test
    public void testEquals () {

        Coffee bean1 = new Coffee();
        Food chocolate = new Food();

        assertFalse(bean1.equals(chocolate));
        assertTrue(bean1.equals(bean1));

        bean1 = new Coffee("Java", 1, "3A", "2024-10-22");
        chocolate = new Food("Chocolate", 1, "3A", "2024-10-22");

        assertFalse(bean1.equals(chocolate));
        assertTrue(bean1.equals(bean1));

        Coffee bean2 = new Coffee("Salted Caramel", 1, "3A", "2024-10-22");
        assertFalse(bean1.equals(bean2));

        bean2.setName(null);
        assertFalse(bean1.equals(bean2));

        bean2.setName("Java");
        assertTrue(bean1.equals(bean2));

    }
}