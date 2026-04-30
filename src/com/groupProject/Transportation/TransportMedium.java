package com.groupProject.Transportation;

import com.groupProject.Services.fareCalculator;
import com.groupProject.Exceptions.InvalidFareException;

public abstract class TransportMedium implements fareCalculator {

    private String name;
    private String routeName;
    private double baseFare;
    private boolean isAvailable = true;

    // Constructor 1 - name only
    public TransportMedium(String name) {
        this.name = name;
    }

    // Constructor 2 - name and route (uses constructor chaining)
    public TransportMedium(String name, String routeName) {
        this(name);
        this.routeName = routeName;
    }

    // Abstract method - subclasses must provide their own fare logic
    public abstract double calculateFare(double distance);

    // Getters
    public String getName() { return name; }
    public String getRouteName() { return routeName; }
    public double getBaseFare() { return baseFare; }
    public boolean isAvailable() { return isAvailable; }

    // Setters
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    // Throws InvalidFareException if a negative fare is passed
    public void setBaseFare(double FARE) throws InvalidFareException {
        if (FARE < 0) {
            throw new InvalidFareException("Fare cannot be negative: " + FARE);
        }
        this.baseFare = FARE;
    }

    public void displayInfo() {
        System.out.println("Name     : " + name);
        System.out.println("Route    : " + (routeName != null ? routeName : "Not assigned"));
        System.out.println("Fare     : P" + baseFare);
    }
}
