package test;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase{

    @Test
    void canModifyContact() {
        app.contact().openHomePage();
        app.contact().createContact(new ContactData("test", "test2", "test3", "testmail","12345"));
        app.contact().modifyContact(new ContactData().withName("NameNameName"));

    }
}
