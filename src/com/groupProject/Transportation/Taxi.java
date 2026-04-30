package com.groupProject.Transportation;

public class Taxi extends TransportMedium {

    private final double baseFare = 10.00;
    private final double specialFare = 40.00;
    private final double distanceThreshold = 6.0; // km

    private boolean isSpecial;

    // Constructor 1 - name only, defaults to short distance
    public Taxi(String name) {
        super(name);
        this.isSpecial = false;
        setBaseFare(baseFare);
    }

    // Constructor 2 - name, route and special flag
    public Taxi(String name,String routeName, boolean isSpecial) {
        super(name, routeName);
        this.isSpecial = isSpecial;
        if (isSpecial) {
            setBaseFare(specialFare);
        } else {
            setBaseFare(baseFare);
        }
    }

    // Taxi fare depends on distance
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

