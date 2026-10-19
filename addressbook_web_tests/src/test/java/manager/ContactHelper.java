package manager;

import model.ContactData;
import org.openqa.selenium.By;
import test.TestBase;

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
        fillContactForm(modifiedContact);
        submitContactModification();
        returnHomePage();
    }

    private void submitContactCreation() {
        click(By.xpath("(//input[@name=\'submit\'])[2]"));
    }

    private void initContactCreation() {
       // click(By.name("add new"));
        manager.driver.findElement(By.linkText("add new")).click();
    }

    private void removeSelectedContact() {
        click(By.name("delete"));
    }

    public void openHomePage() {
        if (!manager.isElementPresent(By.name("selected[]"))) {
            returnHomePage();
        }
    }

    private void returnHomePage() {
        click(By.linkText("home page"));
    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("lastname"), contact.firstname());
        type(By.name("address"), contact.firstname());
        type(By.name("email"), contact.firstname());
        type(By.name("mobile"), contact.firstname());
    }

    private void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
        //xpath=//img[@alt='Edit']
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }
}
