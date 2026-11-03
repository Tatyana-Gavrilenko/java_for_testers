package test;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase{

    @Test
    void canModifyNameContact() {
        if (app.contact().getContactCount() == 0) {
            app.contact().createContact(new ContactData("", "test", "test2", "test3", "testmail","12345"));
        }
        var oldContact = app.contact().getContactList(); //старый список контактов
        var rnd = new Random();
        var index = rnd.nextInt(oldContact.size());
        var testDataContact = new ContactData().withName("NameNameName");
        app.contact().modifyContact(oldContact.get(index), testDataContact);
        var newContact = app.contact().getContactList();
        var expectedList = new ArrayList<>(oldContact);
        expectedList.set(index, testDataContact.withId(oldContact.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));};
        newContact.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContact, expectedList);
    }

    @Test //не могу отладить, в ui меняется имя и почта, а в проверке не совпадают списки
    void canModifywithNameEmailContact() {
        if (app.contact().getContactCount() == 0) {
            app.contact().createContact(new ContactData("", "test", "test2", "test3", "testmail","12345"));
        }
        var oldContact = app.contact().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContact.size());
        var testDataContact1 = new ContactData()
                .withNameEmail("ModifyName", "ModifyEmail");
        app.contact().modifyNameEmailContact(oldContact.get(index), testDataContact1);
        var newContact = app.contact().getContactList();
        var expectedList = new ArrayList<>(oldContact);
        expectedList.set(index, testDataContact1.withId(oldContact.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));};
        newContact.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContact, expectedList);
    }
}