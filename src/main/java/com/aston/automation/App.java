package com.aston.automation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        // 1.
        System.out.println("1.");
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(
                "apple", "banana", "cat", "dog", "elephant",
                "fish", "grape", "horse", "orange", "pear",
                "pineapple", "rabbit", "apple", "cat", "dog",
                "elephant", "fish", "grape", "horse", "orange"));

        // Вывод уникальных строк.
        Collections.sort(arrayList);
        List<String> listWithoutDuplicates = arrayList.stream().distinct().collect(Collectors.toList());
        System.out.println(listWithoutDuplicates);

        // Подсчет строк.
        Collections.sort(arrayList);
        ArrayList<String> arrayFree = new ArrayList<>();

        System.out.println();

        for (String item : arrayList) {
            int occurrences = Collections.frequency(arrayList, item); // Узнаём количество "яблок"
            if (!arrayFree.contains(item)) {
                System.out.println("В списке: " + item + " = " + occurrences);
                arrayFree.add(item);
            }
        }

        // 2.
        System.out.println("\n" + "2.");

        List<Contact> contacts = new ArrayList<>(Arrays.asList(
                new Contact("Иванов", 111),
                new Contact("Сидоров", 333),
                new Contact("Петров", 222)));

        // Добавление контакта.
        contacts.add(new Contact("Иванов", 444));
        // Вывод контакта
        Contact.getContact(contacts, "Иванов");
    }
}
