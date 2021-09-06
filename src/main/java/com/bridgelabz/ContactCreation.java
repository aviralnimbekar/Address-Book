package com.bridgelabz;

import java.util.LinkedList;
import java.util.Scanner;

public class ContactCreation {

    public int searchName(Scanner scanner, LinkedList<ContactInfo> contactList) {
        try {
            String searchName = scanner.next();
            for (int index = 0; index < contactList.size(); index++) {
                if (contactList.get(index).getFirstName().equals(searchName))
                    return index;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    public LinkedList<ContactInfo> addContact(Scanner scanner, LinkedList<ContactInfo> contactList) {
        try {
            System.out.println("Enter following details \n" +
                    "First Name :");
            String firstName = scanner.next();
            System.out.println("Last Name :");
            String lastName = scanner.next();
            System.out.println("Address :");
            String address = scanner.next();
            System.out.println("City :");
            String city = scanner.next();
            System.out.println("State :");
            String state = scanner.next();
            System.out.println("Zip Code :");
            int zip = scanner.nextInt();
            System.out.println("Phone Number :");
            long phoneNo = scanner.nextLong();
            System.out.println("Email :");
            String email = scanner.next();

            ContactInfo contactInfo = new ContactInfo();

            contactInfo.setFirstName(firstName);
            contactInfo.setLastName(lastName);
            contactInfo.setAddress(address);
            contactInfo.setCity(city);
            contactInfo.setState(state);
            contactInfo.setZip(zip);
            contactInfo.setPhoneNo(phoneNo);
            contactInfo.setEmail(email);

            contactList.add(contactInfo);
        } catch (Exception e) {
            System.out.println(e);
        }
        return contactList;
    }

    public void displayContact(LinkedList<ContactInfo> contactList) {

        System.out.println("All contact =  " + contactList.size());
        System.out.println(contactList);
    }

    public void editContact(Scanner scanner, LinkedList<ContactInfo> contactList) {
        try {
            System.out.println("Enter a name you want to edit...");
            int editName = searchName(scanner, contactList);

            if (editName == -1)
                System.out.println("Name not found");
            else {
                ContactInfo contactInfo = contactList.get(editName);
                System.out.println(contactInfo);

                System.out.println("What do you want to edit \n" +
                        "1. First Name / 2. Last Name / 3. Address / 4. City / 5. State " +
                        "/ 6. Zip code / 7. Phone Number / 8. Email");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter new First Name");
                        String newFirstName = scanner.next();
                        contactInfo.setFirstName(newFirstName);
                        break;

                    case 2:
                        System.out.println("Enter new Last Name");
                        String newLastName = scanner.next();
                        contactInfo.setLastName(newLastName);
                        break;

                    case 3:
                        System.out.println("Enter new Address");
                        String newAddress = scanner.next();
                        contactInfo.setAddress(newAddress);
                        break;

                    case 4:
                        System.out.println("Enter new City");
                        String newCity = scanner.next();
                        contactInfo.setCity(newCity);
                        break;

                    case 5:
                        System.out.println("Enter new State");
                        String newState = scanner.next();
                        contactInfo.setState(newState);
                        break;

                    case 6:
                        System.out.println("Enter new Zip code");
                        int newZip = scanner.nextInt();
                        contactInfo.setZip(newZip);
                        break;

                    case 7:
                        System.out.println("Enter new Phone Number");
                        long newPhoneNo = scanner.nextLong();
                        contactInfo.setPhoneNo(newPhoneNo);
                        break;

                    case 8:
                        System.out.println("Enter new Email");
                        String newEmail = scanner.next();
                        contactInfo.setEmail(newEmail);
                        break;
                }
            }
            System.out.println("SUCCESSFUL");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteContact(Scanner scanner, LinkedList<ContactInfo> contactList) {
        try {
            System.out.println("Enter a name you want to delete...");
            int deleteName = searchName(scanner, contactList);

            if (deleteName == -1)
                System.out.println("Name not found");
            else {
                contactList.remove(deleteName);
                System.out.println("SUCCESSFUL");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}