package ru.stqa.geometry.figures;

public class Triangle {
    public static void printlTriangleArea(double a, double b, double c) {
        var text = String.format("Площадь треугольника со сторонами %f и %f и %f = %f", a, b, c, triangleArea(a, b, c));
        System.out.println(text);
    }
    private static double triangleArea(double a, double b, double c) {
        double p = Triangle.trianglePerimeter(a, b, c);
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    private static double trianglePerimeter(double a,
                                           double b,
                                           double c) {
        return (a + b + c)/2;
    }

}
