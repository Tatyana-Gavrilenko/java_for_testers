package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea( 6.0);
        Square.printSquareArea( 7.9);

        Rectangle.printRectangleArea(3.0, 5.0);
        Rectangle.printRectangleArea(4.0, 8.0);

        Triangle.printlTriangleArea(5.0, 4.0, 3.0);
    }

}
