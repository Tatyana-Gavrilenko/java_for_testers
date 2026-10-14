import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        createContact(new ContactData("Tanya", "Gavr", "NSK", "89230000000"));
    }

    @Test
    public void canCreateContactEmptyName() {
        openHomePage();
        var emptyContact = new ContactData();
        var contactWithName = emptyContact.withName("some name");
        createContact(contactWithName);
    }

    @Test
    public void canCreateContactEmptyMobile() {
        openHomePage();
        var emptyContact = new ContactData();
        var contactWithMobile = emptyContact.withMobile("12345");
        createContact(contactWithMobile);
    }
}
