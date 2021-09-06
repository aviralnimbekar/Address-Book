package com.bridgelabz;

import java.util.LinkedList;
import java.util.Scanner;

public class AddressBook {

    public static void main(String[] args) {
        System.out.println("Welcome to address book problem statement");

        Scanner scanner = new Scanner(System.in);
        LinkedList<ContactInfo> contactList = new LinkedList<>();
        ContactCreation contactCreation = new ContactCreation();
        while (true) {
            System.out.println("\nWhat would u like to do with contacts? \n" +
                    "1. ADD     \n" +
                    "2. DISPLAY \n" +
                    "3. EDIT    \n" +
                    "4. REMOVE  \n" +
                    "0. EXIT    \n");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    contactCreation.addContact(scanner, contactList);
                    break;
                case 2:
                    contactCreation.displayContact(contactList);
                    break;
                case 3:
                    contactCreation.editContact(scanner, contactList);
                    break;
                case 4:
                    contactCreation.deleteContact(scanner, contactList);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
}