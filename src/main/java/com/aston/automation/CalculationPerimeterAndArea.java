package com.aston.automation;

public interface CalculationPerimeterAndArea {

    default double calcPerimeterCircle(double r) {
        if (r > 0.0) {
            return 2 * Math.PI * r;
        } else {
            throw new IllegalArgumentException("Радиус круга не может быть отрицательным или нулевым.");
        }
    }

    //double calcAreaCircle(double r);
    double calcArea(double... args);

    default double calcPerimeterRectangle(double len, double wid) {
        if (len > 0.0 && wid > 0.0) {
            return 2 * (len + wid);
        } else {
            throw new IllegalArgumentException("Длина и ширина прямоугольника не могут быть отрицательными или нулевыми.");
        }
    }

    //double calcAreaRectangle(double len, double wid);

    default double calcPerimeterTriangle(double lenA, double lenB, double lenC) {
        if (lenA > 0.0 && lenB > 0.0 && lenC > 0.0) {
            return lenA + lenB + lenC;
        } else {
            throw new IllegalArgumentException("Стороны треугольника не могут быть отрицательными или нулевыми.");
        }
    }

    //double calcAreaTriangle(double lenA, double lenB, double lenC);
}
