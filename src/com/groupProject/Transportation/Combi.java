package com.groupProject.Transportation;

import com.groupProject.Exceptions.InvalidFareException;

public class Combi extends TransportMedium {

    private static final double combiFare = 9.00;

    public Combi(String name) {
        super(name);
        try {
            setBaseFare(combiFare);
        } catch (InvalidFareException e) {
            System.out.println("Error setting combi fare: " + e.getMessage());
        }
    }

    public Combi(String name, String routeName) {
        super(name, routeName);
        try {
            setBaseFare(combiFare);
        } catch (InvalidFareException e) {
            System.out.println("Error setting combi fare: " + e.getMessage());
        }
    }

   @Override
    public double calculateFare(double distance) {
        return getBaseFare();
    }

    @Override
    public void displayInfo() {
        System.out.println("Type     : Combi");
        System.out.println("Name     : " + getName());
        System.out.println("Route    : " + (getRouteName() != null ? getRouteName() : "Not assigned"));
        System.out.println("Flat Fare: P" + getBaseFare());
        System.out.println("Available: " + (isAvailable() ? "Yes" : "No"));
    }
}
