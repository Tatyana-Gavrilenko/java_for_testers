package ru.stqa.addressbook.test;

import ru.stqa.addressbook.manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Random;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() throws IOException {
        var properties = new Properties();
        properties.load(new FileReader(System.getProperty("target", "local.properties")));
        if (app == null) {
            app = new ApplicationManager();
            app.init(System.getProperty("browser", "fireFox"), properties);
        }
    }

    public static String randomFile(String dir) {
      var fileNames = new File(dir).list(); //list вернет названия файлов,  listfile соответсвующие объекты
        var rnd = new Random();
        var index = rnd.nextInt(fileNames.length); //достаем случайное число не превыщающее количество файлов
        return Paths.get(dir, fileNames[index]).toString(); //берем путь. кот. соответ. директории и добавляем к нему путь кот соответ файлу с этим индексом, путь преобразовали в строку
    }

}
