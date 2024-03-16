package com.aston.automation;

public class App {
    public static void main(String[] args) {

        try {
            // Массив со строкой.
            String[][] array = {{"1", "2", "3", "4"},
                    {"5", "6", "7", "8"},
                    {"9", "J", "11", "12"},
                    {"13", "14", "15", "16"}};
            addArray(array);
            // Массив с числами.
            String[][] newArray1 = {{"1", "2", "3", "4"},
                    {"5", "6", "7", "8"},
                    {"9", "10", "11", "12"},
                    {"13", "14", "15", "16"}};
            addArray(newArray1);

            // Массив 3х3.
            String[][] newArray2 = {{"1", "2", "3", "4"},
                    {"5", "6", "7", "8"},
                    {"9", "10", "11", "12"}};
            addArray(newArray2);

            //Массив с символом.
            String[][] newArray3 = {{"1", "2", "3", "4"},
                    {"5", "6", "7", "8"},
                    {"9", "10", "11", "12"},
                    {"13", "14", "?", "16"}};
            addArray(newArray3);

        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static String addArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array.length != 4) {
            throw new MyArraySizeException("\n" + "Массив не соответствует размеру 4х4.");
        } else {
            int sum = 0;

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("\n" + "Невозможно преобразовать строку, символ в число."
                                + "\n" + "Строка, символ: " + array[i][j] + "."
                                + "\n" + "Индекс строки, символа: " + "[" + i + "]" + "[" + j + "].");
                    }
                }
            }
            return "Сумма массива: " + sum + ".";
        }
    }
}
