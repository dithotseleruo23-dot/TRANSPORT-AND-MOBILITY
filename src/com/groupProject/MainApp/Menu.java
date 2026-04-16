package com.groupProject.MainApp;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("=== COMBI ROUTE SYSTEM ===");
            System.out.println("1. Find route");
            System.out.println("2. View routes");
            System.out.println("3. Exit");

            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1){
                System.out.println("Enter starting location: ");
                String start = scanner.nextLine();
                System.out.println("Enter Destination: ");
                String end =  scanner.nextLine();
                System.out.println("Finding ROUTE...");
                System.out.println("11knfjbjbjhbjbj");
                /*FINDING ROUTE CODE */




            }else if(choice == 2){
                System.out.println("--- ROUTES ---");
                /*GETTING ROUTES AND DISPLAYING THEM CODE */



            }else if(choice == 3){
                System.out.println("EXITING SYSTEM...");
                break;
            }else{
                System.out.println("INVALID OPTION!!");
            }
        }
    }
    
}
