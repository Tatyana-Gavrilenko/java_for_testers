package ru.stqa.geometry.figures;

public class Triangle {

    private double a;
    private double b;
    private double c;

    public Triangle (double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void printlTriangleArea(Triangle t) {
        var text = String.format("Площадь треугольника со сторонами %f и %f и %f = %f", t.a, t.b, t.c, t.triangleArea());
        System.out.println(text);
    }

    public static void printlTrianglePerimeter(Triangle t) {
        var text = String.format("Периметр треугольника со сторонами %f и %f и %f = %f", t.a, t.b, t.c, t.trianglPperimeter());
        System.out.println(text);
    }

    public double trianglPperimeter() {
        return this.a + this.b + this.c;
    }

    public double triangleArea() {
        double p = (this.a + this.b + this.c)/2;
        return Math.sqrt(p*(p-this.a)*(p-this.b)*(p-this.c));
    }
}
