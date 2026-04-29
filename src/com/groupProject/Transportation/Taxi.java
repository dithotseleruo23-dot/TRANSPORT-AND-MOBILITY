package com.groupProject.Transportation;

import com.groupProject.Services.fareCalculator;

public class Taxi extends TransportMedium implements fareCalculator {


    public Taxi(String name){
        super(name);
    }

    @Override
    public double calculateFare(double distance){
        return 9;
    }
}
