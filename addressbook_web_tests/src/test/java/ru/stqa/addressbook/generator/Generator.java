package ru.stqa.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import ru.stqa.addressbook.common.CommonFuctions;
import ru.stqa.addressbook.model.GroupData;

import javax.swing.*;
import java.util.ArrayList;


public class Generator {

    @Parameter(names = {"--type", "-t"})
    String type;

    @Parameter(names = {"--output", "-o"})
    String output;

    @Parameter(names = {"--format", "-f"})
    String format;

    @Parameter(names = {"--count", "-n"})
    int count;

    public static void main(String[] args) {
        var generator = new Generator(); //создаем генератор и помещает его в переменную
        JCommander.newBuilder() //код анализирующий опции командной строки
                .addObject(generator)//создается парсер командной строки, который анализирует параметры описанные в объекте generator, а потом на вход парсеру передается аргументы
                .build()
                .parse(args);
        generator.run(); //в генераторе запускаем метод run, в generator будут прописаны в соответ свойствах те значения, который передан в параметрах
    }

    private void run() {
        var data = generate(); //создание данных
        save(data); //сохранение данных

    }

    private Object generate() {
        if ("groups".equals(type)) {
            return generateGroups();
        } else if ("contacts".equals(type)) {
            return generateContacts();
        } else {
            throw new IllegalArgumentException("Неизвестный тип данных" + type);
        }
    }

    private Object generateGroups() {
        var result = new ArrayList<GroupData>(); //создаем список объектов типа groupData
        for (int i = 0; i < count; i++) {
            result.add(new GroupData()
                    .withName(CommonFuctions.randomString(i * 10))
                    .withHeader(CommonFuctions.randomString(i * 10))
                    .withFooter(CommonFuctions.randomString(i * 10))
            ); //цикл до count, генерит объекты типа groupData, и добавляем их в список
        }
        return result;
    }

    private Object generateContacts() {
        return null;
    }

    private void save(Object data) {
    }
}
