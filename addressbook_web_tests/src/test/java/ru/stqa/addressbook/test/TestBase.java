package ru.stqa.addressbook.test;

import ru.stqa.addressbook.manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.nio.file.Paths;
import java.util.Random;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
            app.init(System.getProperty("browser", "fireFox"));
        }
    }

    public static String randomFile(String dir) {
      var fileNames = new File(dir).list(); //list вернет названия файлов,  listfile соответсвующие объекты
        var rnd = new Random();
        var index = rnd.nextInt(fileNames.length); //достаем случайное число не превыщающее количество файлов
        return Paths.get(dir, fileNames[index]).toString(); //берем путь. кот. соответ. директории и добавляем к нему путь кот соответ файлу с этим индексом, путь преобразовали в строку


    }

}
