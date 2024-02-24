package com.aston.automation;

// 1.
public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    public int age;

    public Employee(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void employeeInfo() {
        System.out.println("ФИО: " + fullName + "\n" + "Должность: " + position + "\n" + "Email: " + email +
                "\n" + "Телефон: " + phoneNumber + "\n" + "Зарплата: " + salary + "\n" + "Возраст: " + age);
        System.out.println();
    }
}
