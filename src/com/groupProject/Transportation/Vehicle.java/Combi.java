package transport;

public class Combi extends Vehicle {
    
    public Combi(String routeName) {
        // Current standard combi fare in Botswana is around P8.00
        super(routeName, 8.00); 
    }

    @Override
    public double calculateFare(int numTrips) {
        return baseFare * numTrips;
    }
    
    public void displayInfo() {
        System.out.println("Combi Route: " + routeName + " | Fare per trip: P" + baseFare);
    }

}

