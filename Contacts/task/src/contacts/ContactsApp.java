package contacts;

import java.awt.*;

public class ContactsApp {
    public void run() {
        ContactsList contactsList = new ContactsList();
        boolean exit = false;
        while(!exit) {
            System.out.print("Enter action (add, remove, edit, count, list, exit): ");
            switch (Main.getInput().toUpperCase()) {
                case "ADD":
                    contactsList.addContact();
                    break;
                case "REMOVE":
                    contactsList.removeContact();
                    break;
                case "EDIT":
                    contactsList.editContact();
                    break;
                case "COUNT":
                    contactsList.countContacts();
                    break;
                case "LIST":
                    contactsList.listContacts();
                    break;
                case "EXIT":
                    exit = true;
                    break;
                default:
                    System.out.println("Incorrect action. Please try again");
            }
        }
    }
}
