package com.groupProject.MainApp;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import com.groupProject.Services.*;
import com.groupProject.Transportation.TransportMedium;
import com.groupProject.Transportation.Combi;
import com.groupProject.Transportation.Taxi;
import com.groupProject.Travel.Location;
import com.groupProject.Travel.Route;
import com.groupProject.Exceptions.*;

public class Menu {

    static TransportSystem system = new TransportSystem();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        loadSeedData();

        System.out.println("==========================================");
        System.out.println("   Botswana Taxi/Combi Route Assistant   ");
        System.out.println("==========================================");

        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("========= MAIN MENU =========");
            System.out.println("1. Find a route and get fare");
            System.out.println("2. View all available routes");
            System.out.println("3. View transport options");
            System.out.println("4. Generate fare summary");
            System.out.println("5. Exit");
            System.out.println("==============================");

            int choice = getIntInput("Choose an option: ");

            if (choice == 1) {
                findRoute();
            } else if (choice == 2) {
                viewAllRoutes();
            } else if (choice == 3) {
                viewTransportOptions();
            } else if (choice == 4) {
                system.generateReport();
            } else if (choice == 5) {
                System.out.println("Exiting system BYE!!");
                running = false;
            } else {
                System.out.println("Invalid option. Please choose a number between 1 and 5.");
            }
        }

        scanner.close();
    }

    static void findRoute() {
        System.out.println();
        System.out.println("-- Find Route --");

        try {
            System.out.print("Enter your current location: ");
            String start = scanner.nextLine().trim();

            System.out.print("Enter your destination: ");
            String end = scanner.nextLine().trim();

            if (start.equals("")) {
                throw new InvalidLocationException("Starting location cannot be empty.");
            }
            if (end.equals("")) {
                throw new InvalidLocationException("Destination cannot be empty.");
            }

            try {
                Route route = system.findRoute(start, end);

                System.out.println();
                System.out.println("Direct route found!");
                System.out.println("Route    : " + route.getRouteName());
                System.out.println("From     : " + route.getStart().getPlace());
                System.out.println("To       : " + route.getDestination().getPlace());
                System.out.println("Distance : " + route.getDistance() + " km");

                System.out.println();
                System.out.println("Choose your transport:");
                System.out.println("1. Combi (P9 flat fare)");
                System.out.println("2. Taxi  (P10 short / P40 long distance)");

                int vehicleChoice = getIntInput("Your vehicle type choice: ");
                double distance = route.getDistance();

                TransportMedium selected;

                if (vehicleChoice == 1) {
                    selected = new Combi("Combi", route.getRouteName());
                } else if (vehicleChoice == 2) {
                    boolean isSpecial = distance > 6.0;
                    selected = new Taxi("Taxi", route.getRouteName(), isSpecial);
                } else {
                    System.out.println("Invalid transport choice.");
                    return;
                }

                double fare = selected.calculateFare(distance);
                System.out.println();
                System.out.println("Fare     : P" + fare);

                if (distance > 6.0 && vehicleChoice == 2) {
                    System.out.println("Note     : Long distance fare applied (over 6 km)");
                }

            } catch (RouteNotFoundException e) {

                System.out.println();
                System.out.println("No direct route found. Looking for connecting routes...");
                System.out.println();

                ArrayList<ArrayList<Route>> connections = system.findConnectingRoutes(start, end);

                if (connections.size() == 0) {
                    System.out.println("Sorry, no routes found from " + start + " to " + end + ".");
                    System.out.println("Try option 2 to see all available routes.");
                    return;
                }

                System.out.println("Connecting routes available:");
                System.out.println();
                for (int i = 0; i < connections.size(); i++) {
                    ArrayList<Route> legs = connections.get(i);
                    Route leg1 = legs.get(0);
                    Route leg2 = legs.get(1);
                    System.out.println("Option " + (i + 1) + ":");
                    System.out.println("  Leg 1: " + leg1.getStart().getPlace()
                            + " -> " + leg1.getDestination().getPlace()
                            + " (" + leg1.getVehicle().getName() + ", " + leg1.getDistance() + "km)");
                    System.out.println("  Leg 2: " + leg2.getStart().getPlace()
                            + " -> " + leg2.getDestination().getPlace()
                            + " (" + leg2.getVehicle().getName() + ", " + leg2.getDistance() + "km)");
                    System.out.println("  Connect at: " + leg1.getDestination().getPlace());
                    System.out.println();
                }

                int optionChoice = getIntInput("Choose a connecting route (1-" + connections.size() + "): ");

                if (optionChoice < 1 || optionChoice > connections.size()) {
                    System.out.println("Invalid choice.");
                    return;
                }

                ArrayList<Route> chosenLegs = connections.get(optionChoice - 1);

                System.out.println();
                System.out.println("Choose your transport:");
                System.out.println("1. Combi (P9 flat fare)");
                System.out.println("2. Taxi  (P10 short / P40 long distance)");

                int vehicleChoice = getIntInput("Your vehicle type choice: ");

                double totalFare = 0;
                System.out.println();
                System.out.println("-- Journey Breakdown --");

                for (int i = 0; i < chosenLegs.size(); i++) {
                    Route leg = chosenLegs.get(i);
                    double distance = leg.getDistance();

                    TransportMedium selected;

                    if (vehicleChoice == 1) {
                        selected = new Combi("Combi", leg.getRouteName());
                    } else if (vehicleChoice == 2) {
                        boolean isSpecial = distance > 6.0;
                        selected = new Taxi("Taxi", leg.getRouteName(), isSpecial);
                    } else {
                        System.out.println("Invalid transport choice.");
                        return;
                    }

                    double legFare = selected.calculateFare(distance);
                    totalFare += legFare;

                    System.out.println("Leg " + (i + 1) + ": "
                            + leg.getStart().getPlace()
                            + " -> " + leg.getDestination().getPlace()
                            + " | Distance: " + distance + "km"
                            + " | Fare: P" + legFare);
                }

                System.out.println();
                System.out.println("Total Fare : P" + totalFare);
                System.out.println("Connections: " + chosenLegs.size() + " leg(s)");
            }

        } catch (InvalidLocationException e) {
            System.out.println("Location error: " + e.getMessage());
        }
    }

    static void viewAllRoutes() {
        System.out.println();
        System.out.println("-- Available Routes --");

        ArrayList<Route> routes = system.getRoutes();

        if (routes.size() == 0) {
            System.out.println("No routes registered yet.");
            return;
        }

        for (int i = 0; i < routes.size(); i++) {
            Route r = routes.get(i);
            System.out.println((i + 1) + ". " + r.getRouteName()
                    + " | From: " + r.getStart().getPlace()
                    + " | To: " + r.getDestination().getPlace()
                    + " | Distance: " + r.getDistance() + "km"
                    + " | Vehicle: " + r.getVehicle().getName()
                    + " | Direct: " + (r.isDirectRoute() ? "Yes" : "No"));
        }
    }

    static void viewTransportOptions() {
        System.out.println();
        System.out.println("-- Transport Options --");

        ArrayList<TransportMedium> all = system.getTransports();

        if (all.size() == 0) {
            System.out.println("No transports registered yet.");
            return;
        }

        for (int i = 0; i < all.size(); i++) {
            TransportMedium t = all.get(i);
            System.out.println((i + 1) + ". " + t.getName()
                    + " | Route: " + t.getRouteName()
                    + " | Fare: P" + t.getBaseFare()
                    + " | Available: " + (t.isAvailable() ? "Yes" : "No"));
        }
    }

    static void loadSeedData() {
        Combi c1 = new Combi("Combi-01", "Station - Main Mall");
        Combi c2 = new Combi("Combi-02", "Main Mall - Broadhurst");
        Combi c3 = new Combi("Combi-03", "Gaborone - Mogoditshane");
        Combi c4 = new Combi("Combi-04", "Main Mall - Station");
        Combi c5 = new Combi("Combi-05", "Broadhurst - Main Mall");
        Combi c6 = new Combi("Combi-06", "Mogoditshane - Gaborone");
        system.addTransport(c1);
        system.addTransport(c2);
        system.addTransport(c3);
        system.addTransport(c4);
        system.addTransport(c5);
        system.addTransport(c6);



    

        Taxi t1 = new Taxi("Taxi-01", "Phakalane - Station", true);
        Taxi t2 = new Taxi("Taxi-02", "Gaborone CBD - Main Mall", false);
        Taxi t3 = new Taxi("Taxi-03", "Station - Phakalane", true);
        Taxi t4 = new Taxi("Taxi-04", "Main Mall - Gaborone CBD", false);
        system.addTransport(t1);
        system.addTransport(t2);
        system.addTransport(t3);
        system.addTransport(t4);

        Location station = new Location("Station");
        Location mainMall = new Location("Main Mall");
        Location broadhurst = new Location("Broadhurst");
        Location phakalane = new Location("Phakalane");
        Location mogoditshane = new Location("Mogoditshane");

        Route r1 = new Route(station, "Station - Main Mall", c1, mainMall, 3.5);
        Route r2 = new Route(mainMall, "Main Mall - Broadhurst", c2, broadhurst, 4.2);
        Route r3 = new Route(phakalane, "Phakalane - Station", t1, station, 12.0);
        Route r4 = new Route(station, "Station - Mogoditshane", c3, mogoditshane, 15.0);
        Route r5 = new Route(mainMall, "Main Mall - Station", c4, station, 3.5);
        Route r6 = new Route(broadhurst, "Broadhurst - Main Mall", c5, mainMall, 4.2);
        Route r7 = new Route(station, "Station - Phakalane", t3, phakalane, 12.0);
        Route r8 = new Route(mogoditshane, "Mogoditshane - Gaborone", c6, station, 15.0);
        system.addRoute(r1);
        system.addRoute(r2);
        system.addRoute(r3);
        system.addRoute(r4);
        system.addRoute(r5);
        system.addRoute(r6);
        system.addRoute(r7);
        system.addRoute(r8);
    }

    static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a number e.g. 5.5");
            }
        }
    }
}
