package com.deveficiente.casadocodigo.exptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<InvalidField> invalidFields = new ArrayList<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(fieldError -> invalidFields.add(
                        new InvalidField(
                                fieldError.getField(),
                                fieldError.getDefaultMessage()
                        ))
                );

        return new ResponseEntity<>(
                new ValidationExceptionDetails(status.value(), "One or more fields are invalid!", invalidFields), HttpStatus.BAD_REQUEST
        );
    }
}
