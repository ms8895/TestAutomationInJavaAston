package com.aston.automation;

public class App {
    public static void main(String[] args) {
        // 2.
        Employee[] employeesArray = new Employee[5];

        employeesArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        employeesArray[1] = new Employee("Petrov Sasha", "Accountant", "petrov@mailbox.com", "123", 28000, 40);
        employeesArray[2] = new Employee("Sidorov Lesha", "Manager", "sidorov@mailbox.com", "456", 26000, 41);
        employeesArray[3] = new Employee("Ivanova Katya", "Analyst", "ivanova@mailbox.com", "789", 24000, 39);
        employeesArray[4] = new Employee("Petrova Nina", "Specialist", "petrova@mailbox.com", "012", 22000, 50);

        for (Employee emp : employeesArray) {
            if (emp.age > 40)
                emp.employeeInfo();
        }
    }
}
