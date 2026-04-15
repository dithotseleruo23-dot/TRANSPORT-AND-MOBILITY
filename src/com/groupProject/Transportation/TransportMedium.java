package com.groupProject.Transportation;

public abstract class TransportMedium {
    protected String name;

    public TransportMedium(String name){
        this.name = name;
    }

    public abstract void move();
    
}
