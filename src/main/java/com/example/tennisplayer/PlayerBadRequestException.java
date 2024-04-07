package com.example.tennisplayer;

public class PlayerBadRequestException extends RuntimeException
{
    public PlayerBadRequestException()
    {
        super();
    }

    public PlayerBadRequestException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PlayerBadRequestException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PlayerBadRequestException(String message)
    {
        super(message);
        System.out.println("Bad Request");
    }

    public PlayerBadRequestException(Throwable cause)
    {
        super(cause);
    }
}
