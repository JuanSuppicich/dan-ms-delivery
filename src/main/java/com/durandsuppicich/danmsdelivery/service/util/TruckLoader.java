package com.durandsuppicich.danmsdelivery.service.util;

import com.durandsuppicich.danmsdelivery.domain.Delivery;
import com.durandsuppicich.danmsdelivery.domain.Package;
import com.durandsuppicich.danmsdelivery.domain.Truck;

import java.util.List;

public final class TruckLoader {

    // This method doesn't optimize for weight or volume, it just loads based in the package's post date.

    public static void load(Truck truck, List<Package> packages, Delivery delivery) {

        double remainingWeight = truck.getMaxWeight();
        double remainingVolume = truck.getMaxVolume();

        for(Package p : packages) {

            remainingWeight -= p.getWeight();
            remainingVolume -= remainingVolume - p.getVolume();

            if (remainingWeight > 0 && remainingVolume > 0) delivery.addPackage(p);
            else return;
        }
    }
}
