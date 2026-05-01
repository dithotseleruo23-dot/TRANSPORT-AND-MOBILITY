package com.groupProject.Services;

import com.groupProject.Transportation.TransportMedium;
import com.groupProject.Travel.Route;
import com.groupProject.Exceptions.RouteNotFoundException;
import java.util.ArrayList;

public class TransportSystem {

    private ArrayList<TransportMedium> transports;
    private ArrayList<Route> routes;

    public TransportSystem() {
        transports = new ArrayList<TransportMedium>();
        routes = new ArrayList<Route>();
    }

    public void addTransport(TransportMedium transport) {
        transports.add(transport);
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public ArrayList<TransportMedium> getTransports() {
        return transports;
    }

    public ArrayList<Route> getRoutes() {
        return routes;
    }

    public ArrayList<TransportMedium> getAvailableTransports() {
        ArrayList<TransportMedium> available = new ArrayList<TransportMedium>();
        for (int i = 0; i < transports.size(); i++) {
            if (transports.get(i).isAvailable()) {
                available.add(transports.get(i));
            }
        }
        return available;
    }

    public TransportMedium findTransportByName(String name) {
        for (int i = 0; i < transports.size(); i++) {
            if (transports.get(i).getName().equalsIgnoreCase(name)) {
                return transports.get(i);
            }
        }
        return null;
    }

    public Route findRoute(String startPlace, String destinationPlace) throws RouteNotFoundException {
        for (int i = 0; i < routes.size(); i++) {
            Route r = routes.get(i);
            boolean startMatches = r.getStart().getPlace().equalsIgnoreCase(startPlace);
            boolean destinationMatches = r.getDestination().getPlace().equalsIgnoreCase(destinationPlace);
            if (startMatches && destinationMatches) {
                return r;
            }
        }
        throw new RouteNotFoundException("No direct route found from " + startPlace + " to " + destinationPlace + ".");
    }

    
    public ArrayList<ArrayList<Route>> findConnectingRoutes(String startPlace, String destinationPlace) {
        ArrayList<ArrayList<Route>> connections = new ArrayList<ArrayList<Route>>();

        for (int i = 0; i < routes.size(); i++) {
            Route firstLeg = routes.get(i);

            if (!firstLeg.getStart().getPlace().equalsIgnoreCase(startPlace)) {
                continue;
            }

            String middlePlace = firstLeg.getDestination().getPlace();

            for (int j = 0; j < routes.size(); j++) {
                Route secondLeg = routes.get(j);

                boolean secondLegStartsAtMiddle = secondLeg.getStart().getPlace().equalsIgnoreCase(middlePlace);
                boolean secondLegEndsAtDestination = secondLeg.getDestination().getPlace().equalsIgnoreCase(destinationPlace);

                if (secondLegStartsAtMiddle && secondLegEndsAtDestination) {
                    ArrayList<Route> connection = new ArrayList<Route>();
                    connection.add(firstLeg);
                    connection.add(secondLeg);
                    connections.add(connection);
                }
            }
        }

        return connections;
    }

    public void generateReport() {
        System.out.println();
        System.out.println("========== SYSTEM REPORT ==========");
        System.out.println("Total transports : " + transports.size());
        System.out.println("Total routes     : " + routes.size());
        System.out.println();

        System.out.println("-- Transport Details --");
        if (transports.size() == 0) {
            System.out.println("No transports registered.");
        } else {
            for (int i = 0; i < transports.size(); i++) {
                TransportMedium t = transports.get(i);
                System.out.println((i + 1) + ". " + t.getName()
                        + " | Route: " + t.getRouteName()
                        + " | Fare (5km): P" + t.calculateFare(5)
                        + " | Fare (10km): P" + t.calculateFare(10)
                        + " | Available: " + (t.isAvailable() ? "Yes" : "No"));
            }
        }

        System.out.println();
        System.out.println("-- Route Details --");
        if (routes.size() == 0) {
            System.out.println("No routes registered.");
        } else {
            for (int i = 0; i < routes.size(); i++) {
                Route r = routes.get(i);
                System.out.println((i + 1) + ". " + r.getRouteName()
                        + " | From: " + r.getStart().getPlace()
                        + " | To: " + r.getDestination().getPlace()
                        + " | Distance: " + r.getDistance() + "km"
                        + " | Direct: " + (r.isDirectRoute() ? "Yes" : "No"));
            }
        }
        System.out.println("====================================");
        System.out.println();
    }
}
