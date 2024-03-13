package com.aston.automation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) {

        String[] header = {"Value 1", "Value 2", "Value 3"};
        int[][] data = {
                {100, 300},
                {200, 400},
                {123, 500}};

        // Запись данных в файл.
        writeDataToFile(header, data);
        // Чтение данных из файла.
        readDataFromFile();
    }

    private static void writeDataToFile(String[] header, int[][] data) {
        try {
            File file = new File("newFile.csv");
            PrintWriter writer = new PrintWriter(file);

            if (!file.exists())
                file.createNewFile();

            for (int i = 0; i < header.length; i++) {
                writer.print(header[i]);
                if (i != header.length - 1) {
                    writer.print(";");
                }
            }
            writer.println();

            for (int j = 0; j < data[0].length; j++) {
                for (int i = 0; i < data.length; i++) {
                    writer.print(data[i][j]);
                    if (i != data.length - 1) {
                        writer.print(";");
                    }
                }
                writer.println();
            }
            System.out.println("Данные записаны в файл.");

            writer.close();

        } catch (IOException e) {
            System.out.println("Ошибка файла: " + e);
        }
    }

    private static void readDataFromFile() {
        try {
            File file = new File("newFile.csv");

            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(formatingString((line)));
                }
                reader.close();

            } else {
                System.out.println("Файл не существует.");
            }

        } catch (IOException e) {
            System.out.println("Ошибка файла: " + e);
        }
    }

    private static String formatingString(String line) {
        return line.replace(";", "; ");
    }
}
