package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;
import ru.stqa.addressbook.test.TestBase;

import java.nio.file.Paths;

public class HelperBase extends TestBase {

    protected final ApplicationManager manager;

    public HelperBase(ApplicationManager Manager) {
        this.manager = Manager;
    }

    protected void type(By locator, String text) {
        click(locator);
        manager.driver.findElement(locator).clear();
        manager.driver.findElement(locator).sendKeys(text);
    }

    protected void attach(By locator, String file) {
        manager.driver.findElement(locator).sendKeys(Paths.get(file).toAbsolutePath().toString());
    }

    protected void click(By locator) {
        manager.driver.findElement(locator).click();
    }
}
