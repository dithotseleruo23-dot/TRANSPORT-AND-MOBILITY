package com.groupProject.Services;

import java.util.List;
import java.util.ArrayList;
import com.groupProject.Travel.Route;
import com.groupProject.Transportation.TransportMedium;

public class TransportSystem {
    private List<Route> routes = new ArrayList<>();
    private List<TransportMedium> transports = new ArrayList<>();

    public void addRoute(Route route) {
        routes.add(route);
    }

    public List<Route> getRoutes() {
        return routes;
    }
    
    public void addTransport(TransportMedium transport) {
        transports.add(transport);
    }
    
    public List<TransportMedium> getTransports() {
        return transports;
    }
    
    public List<TransportMedium> getAvailableTransports() {
        List<TransportMedium> available = new ArrayList<>();
        for (TransportMedium t : transports) {
            if (t.isAvailable()) {
                available.add(t);
            }
        }
        return available;
    }
}
