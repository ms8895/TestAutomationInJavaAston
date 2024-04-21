package com.aston.automation;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {

        System.out.println(App.getFactorial(11));
    }

    public static int getFactorial(int n) {

        if (n == 0 || n == 1) {
            return 1;
        } else if (n > 0) {
            // Через создание коллекции через Stream API.

            // Генерация чисел в коллекцию до переданного числа
            ArrayList<Integer> integers = IntStream.rangeClosed(1, n).boxed().
                    collect(Collectors.toCollection(ArrayList::new));

            return integers.stream().reduce((x, y) -> x * y).get();
        }
        return 0;
    }
}
