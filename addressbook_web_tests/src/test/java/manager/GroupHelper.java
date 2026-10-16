package manager;

import model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper {

    private final ApplicationManager manager;

    public GroupHelper(ApplicationManager Manager) {
        this.manager = Manager;
    }

    public void createGroup(GroupData group) {
        openGroupsPage();
        initGroupCreation();
        fillGroupModification(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    public void removeGroup() {;
        openGroupsPage();
        selectGroup();
        removedSelectedGroup();
        returnToGroupPage();
    }

    public void modifyGroup(GroupData modifiedGroup) {
        openGroupsPage();
        selectGroup();
        initGroupModifation();
        fillGroupModification(modifiedGroup);
        submitGroupModification();
        returnToGroupPage();
    }

    public void openGroupsPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }

    public boolean isGroupPresent() {
        openGroupsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    private void submitGroupCreation() {
        click(By.name("submit"));
    }

    private void initGroupCreation() {
        click(By.name("new"));
    }

    private void removedSelectedGroup() {
        click(By.name("delete"));
    }

    private void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    private void submitGroupModification() {
        click(By.name("update"));
    }

    private void fillGroupModification(GroupData group) {
        type(By.name("group_name"), group.name());
        type(By.name("group_header"), group.header());
        type(By.name("group_footer"), group.footer());
    }

    private void type(By locator, String text) {
        click(locator);
        manager.driver.findElement(locator).clear();
        manager.driver.findElement(locator).sendKeys(text);
    }

    private void initGroupModifation() {
        click(By.name("edit"));
    }

    private void selectGroup() {
        click(By.name("selected[]"));
    }

    private void click(By locator) {
        manager.driver.findElement(locator).click();
    }
}
