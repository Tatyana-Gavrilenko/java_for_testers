package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalcutateAreaTriangle () {
        var t = new Triangle(5, 4, 3);
        double result = t.triangleArea();
        Assertions.assertEquals(6, result);
    }

    @Test
    void canCalculatePerimeterTriangle() {
        Assertions.assertEquals(12, new Triangle(5,4,3).trianglPerimeter());
    }

    //Позитивный сценарий
    @Test
    void creatTriangleSuccess() {
        try {
            new Triangle( 5.0, 4.0, 3.0);
        }
        catch (IllegalArgumentException exception) {
            Assertions.fail();
        }
    }
    //негативный сценарий отрициательная сторона A
    @Test
    void cannotCreatTriangleWithNegativeSideA() {
        try {
            new Triangle( -5.0, 4.0, 3.0);
            Assertions.fail();}
        catch (IllegalArgumentException exception) {
            //ok
        }
    }
    //негативный сценарий отрициательная сторона B
    @Test
    void cannotCreatTriangleWithNegativeSideB() {
        try {
            new Triangle( 5.0, -4.0, 3.0);
            Assertions.fail();}
        catch (IllegalArgumentException exception) {
            //ok
        }
    }
    //негативный сценарий отрициательная сторона C
    @Test
    void cannotCreatTriangleWithNegativeSideC() {
        try {
            new Triangle( 5.0, 4.0, -3.0);
            Assertions.fail();}
        catch (IllegalArgumentException exception) {
            //ok
        }
    }
    //проверка суммы сторон a + b < c
    @Test
    void sumSidesAbc() {
        try {
            new Triangle( 1.0, 2.0, 4.0);
            Assertions.fail();}
        catch (IllegalArgumentException exception) {
            //ok
        }
    }
    //проверка суммы сторон a + c < b
    @Test
    void sumSidesAcb() {
        try {
            new Triangle( 1.0, 4.0, 2.0);
            Assertions.fail();}
        catch (IllegalArgumentException exception) {
            //ok
        }
    }
    //проверка суммы сторон c + b < a
    @Test
    void sumSidesCba() {
        try {
            new Triangle( 4.0, 2.0, 1.0);
            Assertions.fail();}
        catch (IllegalArgumentException exception) {
            //ok
        }
    }

    @Test
    void testEqualityTri() {
        var t1 = new Triangle(3.0, 4.0, 5.0);
        var t2 = new Triangle(4.0, 5.0, 3.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEquality2(){
        var a = 2;
        var b = 3;
        var c = 4;
        var triangle = new Triangle(a, b, c);
        var triangle1 = new Triangle(a, c, b);
        Assertions.assertEquals(triangle, triangle1);
    }
}