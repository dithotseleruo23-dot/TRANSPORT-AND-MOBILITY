package com.groupProject.Services;
import java.util.List;

import com.groupProject.Travel.Route;

import java.util.ArrayList;

public class System {
    private List<Route> routes = new ArrayList<>();

    public void addRoute(Route route){
        routes.add(route);
    }

    public List<Route> getRoutes(){
        return routes;
    }
    
}
