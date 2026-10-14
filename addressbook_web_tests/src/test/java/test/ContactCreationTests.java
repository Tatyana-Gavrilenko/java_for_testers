package test;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        app.createContact(new ContactData("Tanya", "Gavr", "NSK", "89230000000"));
    }

    @Test
    public void canCreateContactEmptyName() {
        app.openHomePage();
        var emptyContact = new ContactData();
        var contactWithName = emptyContact.withName("some name");
        app.createContact(contactWithName);
    }

    @Test
    public void canCreateContactEmptyMobile() {
        app.openHomePage();
        var emptyContact = new ContactData();
        var contactWithMobile = emptyContact.withMobile("12345");
        app.createContact(contactWithMobile);
    }
}
