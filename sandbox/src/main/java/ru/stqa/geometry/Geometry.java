package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(new Square(6.0));
        Square.printSquareArea(new Square(7.9));

        Rectangle.printRectangleArea(new Rectangle(5, 4));
        Rectangle.printRectangleArea(new Rectangle(5, 8));

        Triangle.printlTriangleArea(new Triangle(5, 4, 3));
    }

}
