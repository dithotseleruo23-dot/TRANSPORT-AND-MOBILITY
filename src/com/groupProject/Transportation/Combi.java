package com.groupProject.Transportation;

import com.groupProject.Services.fareCalculator;

public class Combi extends TransportMedium implements fareCalculator {


    public Combi(String name){
        super(name);
    }

    @Override
    public double calculateFare(double distance){
        return 9;
    }
}
    
}
