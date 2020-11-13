package contacts;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ContactsApp app = new ContactsApp();
        app.run();
    }
    public static String getInput() {
        return sc.nextLine();
    }
}
