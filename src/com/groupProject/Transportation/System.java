package com.groupProject.Transportation;
import java.util.List;
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
