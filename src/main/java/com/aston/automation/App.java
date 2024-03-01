package com.aston.automation;

public class App {
    public static void main(String[] args) {

        // 1.
        Animal animal = new Animal("Животное");
        Cat cat1 = new Cat("Кот1");
        Dog dog1 = new Dog("Пес");

        Cat[] catsArray = new Cat[5];
        catsArray[0] = new Cat("Мурзик", 2, false);
        catsArray[1] = new Cat("Барсик", 4, false);
        catsArray[2] = new Cat("Васька", 6, false);
        catsArray[3] = new Cat("Том", 8, false);
        catsArray[4] = new Cat("Леопольд", 10, false);


        animal.run(10);
        System.out.println();

        cat1.run(0);
        cat1.run(1);
        cat1.run(201);
        System.out.println();

        dog1.run(0);
        dog1.run(1);
        dog1.run(501);
        System.out.println();

        animal.swim(13);
        System.out.println();

        cat1.swim(1);
        cat1.swim();
        System.out.println();

        dog1.swim(0);
        dog1.swim(1);
        dog1.swim(11);
        System.out.println();

        // Количество котов, собак и животных
        System.out.println("Количество созданных животных: " + Animal.getAnimalCount());
        System.out.println("Количество созданных котов: " + Cat.getCatCount());
        System.out.println("Количество созданных собак: " + Dog.getDogCount());
        System.out.println();

        Plate plate = new Plate(15);
        plate.foodInfo();

        for (int i = 0; i < catsArray.length; i++) {
            if (!catsArray[i].satiety) {
                if (catsArray[i].catNeededEat <= plate.food) {
                    catsArray[i].catEating(plate);
                    catsArray[i].satiety = true;
                    System.out.println(catsArray[i].catName + " поел.");
                } else {
                    System.out.println(catsArray[i].catName + " не поел.");
                }
            }
        }
        System.out.println();
        // Добавить еды
        plate.addFood(10);
        plate.foodInfo();
        System.out.println();

        // Вывод котов
        for (Cat cat : catsArray) {
            System.out.println(cat);
        }

        // 2.
        System.out.println("\n" + "// 2.");
        // Круг
        Circle circle = new Circle("красный", "желтый");
        System.out.println("Периметр круга = " + circle.calcPerimeterCircle(2.5));
        System.out.println("Площадь круга = " + circle.calcArea(2.5));
        circle.circleInfo(2.5);
        // Прямоугольник
        System.out.println();
        Rectangle rectangle = new Rectangle("зеленый", "фиолетовый");
        System.out.println("Периметр прямоугольника = " + rectangle.calcPerimeterRectangle(3, 2));
        System.out.println("Площадь прямоугольника = " + rectangle.calcArea(3, 2));
        rectangle.rectangleInfo(3, 2);
        // Треугольник
        System.out.println();
        Triangle triangle = new Triangle("белый", "синий");
        System.out.println("Периметр треугольника = " + triangle.calcPerimeterTriangle(5, 7, 9));
        System.out.println("Площадь треугольника = " + triangle.calcArea(5, 7, 9));
        triangle.triangleInfo(5, 7, 9);
    }
}
