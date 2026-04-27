package transport;

public class Taxi extends Vehicle {
    private boolean isSpecial;

    public Taxi(String routeName, boolean isSpecial) {
        //Special trips are usually P30-P40, shared is P10
        super(routeName, isSpecial ? 30.00 : 10.00);
        this.isSpecial = isSpecial;
    }

    @Override
    public double calculateFare(int numTrips) {
        return baseFare * numTrips;
    }

    public void displayTaxiType() {
        String type = isSpecial ? "Special" : "Shared";
        System.out.println("Taxi Service: " + type + " | Fare: P" + baseFare);
    }
}
