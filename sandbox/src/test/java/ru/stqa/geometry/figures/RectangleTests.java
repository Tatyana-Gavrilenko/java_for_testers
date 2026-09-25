package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTests {

    @Test
    void canCalculateRectangleArea(){
        var r = new Rectangle(5, 6);
        double result =  r.rectangleArea();
        Assertions.assertEquals(30, result);
    }
}
