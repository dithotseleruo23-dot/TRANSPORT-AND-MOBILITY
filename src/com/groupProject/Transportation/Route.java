package com.groupProject.Transportation;

public class Route {
    private Location start;
    private Location destination;
    TransportMedium vehicle;

    public Route(Location start, Location destination, TransportMedium vehicle){
        this.start = start;
        this.destination = destination;
        this.vehicle = vehicle;
    }

    public Location getStart(){
        return start;
    }

    public Location getDestination(){
        return destination;
    }
}
