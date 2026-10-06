package ru.stqa.geometry.figures;

import java.util.Objects;

public record Triangle (double a,
                        double b,
                        double c)
    {
    public Triangle {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Any side Triangle should be non-negative");}

        if (a + b < c || a + c < b || b + c < a) {
            throw new IllegalArgumentException("Sum of two sides Triangle should be no less than a third");
        }
    }

    public static void printlTriangleArea(Triangle t) {
        var text = String.format("Площадь треугольника со сторонами %f и %f и %f = %f", t.a, t.b, t.c, t.triangleArea());
        System.out.println(text);
    }

    public static void printlTrianglePerimeter(Triangle t) {
        var text = String.format("Периметр треугольника со сторонами %f и %f и %f = %f", t.a, t.b, t.c, t.trianglPerimeter());
        System.out.println(text);
    }

    public double trianglPerimeter() {
        return this.a + this.b + this.c;
    }

    public double triangleArea() {
        double p = (this.a + this.b + this.c)/2;
        return Math.sqrt(p*(p-this.a)*(p-this.b)*(p-this.c));
    }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Triangle triangle = (Triangle) o;
            return (Double.compare(a, triangle.a) == 0 && Double.compare(b, triangle.b) == 0 && Double.compare(c, triangle.c) == 0)
                    || (Double.compare(b, triangle.a) == 0 && Double.compare(c, triangle.b) == 0 && Double.compare(b, triangle.c) == 0)
                    || (Double.compare(b, triangle.a) == 0 && Double.compare(a, triangle.b) == 0 && Double.compare(a, triangle.c) == 0)
                    || (Double.compare(c, triangle.a) == 0 && Double.compare(a, triangle.b) == 0 && Double.compare(b, triangle.c) == 0)
                    || (Double.compare(b, triangle.a) == 0 && Double.compare(c, triangle.b) == 0 && Double.compare(a, triangle.c) == 0)
                    || (Double.compare(c, triangle.a) == 0 && Double.compare(b, triangle.b) == 0 && Double.compare(a, triangle.c) == 0);
        }
        public int hashCode() {
            return 1;
        }
    }
