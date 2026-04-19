package com.groupProject.Services;

public class TaxiFare implements fareCalculator {
    private double TaxiFare;
    private double specialPrice;
    private double longDistance;

    public TaxiFare(double TaxiFare, double specialPrice, double longDistance){
        this.TaxiFare = TaxiFare;
        this.specialPrice = specialPrice;
        this.longDistance = longDistance;
    }

    @Override
    public double calculateFare(double distance){
        if(distance > longDistance){
            return specialPrice;
        }else{
            return TaxiFare;
        }
    }
    
}
