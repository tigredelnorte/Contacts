package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactsList {
    static List<Contact> contacts;

    public ContactsList () {
        this.contacts = new ArrayList<>();
    }
    void addContact() {
        System.out.print("Enter the name of the person: ");
        String name = Main.getInput();
        System.out.print("Enter the surname of the person: ");
        String surname = Main.getInput();
        System.out.print("Enter the number: ");
        String number = Main.getInput();
        if (!isNumberCorrect(number)) {
            System.out.println("Wrong number format!");
            number = "[no number]";
        }
        contacts.add(new Contact(name, surname, number));
        System.out.println("The record added.");
    }

    void editContact() {
        if (contacts.size() == 0) {
            System.out.println("No records to edit!");
        } else {
            listContacts();
            System.out.print("Select a record: ");
            int recordSelected = Integer.parseInt(Main.getInput())-1;
            if (recordSelected > contacts.size() - 1 || recordSelected < 0) {
                System.out.println("Incorrect input");
            } else {
                System.out.print("Select a field (name, surname, number): ");
                switch (Main.getInput().toUpperCase()) {
                    case "NAME":
                        System.out.print("Enter name: ");
                        contacts.get(recordSelected).setName(Main.getInput());
                        break;
                    case "SURNAME":
                        System.out.print("Enter surname: ");
                        contacts.get(recordSelected).setSurname(Main.getInput());
                        break;
                    case "NUMBER":
                        System.out.print("Enter number: ");
                        String tempNumber = Main.getInput();
                        if (!isNumberCorrect(tempNumber)) {
                            tempNumber = "[no number]";
                            System.out.println("Wrong number format!");
                        }
                        contacts.get(recordSelected).setPhoneNumber(tempNumber);
                        break;
                    default:
                        System.out.println("Incorrect option selected");
                }
                System.out.println("The record updated!");
            }
        }
    }

    void countContacts() {
        System.out.println("The Phone Book has " + contacts.size() + " records");
    }

    private boolean isNumberCorrect(String number) {
        String regex = "[+]?(\\(?\\w+\\)?[- ]\\w{2,}|" +
                "\\w+[- ]\\(?\\w{2,}\\)?|" +
                "\\(?\\w*\\)?)" +
                "([- ]\\w{2,})*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    void listContacts() {
        if (contacts.size() == 0) {
            System.out.println("Contacts list is empty.");
        } else {
            int countList = 1;
            for (Contact contact : contacts){
                System.out.println(countList++ + ". " + contact.toString());
            }
        }
    }

    void removeContact() {
        if (contacts.size() == 0) {
            System.out.println("No records to remove!");
        } else {
            listContacts();
            System.out.println("Select a record: ");
            try {
                contacts.remove(Integer.parseInt(Main.getInput())-1);
                System.out.println("The record removed!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Incorrect input.");
            }
        }
    }
}
