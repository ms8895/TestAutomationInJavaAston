package com.aston.automation;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.aston.automation.App.func;
import static junit.framework.TestCase.assertEquals;

public class AppTest {
    // 1. //
    @Test
    public void zeroEvenNumbers() {
        int[] nums = {0, 0, 0};
        assertEquals("Количество четных чисел: 0", App.count(nums, func));
    }

    @Test
    public void oneEvenNumbers() {
        int[] nums = {0, 2, 9};
        assertEquals("Количество четных чисел: 1", App.count(nums, func));
    }

    @Test
    public void fourEvenNumbers() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals("Количество четных чисел: 4", App.count(nums, func));
    }

    @Test
    public void minusEvenNumbers() {
        int[] nums = {1, -2};
        assertEquals("Количество четных чисел: 0", App.count(nums, func));
    }
    // 1. //

    // 2. //
    @Test
    public void testFindWordInArraysIsThree() {
        List<String> arrayList = new ArrayList<>(Arrays.asList("Highload", "Load", "High", "High", "Load", "Highload", "Load"));
        assertEquals("Объект Load встречается 3 раз(а).", AppTwo.findWordInArrays(arrayList, "Load"));
    }

    @Test
    public void testFindWordInArraysIsOne() {
        List<String> arrayList = new ArrayList<>(Arrays.asList("Highload", "Load", "High", "Load", "Highload", "Load"));
        assertEquals("Объект High встречается 1 раз(а).", AppTwo.findWordInArrays(arrayList, "High"));
    }

    @Test
    public void testFindWordInArraysIsZero() {
        List<String> arrayList = new ArrayList<>(Arrays.asList("Highload", "Load", "High", "Load", "Highload", "Load"));
        assertEquals("0", AppTwo.findWordInArrays(arrayList, "NONE"));
    }

    @Test
    public void testFindWordInArraysIsEmpty() {
        List<String> arrayList = new ArrayList<>(Arrays.asList());
        assertEquals("0", AppTwo.findWordInArrays(arrayList, "High"));
    }

    @Test
    public void testFindFirstWordIsEmpty() {
        List<String> arrayList = new ArrayList<>(Arrays.asList());
        assertEquals("0", AppTwo.findFirstWord(arrayList));
    }

    @Test
    public void testFindFirstWordIsOne() {
        List<String> arrayList = new ArrayList<>(Arrays.asList("Load"));
        assertEquals("Первое слово в списке Load.", AppTwo.findFirstWord(arrayList));
    }

    @Test
    public void testFindFirstWord() {
        List<String> arrayList = new ArrayList<>(Arrays.asList("Highload", "Load", "High"));
        assertEquals("Первое слово в списке Highload.", AppTwo.findFirstWord(arrayList));
    }

    @Test
    public void testFindLastWordIsEmpty() {
        List<String> arrayList = new ArrayList<>(Arrays.asList());
        assertEquals("0", AppTwo.findLastWord(arrayList));
    }

    @Test
    public void testFindLastWordIsOne() {
        List<String> arrayList = new ArrayList<>(Arrays.asList("Load"));
        assertEquals("Последнее слово в списке Load.", AppTwo.findLastWord(arrayList));
    }

    @Test
    public void testFindLastWord() {
        List<String> arrayList = new ArrayList<>(Arrays.asList("Highload", "Load", "High"));
        assertEquals("Последнее слово в списке High.", AppTwo.findLastWord(arrayList));
    }
    // 2. //

    // 3. //
    @Test
    public void testStringSortAndAddToArr() {
        List<String> arrayList = new ArrayList<>(Arrays.asList("f10", "f15", "f2", "f4", "f4"));
        assertEquals("[f10, f15, f2, f4, f4]", AppThree.sortAndAddToArr(arrayList));
    }

    @Test
    public void testStringTwoSortAndAddToArr() {
        List<String> arrayList = new ArrayList<>(Arrays.asList("Highload", "Load", "High"));
        assertEquals("[High, Highload, Load]", AppThree.sortAndAddToArr(arrayList));
    }
    // 3. //

    // 4. //
    @Test
    public void testAverageAgeOneStudent() {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Иванов", "М", 17)));
        assertEquals("Средний возраст студентов: 17,0.", AppFour.averageAge(students));
    }

    @Test
    public void testAverageAgeNoStudent() {
        List<Student> students = new ArrayList<>(Arrays.asList());
        assertEquals("Нет студентов мужского пола.", AppFour.averageAge(students));
    }

    @Test
    public void testAverageAge() {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Иванов", "М", 17),
                new Student("Смирнов", "М", 28),
                new Student("Кузнецова", "Ж", 18)));
        assertEquals("Средний возраст студентов: 22,5.", AppFour.averageAge(students));
    }

    @Test
    public void testAverageAgeNoMaleStudents() {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Смирнова", "Ж", 28),
                new Student("Кузнецова", "Ж", 18)));
        assertEquals("Нет студентов мужского пола.", AppFour.averageAge(students));
    }

    @Test
    public void testGetStudent() {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Иванов", "М", 17),
                new Student("Сидоров", "М", 18),
                new Student("Петров", "М", 19),
                new Student("Козлов", "М", 26),
                new Student("Новиков", "М", 27),
                new Student("Смирнов", "М", 28),
                new Student("Кузнецова", "Ж", 18),
                new Student("Морозова", "Ж", 25),
                new Student("Васильева", "Ж", 30)));

        // Ожидаемый вывод
        String expectedOutput = "Студенту Козлов грозит получение повестки в этом году." + System.lineSeparator() +
                "Студенту Новиков грозит получение повестки в этом году." + System.lineSeparator() +
                "Студенту Петров грозит получение повестки в этом году." + System.lineSeparator() +
                "Студенту Сидоров грозит получение повестки в этом году.";


        // Перенаправляем вывод в буфер для сравнения
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        AppFour.getStudent(students);

        // Фактический вывод
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testGetStudentAllFemale() {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Иванова", "Ж", 17),
                new Student("Васильева", "Ж", 30)));

        // Ожидаемый вывод
        String expectedOutput = "Нет студентов, которым грозит получение повестки в этом году.";
        // Перенаправляем вывод в буфер для сравнения
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        AppFour.getStudent(students);

        // Фактический вывод
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testGetStudentNoAgeRequired() {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Иванов", "Ж", 17),
                new Student("Сидоров", "Ж", 28),
                new Student("Петров", "Ж", 17),
                new Student("Козлов", "Ж", 35),
                new Student("Новиков", "Ж", 29),
                new Student("Смирнов", "Ж", 28),
                new Student("Кузнецова", "Ж", 32),
                new Student("Морозова", "Ж", 30),
                new Student("Васильева", "Ж", 30)));

        // Ожидаемый вывод
        String expectedOutput = "Нет студентов, которым грозит получение повестки в этом году.";
        // Перенаправляем вывод в буфер для сравнения
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        AppFour.getStudent(students);

        // Фактический вывод
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }
    // 4. //

    // 5. //
    @Test
    public void testGetLoginNoLogin() {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("ererer"),
                new User("aascvsfe")));

        assertEquals("В списке нет логинов начинающихся на d.", AppFive.getLogin(users, "d"));

    }

    @Test
    public void testGetLogin() {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("havier"),
                new User("Hamond"),
                new User("Lapot"),
                new User("handle")));

        assertEquals("Логины, начинающиеся на h: [havier, handle]", AppFive.getLogin(users, "h"));
    }
    // 5. //
}
