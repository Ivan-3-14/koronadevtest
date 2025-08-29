package com.sigmaproject.exception;

public class CustomIllArgException extends IllegalArgumentException {

    private static final String mainMessage = "The program terminated with an error: ";

    public CustomIllArgException(String s) {
        printErrorMessage(s);
    }

    public static void printErrorMessage(String message) {
        System.err.print(mainMessage);
        System.err.print("");
        System.err.print(message);
    }
}
