package com.groupProject.Transportation;

public abstract class TransportMedium {
    protected String name;
    protected String routeName;
    protected double baseFare;

    public TransportMedium(String name) {
        this.name = name;
    }

    // Every vehicle calculates fare differently
}
