package com.durandsuppicich.danmsdelivery.exception.packages;

public class PackageIdNotFoundException extends PackageNotFoundException {

    private static final String DEFAULT_MESSAGE = "The given id does not belong to any package. ";

    public PackageIdNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public PackageIdNotFoundException(Integer id) {
        super(DEFAULT_MESSAGE + "{" + id + "}");
    }


}
