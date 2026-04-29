# TRANSPORT-AND-MOBILITY- CSI142

# GROUP MEMBERS

1. Zandile Thamage 202501399

2. Leruo Dithotse 202503473

3. Phineas Mokalane 202504984

4. Elsie Maswere 202503713

5. Barati Moapare 202505148


# Taxi/Combi Route Assistant System.

Description:

This project is a Java console application that helps users find their way using combis in Gaborone. The user enters where they are and where they want to go, and the system suggests which routes they can take and how many trips it will take to get there. In Gaborone, combis follow specific routes, but it’s not always clear which one to take, especially if you are going somewhere new. Sometimes you also need to change combis along the way. This system is meant to make that easier by giving simple directions based on the user’s input. The Taxi & Combi Route Assistant System is a simple transport navigation application designed to help users find the best available routes between locations using either taxis or combis. It provides route availability, number of trips required, and estimated fare based on the selected mode of transport.


# System Operation

1. App Launch

When the user opens the application, they are prompted with the option to "Find Route".

2. Choose Transport Type

The user must select one of the following transportation options:

• Taxi

• Combi

This choice determines how routes and fares will be calculated.

3. Enter Trip Details

After selecting a transport type, the user is required to input:

• Current Location

• Destination

4. Route Processing

The system analyzes the input and:

• Searches for available routes between the selected locations

• Determines whether a direct route exists or if multiple trips are required

• Displays all possible route options (if available)

If no routes are found, the system informs the user that the trip is not available.

5. Trip Details Output

For available routes, the system provides:

• The route(s) to follow

• The number of trips required to reach the destination

• The total estimated fare

Fare Calculation Rules

Combi Fare

• Standard fare: P9 per trip

 Taxi Fare

• Standard fare: P10 per trip

• If the distance exceeds 6 km, a special taxi fare is applied (higher than the standard rate)

# Project features:

- Enter current location
- Enter destination
- Shows available routes
- Shows how many trips are needed
- Basic route guidance
- Calculates fairs

# Technologies used:

1.Java Programming Language 

2.Object-Oriented Programming (OOP)

# Concepts Implemented:

- Classes and Objects
- Inheritance
- Encapsulation
- Abstraction
- Collections (ArrayList)
  
# How to Run:

Compile the program: javac Main.java

Run the program: java Main

# Package Structure:

app → main application(Main app) and user interaction(Menu)

transport → classes like Location, Route, Combi, Trip, Transport 

services → Logic like calculating fairs, avaliable routes, how many trips required

# Progress 

# (Milestone 1)
- Repository created
- Written Concept note

# (Milestone 2)
- Package Structure created
- Core classes have been added
- Menu loop Implemented

# (Milestone 3)
