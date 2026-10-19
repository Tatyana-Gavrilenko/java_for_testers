package test;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactDeleteTests extends TestBase {

    @Test
    public void canDeletedContact() {
        app.contact().openHomePage();
        app.contact().createContact(new ContactData("test", "test2", "test3", "testmail","12345"));
        app.contact().deleteContact();
    }
}