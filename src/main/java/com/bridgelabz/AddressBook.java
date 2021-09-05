package com.bridgelabz;

import java.util.Scanner;

/**
 * Purpose - To develop an address book system using collection lib
 */
public class AddressBook {

    public static void main(String[] args) {
        System.out.println("Welcome to address book problem statement");

        Scanner scanner = new Scanner(System.in);
        ContactCreation contactCreation = new ContactCreation();
        contactCreation.addContact(scanner);
        contactCreation.editPerson(scanner);
        contactCreation.deleteContact();
    }
}