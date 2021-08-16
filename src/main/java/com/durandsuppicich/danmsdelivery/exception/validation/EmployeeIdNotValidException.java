package com.durandsuppicich.danmsdelivery.exception.validation;

import com.durandsuppicich.danmsdelivery.exception.http.BadRequestException;

public class EmployeeIdNotValidException extends BadRequestException {

    private static final String DEFAULT_MESSAGE = "The given employee id is invalid. ";

    public EmployeeIdNotValidException() {
        super(DEFAULT_MESSAGE);
    }

    public EmployeeIdNotValidException(Integer id) {
        super(DEFAULT_MESSAGE + "{" + id + "}");
    }
}
