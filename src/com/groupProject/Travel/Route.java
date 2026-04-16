package com.groupProject.Travel;

import com.groupProject.Transportation.TransportMedium;
import java.util.ArrayList;

public class Route {
    private Location start;
    private ArrayList<Location> stops;
    private String routeName;
    private Location destination;
    private TransportMedium vehicle;

    public Route(Location start, String routeName, TransportMedium vehicle, Location destination){
        this.start = start;
        this.routeName = routeName;
        this.stops = new ArrayList<>();
        this.destination = destination;
        this.vehicle = vehicle;
    }

    public Location getStart(){
        return start;
    }

    public String routeName(){
        return routeName;
    }

    public Location getDestination(){
        return destination;
    }

    public void addStop(Location location){
        stops.add(location);
    }

    /**public boolean directRoute(){
        return ...;
    }**/
}
