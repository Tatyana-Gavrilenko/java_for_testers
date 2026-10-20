package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnHomePage();
    }

    public void deleteContact() {
        selectContact();
        removeSelectedContact();
    }

    public void modifyContact(ContactData modifiedContact) {
        openHomePage();
        selectContact();
        initContactModification();
        fillNameContactForm(modifiedContact);
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

    private void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteAllContact() {
        click(By.id("MassCB"));
        removeSelectedContact();
    }
}
