package com.groupProject.Transportation;

import com.groupProject.Exceptions.InvalidFareException;

public class Taxi extends TransportMedium {

    private final double baseFare = 10.00;
    private final double specialFare = 40.00;
    private final double distanceThreshold = 6.0; 
    private boolean isSpecial;

    public Taxi(String name) {
        super(name);
        this.isSpecial = false;
        try {
            setBaseFare(baseFare);
        } catch (InvalidFareException e) {
            System.out.println("Error setting taxi fare: " + e.getMessage());
        }
    }

    public Taxi(String name, String routeName, boolean isSpecial) {
        super(name, routeName);
        this.isSpecial = isSpecial;
        try {
            if (isSpecial) {
                setBaseFare(specialFare);
            } else {
                setBaseFare(baseFare);
            }
        } catch (InvalidFareException e) {
            System.out.println("Error setting taxi fare: " + e.getMessage());
        }
    }

    @Override
    public double calculateFare(double distance) {
        if (distance > distanceThreshold) {
            return specialFare;
        } else {
            return baseFare;
        }
    }

    public boolean Special() {
        return isSpecial;
    }

    @Override
    public void displayInfo() {
        System.out.println("Type     : Taxi");
        System.out.println("Name     : " + getName());
        System.out.println("Route    : " + (getRouteName() != null ? getRouteName() : "Not assigned"));
        System.out.println("Fare     : P" + getBaseFare() + " (" + (isSpecial ? "Long distance" : "Short distance") + ")");
        System.out.println("Available: " + (isAvailable() ? "Yes" : "No"));
    }
}
