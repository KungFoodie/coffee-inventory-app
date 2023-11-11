package com.coffeeshop.model.services.exception;

public class InventoryException extends Exception {



    public InventoryException(final String inMessage)
    {
        super(inMessage);
    }


    public InventoryException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
}
