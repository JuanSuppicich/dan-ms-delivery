package com.durandsuppicich.danmsdelivery.exception.truck;

import com.durandsuppicich.danmsdelivery.exception.http.NotFoundException;

public class TruckNotFoundException extends NotFoundException {

    private static final String DEFAULT_MESSAGE = "Truck could not be found. ";

    public TruckNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public TruckNotFoundException(String message) {
        super(DEFAULT_MESSAGE + message);
    }
}
