package test;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
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
        var oldContact = app.contact().getContactList();
        app.contact().createContact(contact);
        var newContact = app.contact().getContactList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));};
        newContact.sort(compareById);
        var expectedList = new ArrayList<>(oldContact);
        expectedList.add(contact.withId(newContact.get(newContact.size() - 1).id()));
        expectedList.sort(compareById);

        Assertions.assertEquals(newContact, expectedList);
    }
//.withName("NewContactName")
//                .withLastName("NewContactLastName")
//                .withAddress("NewContactAddress")
//                .withEmail("NewContactEmail")
//                .withMobile("NewContactMobile"));
    // .withName("")
    //            .withLastName("")
    //               .withAddress("")
    //             .withEmail("")
    //              .withMobile(""))

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
        var oldContact = app.contact().getContactList();
        app.contact().createContact(contact);
        var newContact = app.contact().getContactList();
        Assertions.assertEquals(newContact, oldContact);
    }
}