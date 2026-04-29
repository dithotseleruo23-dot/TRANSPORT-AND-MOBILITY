package com.groupProject.Transportation;

public abstract class TransportMedium {
    protected String name;
    protected String routeName;
    protected double baseFare;
    protected boolean isAvailable;
    protected int tripsCompleted;

    public TransportMedium(String name) {
        this.name = name;
        this.isAvailable = true;
        this.tripsCompleted = 0;
    }
    
    public TransportMedium(String name, String routeName) {
        this(name);
        this.routeName = routeName;
    }

    public void completeTrip() {
        tripsCompleted++;
        isAvailable = true;
    }
    
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    
    public void setBaseFare(double baseFare) {
        this.baseFare = baseFare;
    }
    
    // Getters
    public String getName() { return name; }
    public String getRouteName() { return routeName; }
    public double getBaseFare() { return baseFare; }
    public boolean isAvailable() { return isAvailable; }
    public int getTripsCompleted() { return tripsCompleted; }
    
    public void displayInfo() {
        System.out.printf("%s | %s | %s | Trips: %d%n",
            name, 
            routeName != null ? routeName : "No route",
            isAvailable ? "AVAILABLE" : "BUSY",
            tripsCompleted);
    }
}
