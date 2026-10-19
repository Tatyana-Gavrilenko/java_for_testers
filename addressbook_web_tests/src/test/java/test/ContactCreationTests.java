package test;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        app.contact().createContact(new ContactData("Tanya", "Gavr", "NSK", "tanya@mail.ru","89230000000"));
    }

    @Test
    public void canCreateContactEmptyName() {
        app.contact().openHomePage();
        app.contact().createContact(new ContactData().withName("some name"));
    }

    @Test
    public void canCreateContactEmptyMobile() {
        app.contact().openHomePage();
        app.contact().createContact(new ContactData().withMobile("12345"));
    }
}
