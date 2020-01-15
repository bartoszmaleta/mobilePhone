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
                // or just:
                // mobilePhone.printContacts();
                // and can delete mehtod printContacts();
                break;

            case 2:
                addNewContact();
                break;

            case 3:
                updateContact();
                break;

            case 4:
                removeContact();
                break;

            case 5:
                queryContact();
                break;

            case 6:
                printMenu();
            }

        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newPhoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newPhoneNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record.");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        
        if (mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("Successfully removed record");
        } else {
            System.out.println("Error removed record.");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        
        System.out.println("Name: " + existingContactRecord.getName() + " phone number is " + existingContactRecord.getPhoneNumber());
    }


    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phoneNumber);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added:");
            System.out.println("name = " + name);
            System.out.println("phoneNumber = " + phoneNumber);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
        // the reason i can do that is because createContact() is a static method
        // or factory method
    }

    private static void printContacts() {
        mobilePhone.printContacts();
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printMenu() {
        System.out.println("\n Available actions: \npress");
        System.out.print("0 - to shutdown\n" + "1 - to print contacts\n" + "2 - to add a new contact"
                + "3 - to update existing contact" + "4 - to remove an existing contact\n"
                + "5 - query if an existing contact exist\n" + "6 - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }

}