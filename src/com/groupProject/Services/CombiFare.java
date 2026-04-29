package com.groupProject.Services;

public class CombiFare implements farecalculator {
    private double combiPrice;

    public CombiFare(double combiPrice){
        this.combiPrice = combiPrice;
    }

    @Override
    public double calculateFare(double distance){
        return combiPrice;
    }
    
}
