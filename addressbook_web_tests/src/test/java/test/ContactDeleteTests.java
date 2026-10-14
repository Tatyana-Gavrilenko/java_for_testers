package test;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactDeleteTests extends TestBase {

    @Test
    public void canDeletedContact() {
        app.openHomePage();
        app.createContact(new ContactData("test", "test2", "test3", "12345"));
        app.deleteContact();
    }
}