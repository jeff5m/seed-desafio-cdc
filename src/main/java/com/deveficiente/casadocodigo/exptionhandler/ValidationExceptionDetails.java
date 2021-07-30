package com.deveficiente.casadocodigo.exptionhandler;

import java.util.List;

public class ValidationExceptionDetails {

    private final int status;
    private final String title;
    private final List<InvalidField> invalidFields;

    public ValidationExceptionDetails(int status, String title, List<InvalidField> invalidFields) {
        this.status = status;
        this.title = title;
        this.invalidFields = invalidFields;
    }

    public int getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public List<InvalidField> getInvalidFields() {
        return invalidFields;
    }
}
