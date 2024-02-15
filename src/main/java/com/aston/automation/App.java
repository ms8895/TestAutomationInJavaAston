package com.aston.automation;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        App.printThreeWords();
        App.checkSumSign();
        App.printColor();
        App.compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange" + "\n" + "Banana" + "\n" + "Apple");
    }

    public static void checkSumSign() {
        double randomX = (Math.random() * 101) - 100; //от -100 до 0
        double randomY = (Math.random() * 101); //от 0 до 100

        int a = (int) randomX;
        int b = (int) randomY;

        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
        //System.out.println(a + "\n" + b);
    }

    public static void printColor() {
        int[] numbers = {-1, 0, 1, 100, 101, 102};
        int index = (int) (Math.random() * numbers.length);

        int value = numbers[index];
        //System.out.println(value);
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        double randomX = (Math.random() * 11); //от 0 до 10
        double randomY = (Math.random() * 11); //от 0 до 10

        int a = (int) randomX;
        int b = (int) randomY;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
        //System.out.println(a + "\n" + b);
    }
}
