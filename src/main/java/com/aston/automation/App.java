package com.aston.automation;

public class App {

    public static void main(String[] args) {

        // 1.
        System.out.println("// 1.");
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(count(nums, func));

    }

    // 1. //
    public static String count(int[] numbers, Expression func) {
        int result = 0;
        for (int i : numbers) {
            if (func.isEqual(i))
                result++;
        }
        return "Количество четных чисел: " + result;
    }

    public static Expression func = (n) -> {
        if (n > 0) {
            return n % 2 == 0;
        }
        return false;
    };

    interface Expression {
        boolean isEqual(int n);
    }
    // 1. //
}
