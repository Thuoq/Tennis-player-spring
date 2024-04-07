package com.example.tennisplayer;
public class PlayerNotFoundException extends RuntimeException{


    public PlayerNotFoundException() {
        super();

    }

    public PlayerNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }

    public PlayerNotFoundException(String message, Throwable cause) {
        super(message, cause);

    }

    public PlayerNotFoundException(String message) {
        // log
        super(message);
        System.out.println("Player not found");


    }

    public PlayerNotFoundException(Throwable cause) {
        super(cause);
    }
}
