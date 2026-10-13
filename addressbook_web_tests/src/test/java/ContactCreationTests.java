import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        createContact(new ContactData("test", "test2", "test3", "12345"));
    }

    @Test
    public void canCreateContactEmptyName() {
        openHomePage();
        var emptyContact = new ContactData();
        var contactWithName = emptyContact.withName("some name");
        createContact(contactWithName);
    }
}
