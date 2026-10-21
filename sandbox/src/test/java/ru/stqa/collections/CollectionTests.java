package ru.stqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTests {

    @Test
    void arrayTests() {
        var array = new String[]{"a", "b", "c"};
        //Assertions.assertEquals("a", array[0]);
        //Массив имеет фиксированную длинну и его элементы можно только изменять

        array[0] = "d";
        Assertions.assertEquals("d", array[0]);
    }

    @Test
    void arrayTests2() {
        var array = new String[3];
        array[0] = "a";
        array[1] = "b";
        array[2] = "c";
        //Assertions.assertEquals("c", array[2]);
        Assertions.assertEquals(3, array.length);
    }

    @Test
    void listTests() {
        var list = new ArrayList<String>();
        Assertions.assertEquals(0, list.size());
        // Список имеет переменную длину, элементы у него можно добавлять, изменять, удалять

        list.add("a");
        list.add("b");
        list.add("c");

        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("a", list.get(0));

        list.set(0, "d");
        Assertions.assertEquals("d", list.get(0));
    }

    @Test
    void listTests2() {
        var list = List.of("a", "b", "c"); //список созданный этой функцией является не модифицируемым, но заранее проинициализирован набором элементов
       // var list = new ArrayList<String>();
        Assertions.assertEquals(3, list.size());
        // здесь нельзя менять элементы списка

        Assertions.assertEquals("a", list.get(0));

        list.set(0, "d");
        Assertions.assertEquals("d", list.get(0));//здесь сломается
    }

    @Test
    void listTests3() {
        var list = new ArrayList<>(List.of("a", "b", "c")); //сначала создается список не модифицируемый, а дальше он становится модифицированным
        Assertions.assertEquals(3, list.size());
        // здесь нельзя менять элементы списка

        Assertions.assertEquals("a", list.get(0));

        list.set(0, "d");
        Assertions.assertEquals("d", list.get(0));
    }
}
