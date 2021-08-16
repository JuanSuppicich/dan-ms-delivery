package com.durandsuppicich.danmsdelivery.exception.packages;

import com.durandsuppicich.danmsdelivery.exception.http.NotFoundException;

public class PackageNotFoundException extends NotFoundException {

    private static final String DEFAULT_MESSAGE = "Package could not be found. ";

    public PackageNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public PackageNotFoundException(String message) {
        super(DEFAULT_MESSAGE + message);
    }
}
