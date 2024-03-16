package com.aston.automation;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AppTest {

    @Test
    public void testAddArrayString() {
        // Массив со строкой.
        String[][] array = {{"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "J", "11", "12"},
                {"13", "14", "15", "16"}};

        Assertions.assertThatThrownBy(() -> App.addArray(array))
                .isInstanceOf(MyArrayDataException.class)
                .hasMessage("\n" +
                        "Невозможно преобразовать строку, символ в число.\n" +
                        "Строка, символ: J.\n" +
                        "Индекс строки, символа: [2][1].");
    }

    @Test
    public void testAddArrayStringDataException() {
        // Массив со строкой.
        String[][] array = {{"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "J", "11", "12"},
                {"13", "14", "15", "16"}};

        Assertions.assertThatThrownBy(() -> App.addArray(array)).isInstanceOf(MyArrayDataException.class);
    }

    @Test
    public void testAddArraySimbol() {
        //Массив с символом.
        String[][] array = {{"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "?", "16"}};

        Assertions.assertThatThrownBy(() -> App.addArray(array))
                .isInstanceOf(MyArrayDataException.class)
                .hasMessage("\n" +
                        "Невозможно преобразовать строку, символ в число.\n" +
                        "Строка, символ: ?.\n" +
                        "Индекс строки, символа: [3][2].");
    }

    @Test
    public void testAddArraySimbolDataException() {
        //Массив с символом.
        String[][] array = {{"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "?", "16"}};

        Assertions.assertThatThrownBy(() -> App.addArray(array)).isInstanceOf(MyArrayDataException.class);
    }

    @Test
    public void testAddArrayNumbers() throws MyArraySizeException, MyArrayDataException {
        // Массив с числами.
        String[][] array = {{"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};

        assertEquals("Сумма массива: 136.", App.addArray(array));
    }

    @Test
    public void testAddArraySize() {
        // Массив 3х3.
        String[][] array = {{"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}};

        Assertions.assertThatThrownBy(() -> App.addArray(array))
                .isInstanceOf(MyArraySizeException.class)
                .hasMessage("\n" + "Массив не соответствует размеру 4х4.");
    }

    @Test
    public void testAddArraySizeException() {
        // Массив 3х3.
        String[][] array = {{"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}};

        Assertions.assertThatThrownBy(() -> App.addArray(array)).isInstanceOf(MyArraySizeException.class);
    }
}
