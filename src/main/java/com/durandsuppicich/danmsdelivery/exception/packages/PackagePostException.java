package com.durandsuppicich.danmsdelivery.exception.packages;

public class PackagePostException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Something went wrong when trying to create the package. Please try again. ";

    public PackagePostException() {
        super(DEFAULT_MESSAGE);
    }

    public PackagePostException(String message) {
        super(DEFAULT_MESSAGE + message);
    }
}
