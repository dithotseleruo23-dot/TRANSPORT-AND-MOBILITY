package com.groupProject.Services;

public class TaxiFare implements fareCalculator {
    private double TaxiFare = 10.00;
    private double specialPrice = 50.00;
    private double distanceTreshold = 6.0; //km

    public TaxiFare(double TaxiFare, double specialPrice, double distanceThreshold){
        this.TaxiFare = TaxiFare;
        this.specialPrice = specialPrice;
        this.distanceThreshold = distanceThreshold;
    }

    @Override
    public double calculateFare(double distance){
        if(distance > distanceThreshold){
            return specialPrice;
        }else{
            return TaxiFare;
        }
    }
    
}
