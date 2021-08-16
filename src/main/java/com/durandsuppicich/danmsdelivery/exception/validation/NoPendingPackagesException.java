package com.durandsuppicich.danmsdelivery.exception.validation;

import com.durandsuppicich.danmsdelivery.exception.http.BadRequestException;

public class NoPendingPackagesException extends BadRequestException {

    private static final String DEFAULT_MESSAGE = "There are no pending packages waiting to be sent. ";

    public NoPendingPackagesException() {
        super(DEFAULT_MESSAGE);
    }

    public NoPendingPackagesException(String message) {
        super(DEFAULT_MESSAGE + message);
    }
}
