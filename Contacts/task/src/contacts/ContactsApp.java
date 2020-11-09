package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsApp {
    List<Contact> contacts = new ArrayList<>();
    public void run() {
        contacts.add(addContact());
        System.out.println("A record created!");
        System.out.println("A Phone Book with a single record created!");
    }

    private Contact addContact() {
        System.out.println("Enter the name of the person: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Enter the surname of the person: ");
        String surname = sc.nextLine();
        System.out.println("Enter the number: ");
        String number = sc.nextLine();
        return new Contact(name, surname, number);
    }
}
