package test;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;


public class ContactCreationTests extends TestBase {
    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "firstname")) {
            for (var lastname : List.of("", "lastname")) {
                for (var address : List.of("", "address")) {
                    for (var email : List.of("", "email")) {
                        for (var mobile : List.of("", "mobile")) {
                            result.add(new ContactData()
                                    .withName(firstname)
                                    .withLastName(lastname)
                                    .withAddress(address)
                                    .withEmail(email)
                                    .withMobile(mobile));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData()
                            .withName(randomString(i * 10))
                            .withLastName(randomString(i * 10))
                            .withAddress(randomString(i * 10))
                            .withEmail(randomString(i * 10))
                            .withMobile(randomString(i * 10)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateContact(ContactData contact) {
        int contactData = app.contact().getContactCount();
        app.contact().createContact(contact);
        int newContactCount = app.contact().getContactCount();
        Assertions.assertEquals(contactData + 1, newContactCount);
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData(
                        "",
                        "Name'",
                        "",
                        "",
                        "",
                        "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactData contact) {
        int contactData = app.contact().getContactCount();
        app.contact().createContact(contact);
        int newContactCount = app.contact().getContactCount();
        Assertions.assertEquals(contactData, newContactCount);
    }
}
