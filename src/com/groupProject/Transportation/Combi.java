package com.groupProject.Transportation;

public class Combi extends TransportMedium {

    // Standard combi fare in Gaborone
    private static final double combiFare = 9.00;

    // Constructor 1 - name only
    public Combi(String name) {
        super(name);
        setBaseFare(combiFare);
    }

    // Constructor 2 - name and route
    public Combi(String name, String routeName) {
        super(name, routeName);
        setBaseFare(combiFare);
    }

    // Combi charges a flat fare no matter the distance
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
