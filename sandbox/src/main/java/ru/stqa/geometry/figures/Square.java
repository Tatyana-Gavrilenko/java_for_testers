package ru.stqa.geometry.figures;

public class Square {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    public static void printSquareArea(Square s) {
        String text = String.format("Площадь квадрата со стороной %f = %f", s.side, s.Area());
        System.out.println(text);
    }

    public double Area() {
        return this.side * this.side;
    }

    public double perimeter() {
        return 4 * this.side;
    }
}
