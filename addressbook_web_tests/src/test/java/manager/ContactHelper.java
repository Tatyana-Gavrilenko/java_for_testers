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

    public void modifyContact(ContactData contacts, ContactData modifiedContact) {
       // openHomePage();
        initContactModification(contacts);
        fillNameContactForm(modifiedContact);
        submitContactModification();
        returnHomePage();
    }

    public void modifyNameEmailContact(ContactData contacts, ContactData modifiedContact) {
        initContactModification(contacts);
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

    private void fillContactForm(ContactData contacts) {
        type(By.name("firstname"), contacts.firstname());
        type(By.name("lastname"), contacts.lastname());
        type(By.name("address"), contacts.address());
        type(By.name("email"), contacts.email());
        type(By.name("mobile"), contacts.mobile());
    }

    private void fillNameContactForm(ContactData contacts) {
        type(By.name("firstname"), contacts.firstname());
        type(By.name("lastname"), contacts.lastname());
        type(By.name("email"), contacts.email());

    }

    private void fillWithNameEmailContactForm(ContactData contacts) {
        type(By.name("firstname"), contacts.firstname());
        type(By.name("email"), contacts.email());
    }

    private void initContactModification(ContactData contacts) {
        //click(By.xpath("//img[@alt='Edit']"));
        click(By.cssSelector(String.format("a[href='edit.php?id=%s']", contacts.id())));

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
            var lastname = tr.findElement(By.cssSelector("td:nth-child(2)")).getText();
            var email = tr.findElement(By.cssSelector("a[href^='mailto:']")).getAttribute("href").replace("mailto:", "");
            contacts.add(new ContactData().withId(id).withName(name).withLastName(lastname).withEmail(email));
        }
        return contacts;
    }
}