package testCases;

import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import pom.BaseClass;
import pom.ActionClassPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionClassTest extends BaseClass {


    ActionClassPage actionClassPage = new ActionClassPage();
    SoftAssert softAssert = new SoftAssert();



    @BeforeMethod
    public void beforeMethod() throws InterruptedException {

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
    //HOVER MOUSE
    public void hoverToUser01() throws InterruptedException {

        getDriver().get("https://the-internet.herokuapp.com/hovers");
        Thread.sleep(3000);
        actionClassPage.user01();
        Actions actions = new Actions(getDriver()) ;
        actions.moveToElement(actionClassPage.user01()).perform();
        Thread.sleep(3000);
        actionClassPage.viewProfileUser01().click();
        Thread.sleep(3000);
        String URL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertTrue(URL.contains("users/1"));
    }


    @Test
    //DOUBLE CLICK
    public void doubleClick() throws InterruptedException {

        getDriver().get("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");

        Actions actions = new Actions(getDriver());
        actions.doubleClick(actionClassPage.getDoubleClickEle()).perform();

        String color = actionClassPage.getDoubleClickEle().getCssValue("background");
        softAssert.assertEquals("rgba(255, 255, 0, 1)", color);
    }

    @Test
    //DRAG AND DROP
    public void dragAndDrop() throws InterruptedException {

        getDriver().get("http://cookbook.seleniumacademy.com/DragDropDemo.html");

        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        Actions actions = new Actions(getDriver());
        actions.dragAndDrop(actionClassPage.source(), actionClassPage.target()).build().perform();

        Thread.sleep(4000);

        softAssert.assertEquals(actionClassPage.target().getText(), "Dropped!");
        System.out.println(actionClassPage.target().getText());
        softAssert.assertAll();
    }
}
