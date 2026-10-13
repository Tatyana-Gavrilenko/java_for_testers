import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactDeleteTests extends TestBase {

    @Test
    public void canDeletedContact() {
        openHomePage();
        createContact(new ContactData("test", "test2", "test3", "12345"));
        deleteContact();
    }
}