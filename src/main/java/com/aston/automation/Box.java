package com.aston.automation;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private ArrayList<T> items;

    public Box() {
        items = new ArrayList<>();
    }

    public List<T> getItems() {
        return items;
    }

    public void addBox(T fruit) {
        if (fruit instanceof Apple) {
            items.add(fruit);
            System.out.println("Добавлено яблоко в коробку.");

        } else if (fruit instanceof Orange) {
            items.add(fruit);
            System.out.println("Добавлен апельсин в коробку.");
        }
    }

    public static <T extends Fruit> String getWeight(Box<T> box) {
        float weightBox = 0.0f;
        for (T fruit : box.getItems()) {
            weightBox += fruit.getWeight();
        }
        return String.format("%.2f", weightBox);
    }

    public static boolean compare(Box box1, Box box2) {
        return getWeight(box1).equals(getWeight(box2));

    }

    public void pourTo(Box<? super T> anotherBox) {
        while (!this.items.isEmpty()) {
            T element = this.items.remove(0);
            anotherBox.getItems().add(element);
        }

        this.items.clear();

        System.out.println("Все объекты перенесены из первой коробки в другую.");
    }
}
