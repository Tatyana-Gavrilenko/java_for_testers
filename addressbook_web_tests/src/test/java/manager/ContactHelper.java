package manager;

import model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contacts) {
        initContactCreation();
        fillContactForm(contacts);
        submitContactCreation();
        returnHomePage();
    }

    public void deleteContact(ContactData contacts) {
        selectContact(contacts);
        removeSelectedContact();
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openHomePage();
        selectContact(contact);
        initContactModification();
        fillNameContactForm(modifiedContact);
        submitContactModification();
        returnHomePage();
    }

    public void modifyNameEmailContact(ContactData contact, ContactData modifiedContact) {
        openHomePage();
        selectContact(contact);
        initContactModification();
        fillWithNameEmailContactForm(modifiedContact);
        submitContactModification();
        returnHomePage();
    }


    private void submitContactCreation() {
        click(By.xpath("(//input[@name=\'submit\'])[2]"));
    }

    private void initContactCreation() {
       click(By.linkText("add new"));
    }

    private void removeSelectedContact() {
        click(By.name("delete"));
    }

    public void openHomePage() {
        if (!manager.isElementPresent(By.name("selected[]"))) {
            returnHome();
        }
    }

    private void returnHomePage() {
        click(By.linkText("home page"));
    }

    private void returnHome() {
        click(By.linkText("home"));
    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("lastname"), contact.lastname());
        type(By.name("address"), contact.address());
        type(By.name("email"), contact.email());
        type(By.name("mobile"), contact.mobile());
    }

    private void fillNameContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
    }

    private void fillWithNameEmailContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("email"), contact.email());
    }

    private void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    private void selectContact(ContactData contacts) {
        click(By.cssSelector(String.format("input[value='%s']", contacts.id())));
    }

    public void deleteAllContact() {
        click(By.id("MassCB"));
        removeSelectedContact();
    }
    public int getContactCount() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        openHomePage();
        var contacts = new ArrayList<ContactData>();
        var trs = manager.driver.findElements(By.name("entry"));
        for (var tr : trs) {
            var checkbox = tr.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            var name = tr.findElement(By.cssSelector("td:nth-child(3)")).getText();
            var lastName = tr.findElement(By.cssSelector("td:nth-child(2)")).getText();
            contacts.add(new ContactData().withId(id).withName(name).withLastName(lastName));
        }
        return contacts;
    }
}