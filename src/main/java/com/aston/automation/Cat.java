package com.aston.automation;

public class Cat extends Animal {

    String catName;
    private static int catCount;
    boolean satiety;
    int catNeededEat;

    public Cat(String catName) {
        catCount++;
        this.catName = catName;
    }

    public Cat(String catName, int catNeededEat, boolean satiety) {
        catCount++;
        this.catName = catName;
        this.catNeededEat = catNeededEat;
        this.satiety = satiety;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void run(int distance) {
        if (distance < 200 && distance >= 1) {
            System.out.println(catName + " пробежал " + distance + " м.");
        } else if (distance >= 200) {
            System.out.println(catName + " пробежал " + 200 + " м.");
        } else {
            System.out.println(catName + " не побежал.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(catName + " не умеет плавать.");
    }

    public void swim() {
        System.out.println(catName + " не умеет плавать.");
    }

    public void catEating(Plate plate) {
        plate.deleteFood(catNeededEat);
    }

    @Override
    public String toString() {
        return "[" + catName + ", " + catNeededEat + ", " + satiety + "]";
    }
}
