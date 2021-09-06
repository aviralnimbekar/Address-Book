package com.bridgelabz;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class ContactCreation {
    Scanner scanner = new Scanner(System.in);

    public void optionToCreateBook() {
        try {
            HashMap<String, LinkedList<ContactInfo>> contactBook = new HashMap<>();

            while (true) {
                System.out.println("\nWhat would you like to do? \n" +
                        "1. Crate new address book \n" +
                        "2. Continue with existing address book \n" +
                        "3. All books \n" +
                        "0. EXIT");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter name for Address book");
                        String newBook = scanner.next();
                        LinkedList<ContactInfo> contactList = new LinkedList<>();

                        if (contactBook.containsKey(newBook))
                            System.out.println("Book already exists");
                        else
                            optionToCreateContact(contactList, contactBook, newBook);
                        break;

                    case 2:
                        System.out.println(contactBook.keySet());
                        System.out.println("Which address book do you want to access?");
                        String existingBook = scanner.next();

                        if (contactBook.containsKey(existingBook)) {
                            contactList = contactBook.get(existingBook);
                            optionToCreateContact(contactList, contactBook, existingBook);
                        } else
                            System.out.println("Book not found");
                        break;

                    case 3:
                        int serialNo = 1;
                        for (String book : contactBook.keySet()) {
                            System.out.println(serialNo + ". " + book);
                            serialNo++;
                        }

                        System.out.println("\n" + contactBook);
                        break;

                    default:
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void optionToCreateContact(LinkedList<ContactInfo> contactList,
                                       HashMap<String, LinkedList<ContactInfo>> contactBook, String addressBook) {
        try {
            boolean run = true;
            while (run) {
                System.out.println("\nWhat would u like to do with contacts? \n" +
                        "1. ADD     \n" +
                        "2. DISPLAY \n" +
                        "3. EDIT    \n" +
                        "4. REMOVE  \n" +
                        "0. EXIT    \n");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        LinkedList<ContactInfo> multiContactInBook = addContact(contactList);
                        contactBook.put(addressBook, multiContactInBook);
                        break;
                    case 2:
                        displayContact(contactList);
                        break;
                    case 3:
                        editContact(contactList);
                        break;
                    case 4:
                        deleteContact(contactList);
                        break;
                    default:
                        run = false;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(e);
        }
    }

    private int searchName(String searchName, LinkedList<ContactInfo> contactList) {
        try {
            for (int index = 0; index < contactList.size(); index++) {
                if (contactList.get(index).getFirstName().equals(searchName))
                    return index;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    private LinkedList<ContactInfo> addContact(LinkedList<ContactInfo> contactList) {
        try {
            System.out.println("Enter following details \n" +
                    "First Name :");
            String firstName = scanner.next();

            int existingName = searchName(firstName, contactList);
            if (existingName == -1) {
                ContactInfo contactInfo = new ContactInfo();

                contactInfo.setFirstName(firstName);

                System.out.println("Last Name :");
                String lastName = scanner.next();
                contactInfo.setLastName(lastName);

                System.out.println("Address :");
                String address = scanner.next();
                contactInfo.setAddress(address);

                System.out.println("City :");
                String city = scanner.next();
                contactInfo.setCity(city);

                System.out.println("State :");
                String state = scanner.next();
                contactInfo.setState(state);

                System.out.println("Zip Code :");
                int zip = scanner.nextInt();
                contactInfo.setZip(zip);

                System.out.println("Phone Number :");
                long phoneNo = scanner.nextLong();
                contactInfo.setPhoneNo(phoneNo);

                System.out.println("Email :");
                String email = scanner.next();
                contactInfo.setEmail(email);

                contactList.add(contactInfo);

            } else
                System.out.println("Name already exists");

        } catch (InputMismatchException e) {
            System.out.println("Please provide correct data");
        }
        return contactList;
    }

    private void displayContact(LinkedList<ContactInfo> contactList) {
        try {
            System.out.println("All contact =  " + contactList.size());
            System.out.println(contactList);
        } catch (Exception e) {
            System.out.println("List is Empty");
        }
    }

    private void editContact(LinkedList<ContactInfo> contactList) {
        try {
            System.out.println("Enter a name you want to edit...");
            String searchName = scanner.next();
            int editName = searchName(searchName, contactList);

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
                System.out.println("SUCCESSFUL");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void deleteContact(LinkedList<ContactInfo> contactList) {
        try {
            System.out.println("Enter a name you want to delete...");
            String searchName = scanner.next();
            int deleteName = searchName(searchName, contactList);

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