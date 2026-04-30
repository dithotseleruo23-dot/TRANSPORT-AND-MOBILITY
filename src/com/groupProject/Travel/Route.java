package com.groupProject.Travel;

import com.groupProject.Transportation.TransportMedium;
import java.util.ArrayList;


public class Route {

    private String routeName;
    private Location start;
    private Location destination;
    private TransportMedium vehicle;
    private ArrayList<Location> stops;

    public Route(Location start, String routeName, TransportMedium vehicle, Location destination) {
        this.start = start;
        this.routeName = routeName;
        this.vehicle = vehicle;
        this.destination = destination;
        this.stops = new ArrayList<Location>();
    }

    public void addStop(Location location) {
        stops.add(location);
    }

    public boolean isDirectRoute() {
        return stops.isEmpty();
    }

    public String getRouteName() { return routeName; }
    public Location getStart() { return start; }
    public Location getDestination() { return destination; }
    public TransportMedium getVehicle() { return vehicle; }
    public ArrayList<Location> getStops() { return stops; }

    public void displayInfo() {
        System.out.println("Route    : " + routeName);
        System.out.println("From     : " + start.getPlace());
        System.out.println("To       : " + destination.getPlace());
        System.out.println("Vehicle  : " + vehicle.getName());
        System.out.println("Direct   : " + (isDirectRoute() ? "Yes" : "No"));
    }
}

