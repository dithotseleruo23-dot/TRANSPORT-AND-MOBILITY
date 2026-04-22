# TRANSPORT-AND-MOBILITY
CSI142
Taxi route assistant system.

Description:

This project is a Java console application that helps users find their way using combis in Botswana. The user enters where they are and where they want to go, and the system suggests which routes they can take and how many trips it will take to get there. In Botswana, combis follow specific routes, but it’s not always clear which one to take, especially if you are going somewhere new. Sometimes you also need to change combis along the way. This system is meant to make that easier by giving simple directions based on the user’s input.

Project features:

- Enter current location
- Enter destination
- Shows available routes
- Shows how many trips are needed
- Indicates if trips are mixed (requires both taxi & combi to arrive at destination).
- Basic route guidance
- Simplifies and shows shortest routes needed to arrive at destination.
- Calculates fairs

Technologies used:

1.Java Programming Language 

2.Object-Oriented Programming (OOP)

Concepts Implemented:

- Classes and Objects
- Inheritance
- Polymorphism
- Encapsulation
- Abstraction
- Collections (ArrayList)
  
How to Run:

Compile the program: javac Main.java

Run the program: java Main

Package Structure:

app- main application

UI- (user interface) and menu

travel- classes like Location, Route, Trip

transport- classes like Transport and Combi

services- Logic like calculating fairs, avaliable routes, how many trips required
