package com.aston.automation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppFive {
    public static void main(String[] args) {
        // 5.
        List<User> users = loginsFromConsole();
        getLogin(users, "d");
    }

    public static List<User> loginsFromConsole() {
        System.out.println("Введите логин: ");
        Scanner sc = new Scanner(System.in);
        List<User> users = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                break;
            }
            User login = new User(line);
            users.add(login);
        }
        sc.close();
        return users;
    }

    public static String getLogin(List<User> users, String letter) {
        List<User> newList = users.stream()
                .filter(u -> u.getLogin().startsWith(letter))
                .collect(Collectors.toList());

        if (newList.isEmpty()) {
            return "В списке нет логинов начинающихся на " + letter + ".";
        } else {
            return "Логины, начинающиеся на " + letter + ": " + newList;
        }
    }
}
