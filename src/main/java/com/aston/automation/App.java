package com.aston.automation;

public class App {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        Apple apple1 = new Apple("Яблоко 1", 0.6f);
        Apple apple2 = new Apple("Яблоко 2", 0.3f);

        Orange orange1 = new Orange("Апельсин 1", 0.4f);
        Orange orange2 = new Orange("Апельсин 2", 0.5f);

        appleBox.addBox(apple1);
        appleBox.addBox(apple2);
        orangeBox.addBox(orange1);
        orangeBox.addBox(orange2);

        System.out.println("Содержимое в коробке с яблоками:");
        for (Apple apple : appleBox.getItems()) {
            System.out.println(apple.getName());
        }

        System.out.println("Содержимое в коробке с апельсинами:");
        for (Orange orange : orangeBox.getItems()) {
            System.out.println(orange.getName());
        }

        System.out.println("Общий вес коробки с яблоками: " + Box.getWeight(appleBox));
        System.out.println("Общий вес коробки с апельсинами: " + Box.getWeight(orangeBox));


        System.out.println("Сравнение массы коробок: " + Box.compare(appleBox, orangeBox));

        // Другая коробка для пересыпания фруктов
        Box<Apple> newAppleBox = new Box<>();

        appleBox.pourTo(newAppleBox);

        System.out.println("Содержимое коробки с яблоками после пересыпания:");
        for (Apple apple : appleBox.getItems()) {
            System.out.println(apple.getName());
        }

        System.out.println("Содержимое другой коробки с яблоками после пересыпания:");
        for (Apple apple : newAppleBox.getItems()) {
            System.out.println(apple.getName());
        }
    }
}
