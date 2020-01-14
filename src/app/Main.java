package app;

public class Main {
    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();

        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
            case 0:
                printInstructions();
                break;

            case 1:
                contacts.printListOfContacts();
                break;

            case 2:
                addContact();
                break;

            case 3:
                updateContact();
                break;

            case 4:
                removeContact();
                break;

            case 5:
                searchForItem();
                break;

            case 6:
                processArrayList();
                break;

            case 7:
                quit = true;
                break;
            }
        }
    }
}