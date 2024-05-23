package org.examen.exceptions;

public class BbddException extends Exception {

    public BbddException(String message) {
        super("\033[31m" + message + "\033[0m");
    }

}
