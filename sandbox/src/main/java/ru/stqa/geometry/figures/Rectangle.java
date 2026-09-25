package ru.stqa.geometry.figures;

public class Rectangle {

    double a;
    double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public static void printRectangleArea(Rectangle r) {
        var text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", r.a, r.b, r.rectangleArea());
        System.out.println(text);
    }

    public double rectangleArea(){
        return this.a * this.b;
    }
}
