package com.groupProject.Transportation;

public class Taxi extends TransportMedium {

    public Taxi(String name){
        super(name);
    }

    @Override
    public void move(){
        System.out.println("The TAXI "+name+ "is en route");
    }
    
}
