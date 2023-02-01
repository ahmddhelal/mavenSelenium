package testCases;

import pom.AddRemoveElementsPage;
import pom.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AddRemoveElementsTest extends BaseClass {


    AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage();
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        getDriver().get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    @BeforeTest
    public void beforeTest() {
        setup();
    }

    @AfterTest
    public void afterTest() {
        quit();
    }


    @Test
    public void addElement() {
        addRemoveElementsPage.addElement();
        List<WebElement> deleteButtonList = getDriver().findElements(By.id("elements"));
        softAssert.assertFalse(deleteButtonList.isEmpty());
    }


    @Test
    public void deleteElement() throws InterruptedException {
        addRemoveElementsPage.addElement();
        addRemoveElementsPage.deleteElement();
        Thread.sleep(3000);
        List<WebElement> deleteButtonList = getDriver().findElements(By.id("elements"));
        softAssert.assertTrue(deleteButtonList.isEmpty());
    }


}
