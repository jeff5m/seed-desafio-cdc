package com.deveficiente.casadocodigo.exptionhandler;

public class InvalidField {

    private final String name;
    private final String message;

    public InvalidField(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
