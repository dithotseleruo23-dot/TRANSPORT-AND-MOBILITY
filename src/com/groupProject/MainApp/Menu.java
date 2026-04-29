package com.groupProject.MainApp;
import java.util.Scanner;

import com.groupProject.Services.CombiFare;
import com.groupProject.Services.TaxiFare;

public class Menu {
    private double COMBI_RATE = 9.0;
    private double TAXI_BASE_RATE = 10.0;
    private double TAXI_SPECIAL_RATE = 40.0;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        /**System.out.println("Taxi Price: P10");
        System.out.println("Special Taxi Price(LONG DISTANCES): P40");
        System.out.println("Combi Price: P9");**/


        while(true){
            System.out.println("=== COMBI ROUTE SYSTEM ===");
            System.out.println("1. Find route");
            System.out.println("2. Exit");

            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1){
                System.out.println("Enter starting location: ");
                String start = scanner.nextLine();
                System.out.println("Enter Destination: ");
                String end =  scanner.nextLine();
                System.out.println("Finding ROUTE...");

                /*FINDING ROUTE CODE AND FARE CALCULATION*/

                System.out.println("1. Go with Combi");
                System.out.println("2. Go with Taxi");
                int vehicleChoice = scanner.nextInt();
                scanner.nextLine();

                if (vehicleChoice == 1){
                    CombiFare c1 = new CombiFare(9);
                    System.out.println("Your Combi Fare is P"+c1.calculateFare(9));
                }else if(vehicleChoice == 2){
                    TaxiFare t1 = new TaxiFare(10, 50, 6);
                    System.out.println("Your Taxi Fare is P"+t1.calculateFare(2) );
                }

                

            }else if(choice == 2){
                System.out.println("EXITING SYSTEM...");
                break;
            }else{
                System.out.println("INVALID OPTION!!");
            }
        }
    }
    
}
