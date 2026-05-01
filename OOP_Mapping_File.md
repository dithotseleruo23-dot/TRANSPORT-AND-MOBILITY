# OOP Mapping Document
**CSI142 Object Oriented Programming — Semester II 2025/26**
Taxi/Combi Route Assistant System

---

## Introduction

This document maps each required OOP concept to where it actually shows up in our code. We did not try to force every concept into every class. We put each one where it made sense for the domain.

---

## 1. Classes and Objects
**Where: All packages**

We ended up with 8 classes: Menu, TransportMedium, Combi, Taxi, TransportSystem, RouteFinder, Location, and Route. Each one represents something real. Location is just a place name. Route knows where it starts, where it ends, how far it is, and which vehicle covers it. Combi and Taxi are the two options you would actually pick from if you were trying to get somewhere in Gaborone.

---

## 2. Encapsulation
**Where: TransportMedium.java, Location.java, Route.java**

Every field is private. Nothing gets read or changed directly. You go through getters and setters. The clearest example is setBaseFare in TransportMedium. It does not just set the value. If you pass in something negative it throws an InvalidFareException right there, inside the class, before anything gets stored.

---

## 3. Constructors and Constructor Overloading
**Where: TransportMedium.java, Combi.java, Taxi.java**

TransportMedium has two constructors. The first takes just a name. The second takes a name and a route, and calls the first one using this() so the setup code is not repeated. Combi and Taxi each do the same thing. Two constructors, one simple and one that takes more detail.

---

## 4. Methods and Modularity
**Where: Menu.java, TransportSystem.java**

The main method in Menu just runs the loop and calls other methods. findRoute(), viewAllRoutes(), viewTransportOptions() and generateReport() each handle exactly one thing. TransportSystem separates direct route lookup into findRoute() and multi-leg journey lookup into findConnectingRoutes(). Input reading lives in getIntInput() and getDoubleInput() so we are not writing the same try-catch block in five different places.

---

## 5. Composition
**Where: Route.java**

Route has a Location for the start of the journey, Location for the destination and a TransportMedium for the vehicle. It cannot exist without those three things. That is the composition. Route is built out of other objects, not just primitive values.

---

## 6. Inheritance
**Where: Combi.java, Taxi.java**

Combi and Taxi both extend TransportMedium. They pick up name, baseFare, isAvailable and the rest without having to redeclare any of it. The only thing they write themselves is calculateFare. Combi always returns P9. Taxi checks the distance. Under 6km is P10, over 6km is P40.

---

## 7. Abstraction - Abstract Class
**Where: TransportMedium.java**

TransportMedium is abstract so you cannot instantiate it directly. calculateFare is declared abstract inside it, which forces Combi and Taxi to each provide their own version. There is no point having a default fare calculation because a combi and a taxi work completely differently.

---

## 8. Abstraction - Interface
**Where: fareCalculator.java**

fareCalculator is an interface with one method: calculateFare(double distance). TransportMedium implements it, so Combi and Taxi both satisfy the contract through inheritance without having to explicitly say implements fareCalculator themselves.

---

## 9. Polymorphism
**Where: Menu.java, TransportSystem.java**

In findRoute(), the user picks combi or taxi but we store the result in a TransportMedium variable. When calculateFare gets called on it, Java works out at runtime which version to run. The same thing happens in generateReport() and in the connecting journey breakdown. We loop through a list of TransportMedium references and call calculateFare on each leg without knowing or caring whether it is a Combi or a Taxi underneath.

---

## 10. Collections
**Where: TransportSystem.java, Route.java, Menu.java**

TransportSystem keeps two ArrayLists, one for transports and one for routes. Route has its own ArrayList for stops along the way. findConnectingRoutes() returns an ArrayList of ArrayLists, where each inner list is the two legs of one connecting journey option. Menu loops through those when showing the user their choices.

---

## 11. Packages
**Where: All packages**

We split the project into five packages so related classes stay together and the folder is not just a pile of files.

| Package | What is in it |
|---------|---------------|
| com.groupProject.MainApp | Menu, the main entry point |
| com.groupProject.Transportation | TransportMedium, Combi, Taxi |
| com.groupProject.Services | fareCalculator, TransportSystem, RouteFinder |
| com.groupProject.Travel | Location, Route |
| com.groupProject.Exceptions | InvalidFareException, InvalidLocationException, RouteNotFoundException |

---

## 12. Robustness
**Where: Menu.java, TransportMedium.java, TransportSystem.java**

getIntInput() and getDoubleInput() both catch InputMismatchException and loop until the user gives a valid number. Empty location inputs throw InvalidLocationException. If the typed route does not exist in the system, findRoute() throws RouteNotFoundException and instead of just stopping there, Menu catches it and looks for connecting routes instead. If nothing connects either, it tells the user to check option 2. setBaseFare throws InvalidFareException for negative values. That is four different error cases handled, well above the two the brief asks for.
