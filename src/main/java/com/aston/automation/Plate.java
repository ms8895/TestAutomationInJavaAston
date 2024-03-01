package com.aston.automation;

public class Plate {
    int food;

    public Plate(int food) {
        this.food = food;
    }

    public void addFood(int add) {
        food += add;
        System.out.println("Добавлено еды: " + food);
    }

    public void deleteFood(int ate) {
        food -= ate;
    }

    public void foodInfo() {
        System.out.println("Количество еды в тарелке: " + food);
    }
}
