package com.durandsuppicich.danmsdelivery.exception.validation;

import com.durandsuppicich.danmsdelivery.exception.http.BadRequestException;

public class TruckIdNotValidException extends BadRequestException {

    private static final String DEFAULT_MESSAGE = "The given truck id is invalid. ";

    public TruckIdNotValidException() {
        super(DEFAULT_MESSAGE);
    }

    public TruckIdNotValidException(Integer id) {
        super(DEFAULT_MESSAGE + "{" + id + "}");
    }

}
