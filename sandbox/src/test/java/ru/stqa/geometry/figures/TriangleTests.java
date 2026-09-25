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
}
