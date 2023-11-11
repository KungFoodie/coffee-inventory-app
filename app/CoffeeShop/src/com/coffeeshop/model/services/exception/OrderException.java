package com.coffeeshop.model.services.exception;

public class OrderException extends Exception{

    public OrderException (final String inMessage)
    {
        super(inMessage);
    }


    public OrderException (final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
}
