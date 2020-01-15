package app;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("+48 625 458 789");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printMenu();
        while (quit) {
            System.out.println("\n Enter action: --- (6) to show available action ---");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                System.out.println("\nShutting down...");
                quit = true;
                break;

                case 1:
                printContacts();
                break;
            }

        }
    }

    private static void printContacts() {
        mobilePhone.printContacts();
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printMenu() {
        System.out.println("\n Available actions: \npress");
        System.out.print("0 - to shutdown\n" + 
                         "1 - to print contacts\n" + 
                         "2 - to add a new contact" + 
                         "3 - to update existing contact" +
                         "4 - to remove an existing contact\n" +
                         "5 - query if an existing contact exist\n" +
                         "6 - to print a list of available actions.");
        System.out.println("Choose your action: ");                         
    }


}