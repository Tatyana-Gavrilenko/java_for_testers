package test;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
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
                                    .withMobile(mobile))
                            ;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData()
                    .withName(randomString(i * 5))
                    .withLastName(randomString(i * 5))
                    .withAddress(randomString(i * 5))
                    .withEmail(randomString(i * 5))
                    .withMobile(randomString(i * 5)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void CanCreateMultipleContacts(ContactData contact) {
        var oldContacts = app.contact().getContactList();
        app.contact().createContact(contact);
        var newContacts = app.contact().getContactList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size() - 1).id()));
        expectedList.sort(compareById);

        Assertions.assertEquals(newContacts, expectedList);
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData(
                        "",
                        "Name'",
                        "",
                        "",
                        "",
                        "",
                        "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactData contact) {
        var oldContact = app.contact().getContactList();
        app.contact().createContact(contact);
        var newContact = app.contact().getContactList();
        Assertions.assertEquals(newContact, oldContact);
    }

    @Test
    public void canCreateContact() {
        var contact = new ContactData()
                .withName(randomString(5))
                .withLastName(randomString(5))
                .withPhoto(randomFile("src/test/resources/images"));
        app.contact().createContact(contact);
    }
}