package com.aston.automation;

public class Triangle implements CalculationPerimeterAndArea {
    private final String backgroundColorTriangle;

    private final String borderColorTriangle;

    public Triangle(String backgroundColorTriangle, String borderColorTriangle) {
        this.backgroundColorTriangle = backgroundColorTriangle;
        this.borderColorTriangle = borderColorTriangle;
    }

    // Площадь треугольника по трем сторонам (формула Герона).
    @Override
    public double calcArea(double... args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Для расчета площади треугольника нужно передать три значения.");
        }
        double lengthA = args[0];
        double lengthB = args[1];
        double lengthC = args[2];

        double halfPerimeter = calcPerimeterTriangle(lengthA, lengthB, lengthC) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - lengthA) * (halfPerimeter - lengthB) * (halfPerimeter - lengthC));
    }

    public void triangleInfo(double lengthA, double lengthB, double lengthC) {
        System.out.println("[ Периметр треугольника = " + calcPerimeterTriangle(lengthA, lengthB, lengthC) + ", " + "Площадь треугольника = "
                + calcArea(lengthA, lengthB, lengthC) + ", " + "Цвет фона " + backgroundColorTriangle + ", " + "Цвет границ " + borderColorTriangle + " ]");
    }
}
