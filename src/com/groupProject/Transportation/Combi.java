package com.groupProject.Transportation;

public class Combi extends TransportMedium {

    public Combi(String name){
        super(name);
    }

    @Override
    public void move(){
        System.out.println("The COMBI "+name+"is in route");
    }
    
}
