package com.aston.automation;

public class Animal {
    private String name;
    private static int animalCount;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public Animal() {
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public void run(int distance) {
        System.out.println(name + " пробежало " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыло " + distance + " м.");
    }

}
