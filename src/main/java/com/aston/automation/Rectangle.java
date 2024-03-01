package com.aston.automation;

public class Rectangle implements CalculationPerimeterAndArea {
    private final String backgroundColorRectangle;
    private final String borderColorRectangle;

    public Rectangle(String backgroundColorRectangle, String borderColorRectangle) {
        this.backgroundColorRectangle = backgroundColorRectangle;
        this.borderColorRectangle = borderColorRectangle;
    }

    @Override
    public double calcArea(double... args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Для расчета площади прямоугольника нужно передать два значения.");
        }
        double length = args[0];
        double width = args[1];
        if (length > 0.0 && width > 0.0) {
            return length * width;
        } else {
            throw new IllegalArgumentException("Длина и ширина прямоугольника не могут быть отрицательными или нулевыми.");
        }
    }

    public void rectangleInfo(double length, double width) {
        System.out.println("[ Периметр прямоугольника = " + calcPerimeterRectangle(length, width) + ", " + "Площадь прямоугольника = "
                + calcArea(length, width) + ", " + "Цвет фона " + backgroundColorRectangle + ", " + "Цвет границ " + borderColorRectangle + " ]");
    }
}
