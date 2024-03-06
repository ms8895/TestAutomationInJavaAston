package com.aston.automation;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        {
            // 1.
            System.out.println("// 1.");

            int a = (int) (Math.random() * 21); // от 0 до 20
            int b = (int) (Math.random() * 21); // от 0 до 20
            //System.out.println(a + " и " + b);

            System.out.println(checkRange(a, b));
        }

        {
            // 2.
            System.out.println("\n" + "// 2.");

            int[] numbers = {-2, -1, 0, 1};
            int index = (int) (Math.random() * numbers.length);
            int value = numbers[index];
            //System.out.println(value);

            System.out.println(positiveNegativeString(value));

            // 3.
            System.out.println("\n" + "// 3.");

            System.out.println(positiveNegativeBoolean(value));
        }

        {
            // 4.
            System.out.println("\n" + "// 4.");
            int[] numbers = {0, 1, 2, 3};
            int index = (int) (Math.random() * numbers.length);
            int value = numbers[index];

            printString("I'm a string! ", value);
        }

        {
            // 5.
            System.out.println("\n" + "// 5.");
            //https://www.kp.ru/woman/goroskop/visokosnye-goda-po-spisku/

            int[] years = {2000, 2001, 2002, 2004, 2006, 2008, 2010, 2011, 2012, 2014, 2016, 2017, 2020};
            int index = (int) (Math.random() * years.length);
            int year = years[index];
            //System.out.println(year);

            System.out.println(leapYear(year));
        }

        {
            // 6.
            System.out.println("\n" + "// 6.");

            int[] numbers = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
            System.out.println(changeValues(numbers));
        }

        {
            // 7.
            System.out.println("\n" + "// 7.");

            int[] numbers = new int[100];
            System.out.println(Arrays.toString(fillArray(numbers)));
        }

        {
            // 8.
            System.out.println("\n" + "// 8.");

            int[] numbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            multiplyNumber(numbers);
            System.out.println();
        }

        {
            // 9.
            System.out.println("\n" + "// 9.");

            int[][] array = new int[5][5];
            fillDiagonal(array);

            for (int[] row : array) {
                for (int element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        }

        {
            // 10.
            System.out.println("\n" + "// 10.");

            int len = (int) (Math.random() * 11);
            int initialValue = (int) (((Math.random() * 11) - 10)
                    + (Math.random() * 11));

            System.out.println(len + ", " + initialValue);
            System.out.println(Arrays.toString(returnArray(len, initialValue)));
        }
    }

    // 1.
    public static boolean checkRange(int a, int b) {
        int sum = a + b;
        if (sum > 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    // 2.
    public static String positiveNegativeString(int value) {
        return value >= 0 ? value + " is positive" : value + " is negative";
    }

    // 3.
    public static boolean positiveNegativeBoolean(int value) {
        return value < 0;
    }

    // 4.
    public static void printString(String line, int value) {
        int a = 0;
        while (a < value) {
            System.out.println(line);
            a++;
        }
    }

    // 5.
    public static boolean leapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }

    // 6.
    public static String changeValues(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                numbers[i] = 0;
            } else {
                numbers[i] = 1;
            }
        }
        return Arrays.toString(numbers);
    }

    // 7.
    public static int[] fillArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        return numbers;
    }

    // 8.
    public static void multiplyNumber(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 6) {
                System.out.print(numbers[i] * 2);
            } else {
                System.out.print(numbers[i]);
            }

            if (i != numbers.length - 1) {
                System.out.print(", ");
            }
        }
    }

    // 9.
    public static void fillDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array[i].length - 1; j >= 0; j--) {
                if (i == j || i + j == array.length - 1) {
                    array[i][j] = 1;
                }
            }
        }
    }

    // 10.
    public static int[] returnArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}
