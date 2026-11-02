package test;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactDeleteTests extends TestBase {

    @Test
    public void canDeletedContact() {
        if (app.contact().getContactCount() == 0) {
            app.contact().createContact(new ContactData(
                    "",
                    "test",
                    "test2",
                    "test3",
                    "testmail",
                    "12345")
            );
        }
        var oldContacts = app.contact().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contact().deleteContact(oldContacts.get(index));
        var newContacts = app.contact().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }
//var oldContacts = app.contact().getList();
//        var rnd = new Random();
//        var index = rnd.nextInt(oldContacts.size());
//        app.contact().removeContact(oldContacts.get(index));
//        var newContacts = app.contact().getList();
//        var expectedList = new ArrayList<>(oldContacts);
//        expectedList.remove(index);
//        Assertions.assertEquals(newContacts, expectedList);

    @Test
    public void canDeleteAllContact(){
        if (app.contact().getContactCount() == 0) {
            app.contact().createContact(new ContactData("", "test", "test2", "test3", "testmail", "12345"));
            app.contact().createContact(new ContactData("", "AAAAA", "BBBBB", "CCCCC", "DDDDD", "98765x"));
        };

        app.contact().deleteAllContact();
    }
}