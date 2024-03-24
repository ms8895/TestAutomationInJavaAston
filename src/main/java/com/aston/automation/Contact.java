package com.aston.automation;

import java.util.Collections;
import java.util.List;

public class Contact implements Comparable<Contact> {
    private String lastName;
    private int number;

    public Contact(String lastName, int number) {
        this.lastName = lastName;
        this.number = number;
    }

    String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Контакт: " + lastName + ". Телефон: " + number;
    }


    @Override
    public int compareTo(Contact o) {
        return lastName.compareTo(o.getLastName());
    }

    private static void sort(List<Contact> contacts) {
        Collections.sort(contacts);
    }

    protected static void getContact(List<Contact> contacts, String lastName) {
        sort(contacts);
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getLastName().equals(lastName)) {
                System.out.println(contacts.get(i));
            }
        }
    }
}
