package test;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class GroupModificationTests extends TestBase {

    @Test
    void canModifyGroup() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var oldGroups = app.groups().getList(); //старый список
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());//радномный выбор индекса из списка групп
        var testData = new GroupData().withName("modified name");
        app.groups().modifyGroup(oldGroups.get(index), testData); //редактирование старого объекта списка(под индексом рандом от 0 до oldGroups.size()) на новый объект список
        var newGroups = app.groups().getList(); //загрузка нового списка групп
        var expectedList = new ArrayList<>(oldGroups); //старый список
        expectedList.set(index, testData.withId(oldGroups.get(index).id())); //заменяем в старом списке один объект
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };//упорядочивание двух списков по id
        newGroups.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups, expectedList);
    }
}
