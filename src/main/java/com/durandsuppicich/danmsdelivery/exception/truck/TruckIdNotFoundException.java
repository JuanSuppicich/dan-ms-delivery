package com.durandsuppicich.danmsdelivery.exception.truck;

public class TruckIdNotFoundException extends TruckNotFoundException {

    private static final String DEFAULT_MESSAGE = "The given id does not belong to any truck. ";

    public TruckIdNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public TruckIdNotFoundException(Integer id) {
        super(DEFAULT_MESSAGE + "{" + id + "}");
    }

}
