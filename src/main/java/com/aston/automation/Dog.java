package com.aston.automation;

public class Dog extends Animal {
    private String dogName;
    private static int dogCount;

    public Dog(String dogName) {
        this.dogName = dogName;
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int distance) {
        if (distance < 500 && distance >= 1) {
            System.out.println(dogName + " пробежал " + distance + " м.");
        } else if (distance >= 500) {
            System.out.println(dogName + " пробежал " + 500 + " м.");
        } else {
            System.out.println(dogName + " не побежал.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance < 10 && distance >= 1) {
            System.out.println(dogName + " проплыл " + distance + " м.");
        } else if (distance >= 10) {
            System.out.println(dogName + " проплыл " + 10 + " м.");
        } else {
            System.out.println(dogName + " не поплыл.");
        }
    }
}
