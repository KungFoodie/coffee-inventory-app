package com.coffeeshop.model.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Name: William Sung
 * Description: Test class for coffee class
 */
class CoffeeTest {

    /**
     * Test cases for validate method
     */
    @Test
    public void testValidate() {

        Coffee beans = new Coffee();

        // default all null
        assertFalse(beans.validate());

        // blank string
        beans.setName("");
        assertFalse(beans.validate());

        beans.setLocation(-1);
        assertFalse(beans.validate());

        beans.setExpiryDate("");
        assertFalse(beans.validate());

        beans.setStorageLoc("");
        assertFalse(beans.validate());

        // negative quantity
        beans.setQuantity(-10);
        assertFalse(beans.validate());

        // populate one field until complete
        beans.setName("Java");
        assertFalse(beans.validate());

        beans.setLocation(1);
        assertFalse(beans.validate());

        beans.setQuantity(1);
        assertFalse(beans.validate());

        beans.setStorageLoc("3A");
        assertFalse(beans.validate());

        // all valid except date, perform date cases

        // invalid year format
        beans.setExpiryDate("222-10-22");
        assertFalse(beans.validate());

        // invalid month
        beans.setExpiryDate("2222-22-22");
        assertFalse(beans.validate());

        //invalid day
        beans.setExpiryDate("222-10-51");
        assertFalse(beans.validate());

        // invalid leap year
        beans.setExpiryDate("2023-02-29");
        assertFalse(beans.validate());

        // valid date
        beans.setExpiryDate("2024-10-22");
        assertTrue(beans.validate());

        // valid leap year date
        beans.setExpiryDate("2024-02-29");
        assertTrue(beans.validate());

    }

    /**
     * Test cases for equals method
     */
    @Test
    public void testEquals () {

        Coffee bean1 = new Coffee();
        Food chocolate = new Food();

        assertFalse(bean1.equals(chocolate));
        assertTrue(bean1.equals(bean1));

        bean1 = new Coffee(1, "Java", 1, 1, "2024-10-22", "3A");
        chocolate = new Food(2, "Chocolate", 1, 1, "2024-10-22", "3A");

        assertFalse(bean1.equals(chocolate));
        assertTrue(bean1.equals(bean1));

        Coffee bean2 = new Coffee(1, "Salted Caramel", 1, 1, "2024-10-22", "3A");
        assertFalse(bean1.equals(bean2));

        bean2.setName(null);
        assertFalse(bean1.equals(bean2));

        bean2.setName("Java");
        assertTrue(bean1.equals(bean2));

    }
}