package com.aston.automation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppFour {
    public static void main(String[] args) {

        // 4.
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


        getStudent(students);
        averageAge(students);

    }

    // 4.1
    public static String averageAge(List<Student> students) {
        double average = students.stream()
                .filter(s -> s.getGender().equals("М"))
                .mapToInt(Student::getAge)
                .summaryStatistics().getAverage();

        if (average > 0) {
            return String.format("Средний возраст студентов: %.1f.", average);
        } else {
            return "Нет студентов мужского пола.";
        }
    }

    // 4.2
    public static void getStudent(List<Student> students) {
        List<Student> newList = students.stream()
                .filter(s -> s.getGender().equals("М"))
                .filter(s -> s.getAge() >= 18 && s.getAge() <= 27)
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());

        if (newList.isEmpty()) {
            System.out.println("Нет студентов, которым грозит получение повестки в этом году.");
        } else {
            newList.forEach(s -> System.out.println("Студенту " + s.getName() + " грозит получение повестки в этом году."));
        }
    }
}
