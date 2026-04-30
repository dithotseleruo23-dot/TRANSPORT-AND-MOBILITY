package com.groupProject.Travel;

import com.groupProject.Transportation.TransportMedium;
import java.util.ArrayList;

public class Route {

    private String routeName;
    private Location start;
    private Location destination;
    private TransportMedium vehicle;
    private ArrayList<Location> stops;
    private double distance; // km - used for automatic fare calculation

    // Constructor now takes distance so each route knows how long it is
    public Route(Location start, String routeName, TransportMedium vehicle, Location destination, double distance) {
        this.start = start;
        this.routeName = routeName;
        this.vehicle = vehicle;
        this.destination = destination;
        this.stops = new ArrayList<Location>();
        this.distance = distance;
    }

    public void addStop(Location location) {
        stops.add(location);
    }

    public boolean isDirectRoute() {
        return stops.isEmpty();
    }

    // Getters
    public String getRouteName() { return routeName; }
    public Location getStart() { return start; }
    public Location getDestination() { return destination; }
    public TransportMedium getVehicle() { return vehicle; }
    public ArrayList<Location> getStops() { return stops; }
    public double getDistance() { return distance; }

    public void displayInfo() {
        System.out.println("Route    : " + routeName);
        System.out.println("From     : " + start.getPlace());
        System.out.println("To       : " + destination.getPlace());
        System.out.println("Vehicle  : " + vehicle.getName());
        System.out.println("Distance : " + distance + " km");
        System.out.println("Direct   : " + (isDirectRoute() ? "Yes" : "No"));
    }
}

