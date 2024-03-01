package com.aston.automation;

public class Circle implements CalculationPerimeterAndArea {
    private final String backgroundColorCircle;
    private final String borderColorCircle;

    public Circle(String backgroundColorCircle, String borderColorCircle) {
        this.backgroundColorCircle = backgroundColorCircle;
        this.borderColorCircle = borderColorCircle;
    }

    @Override
    public double calcArea(double... args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Для расчета площади круга нужно передать одно значение.");
        }
            double radius = args[0];
            if (radius > 0.0) {
                return Math.PI * Math.pow(radius, 2);
            } else {
                throw new IllegalArgumentException("Радиус круга не может быть отрицательным или нулевым.");
            }
    }

    public void circleInfo(double radius) {
        System.out.println("[ Периметр круга = " + calcPerimeterCircle(radius) + ", " + "Площадь круга = "
                + calcArea(radius) + ", " + "Цвет фона " + backgroundColorCircle + ", " + "Цвет границ " + borderColorCircle + " ]");
    }
}
