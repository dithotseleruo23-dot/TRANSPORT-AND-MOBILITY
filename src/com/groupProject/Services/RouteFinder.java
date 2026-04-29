package com.groupProject.Services;

public class RouteFinder {

    public void findRoute(String begin, String end){
        System.out.println("--Searching for best ROUTE--");
        System.out.println("FROM: "+ begin);
        System.out.println("TO:"+ end );

        System.out.println("ROUTE IS: " +begin+"--------->"+end);
    }
    
    
}
public class RouteFinder {
    public static void main(String[] args) {
        // Scenario: Point A (Station) to Point C (Broadhurst) via Point B (Main Mall)
        // User needs two combis
        
        Route myTrip = new Route();
  // Trip 1: Station to Main Mall (Combi)

        myTrip.addTrip(new RouteTrip("Station", "Main Mall", new Combi()));
        
        // Trip 2: Main Mall to Broadhurst (Combi)

        myTrip.addTrip(new RouteTrip("Main Mall", "Broadhurst", new Combi()));
        
        myTrip.displayRoute(); 
System.out.println(“Total Fare: “ + getFare);
// Output: P18
        
        // Scenario 2: Taxi + Combi
        Route mixedTrip = new Route();
        mixedTrip.addTrip(new RouteTrip("Phakalane", "Station", new Taxi()));
        mixedTrip.addTrip(new RouteTrip("Station", "Phase 4", new Combi()));
        
        mixedTrip.displayRoute(); 
System.out.println(“Total Fare: “ + getFare);
// Output: P19
    }
}