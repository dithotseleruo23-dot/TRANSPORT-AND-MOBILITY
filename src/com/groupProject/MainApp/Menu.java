package com.groupProject.MainApp;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import com.groupProject.Services.TransportSystem;
import com.groupProject.Transportation.TransportMedium;
import com.groupProject.Transportation.Combi;
import com.groupProject.Transportation.Taxi;
import com.groupProject.Travel.Location;
import com.groupProject.Travel.Route;

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

            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.next();

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
        System.out.print("Enter your current location: ");
        String start = scanner.nextLine();

        System.out.print("Enter your destination: ");
        String end = scanner.nextLine();

        if (start.equals("") || end.equals("")) {
            System.out.println("Error: Location and destination cannot be empty.");
            return;
        }

        
        
        System.out.println();
        System.out.println("Choose your transport:");
        System.out.println("1. Combi (P9 flat fare)");
        System.out.println("2. Taxi  (P10 short / P40 long distance)");


        System.out.println("Your Vehicle type choice: ");
        int vehicleChoice = scanner.nextInt();
        scanner.next();

        double distance = getDoubleInput("Enter estimated distance in km: ");

        
        TransportMedium selected;

        if (vehicleChoice == 1) {
            selected = new Combi("Combi", start + " to " + end);
        } else if (vehicleChoice == 2) {
            boolean isSpecial = distance > 6.0;
            selected = new Taxi("Taxi", start + " to " + end, isSpecial);
        } else {
            System.out.println("Invalid transport choice.");
            return;
        }

        double fare = selected.calculateFare(distance);
        System.out.println();
        System.out.println("Route    : " + start + " to " + end);
        System.out.println("Distance : " + distance + " km");
        System.out.println("Fare     : P" + fare);

        if (distance > 6.0 && vehicleChoice == 2) {
            System.out.println("Note     : Long distance fare applied (over 6 km)");
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
        system.addTransport(c1);
        system.addTransport(c2);
        system.addTransport(c3);

        
        Taxi t1 = new Taxi("Taxi-01", "Phakalane - Station", true);
        Taxi t2 = new Taxi("Taxi-02", "Gaborone CBD - Main Mall", false);
        system.addTransport(t1);
        system.addTransport(t2);

        Location station = new Location("Station");
        Location mainMall = new Location("Main Mall");
        Location broadhurst = new Location("Broadhurst");
        Location phakalane = new Location("Phakalane");
        Location mogoditshane = new Location("Mogoditshane");

        Route r1 = new Route(station, "Station - Main Mall", c1, mainMall);
        Route r2 = new Route(mainMall, "Main Mall - Broadhurst", c2, broadhurst);
        Route r3 = new Route(phakalane, "Phakalane - Station", t1, station);
        Route r4 = new Route(station, "Gaborone - Mogoditshane", c3, mogoditshane);
        system.addRoute(r1);
        system.addRoute(r2);
        system.addRoute(r3);
        system.addRoute(r4);
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
