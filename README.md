# Taxi/Combi Route Assistant System
**CSI142 Object Oriented Programming — Semester II 2025/26**
University of Botswana, Department of Computer Science.

---

## Group Members

| # | Name | Student ID |
|---|------|------------|
| 1 | Zandile Thamage | 202501399 |
| 2 | Leruo Dithotse | 202503473 |
| 3 | Phineas Mokalane | 202504984 |
| 4 | Elsie Maswere | 202503713 |
| 5 | Barati Moapare | 202505148 |

---

## What This Project Does

If you have ever tried to get somewhere in Gaborone by combi and had no idea which one to take, this is for you. Routes are not posted anywhere. If you are going somewhere new you ask someone, guess, or end up on the wrong combi. And if your destination needs two combis, figuring out the fare gets even more confusing.

We built this to make that easier. You type where you are and where you want to go, pick combi or taxi, and the app works out the route and what it should cost. If you need more than one vehicle to get there, it tells you that too.

---

## How to Compile and Run

Make sure Java is installed. Open a terminal in the project folder and run:

```
javac -d out src/com/groupProject/Services/*.java src/com/groupProject/Transportation/*.java src/com/groupProject/Travel/*.java src/com/groupProject/MainApp/*.java src/com/groupProject/Exceptions/*.java
```

Then start the program with:

```
java -cp out com.groupProject.MainApp.Menu
```

When the app starts it already has some routes loaded so you can test things straight away without setting anything up first.

---

## Features

- Enter your current location and destination
- Choose combi or taxi
- Get the route between your two locations
- See the estimated fare based on distance
- Tells you if the trip needs more than one vehicle
- Handles bad input without crashing

---

## How Fares Work

**Combi:** P9 flat fare per trip, no matter the distance

**Taxi:** P10 for short trips (under 6 km), P40 for anything longer

---

## Package Structure

| Package | What is in it |
|---------|---------------|
| `com.groupProject.MainApp` | Menu.java — starts the app and handles all user interaction |
| `com.groupProject.Transportation` | TransportMedium (abstract class), Combi, Taxi |
| `com.groupProject.Services` | fareCalculator (interface), TransportSystem, RouteFinder, CombiFare, TaxiFare |
| `com.groupProject.Travel` | Location, Route |
| `com.groupProject.Exceptions` | InvalidFareException, InvalidLocationException, RouteNotFoundException |

---

## OOP Concepts Used

- Classes and Objects
- Inheritance
- Encapsulation
- Abstraction — interface and abstract class
- Polymorphism
- Collections (ArrayList)
- Constructor overloading and chaining
- Exception Handling

---

## Progress

**Milestone 1**
- Repository created
- Concept note written
- Group Members added

**Milestone 2**
- Package structure set up
- Core classes added
- Core OOP Concepts Implemented 
- Menu loop working

**Milestone 3**
- Abstract class and inheritance implemented
- fareCalculator interface added
- Fare calculation logic completed
- Input validation added
