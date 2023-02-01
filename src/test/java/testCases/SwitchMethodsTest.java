package testCases;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import pom.BaseClass;
import pom.SwitchMethodsPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchMethodsTest extends BaseClass {


    SwitchMethodsPage switchMethodsPage = new SwitchMethodsPage();
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







    //////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////ALERT/////////////////////////////////////

    @Test
    //JAVA SCRIPT ALERT HANDLING SIMPLE ALERT
    public void JSAlert() throws InterruptedException {
        getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
        switchMethodsPage.ClickOnJSAlert();
        getDriver().switchTo().alert().accept();
        //Assertion
        Assert.assertTrue(switchMethodsPage.getJsAlertMessage().contains("alert"));
    }

    @Test
    //JAVA SCRIPT ALERT HANDLING OK/CANCEL ALERT WITHOUT TEXT BOX
    public void JSConfirmAccept() {
        getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
        switchMethodsPage.ClickOnJSConfirm();
        getDriver().switchTo().alert().accept();
        //Assertion
        Assert.assertTrue(switchMethodsPage.getJsConfirmMessage().contains("Ok"));
    }

    @Test
    //JAVA SCRIPT ALERT HANDLING OK/CANCEL ALERT WITHOUT TEXT BOX
    public void JSConfirmCancel() throws InterruptedException {
        getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
        switchMethodsPage.ClickOnJSConfirm();
        getDriver().switchTo().alert().dismiss();
        //Assertion
        Assert.assertTrue(switchMethodsPage.getJsConfirmMessage().contains("Cancel"));
    }

    @Test
    //JAVA SCRIPT ALERT HANDLING PROMPT ALERT WIT TEXT BOX
    public void JSPromptSendText() {
        getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
        switchMethodsPage.ClickOnJSPrompt();
        getDriver().switchTo().alert().sendKeys("JS prompt");
        getDriver().switchTo().alert().accept();
        //Assertion
        Assert.assertTrue(switchMethodsPage.getJsPromptMessage().contains("entered"));
    }

    @Test
    //JAVA SCRIPT ALERT HANDLING PROMPT ALERT WIT TEXT BOX
    public void JSPromptCancel() {
        getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
        switchMethodsPage.ClickOnJSPrompt();
        getDriver().switchTo().alert().dismiss();
        //Assertion
        Assert.assertTrue(switchMethodsPage.getJsPromptMessage().contains("null"));
    }









    //////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////Window Handling////////////////////////////////

    @Test
    // NEW WINDOW HANDLING BY HANDLE
    public void newWindowByHandle() throws InterruptedException {
        getDriver().get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        //get parentWindowId window id
        String parentWindowId = getDriver().getWindowHandle();

        switchMethodsPage.clickOnNewWindows();

        //to pick the child window and deal with it
        for (String windowId: getDriver().getWindowHandles()) {
            if (!windowId.equals(parentWindowId)) {
                getDriver().switchTo().window(windowId);
                getDriver().findElement(By.id("firstName")).sendKeys("child window");
                Assert.assertEquals("Basic Controls - H Y R Tutorials", getDriver().getTitle(), "Child");
                System.out.println("From Child Window "+getDriver().getTitle());
                Thread.sleep(4000);
                getDriver().close();
            }
        }


        //to pick the parent window and deal with it
        getDriver().switchTo().window(parentWindowId);
        Assert.assertEquals("Window Handles Practice - H Y R Tutorials", getDriver().getTitle(), "Parent");
        System.out.println("From Parent Window "+getDriver().getTitle());
        getDriver().findElement(By.id("name")).sendKeys("parent window");
        Thread.sleep(4000);

    }

    @Test
    // NEW WINDOW HANDLING BY NAME
    public void newWindowByName() throws InterruptedException {
        getDriver().get("http://cookbook.seleniumacademy.com/Config.html");

        //get parent window id
        String parentWindowId = getDriver().getWindowHandle();

        switchMethodsPage.getVisitUsButton().click();

        //to pick the child window and deal with it
        getDriver().switchTo().window("VisitUsWindow");
        String childText = getDriver().findElement(By.xpath("/html/body/div/p")).getText();
        System.out.println(childText);
        Assert.assertTrue(childText.contains("Online Configuration"));
        System.out.println("From Child Window this is title ::: "+getDriver().getTitle());
        Thread.sleep(4000);
        getDriver().close();


        //to pick the parent window and deal with it
        getDriver().switchTo().window(parentWindowId);
        Assert.assertEquals("Build my Car - Configuration", getDriver().getTitle(), "Parent");
        System.out.println("From Parent Window this is title ::: "+getDriver().getTitle());
        Thread.sleep(4000);
    }









    //////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////FRAMES/////////////////////////////////////
    @Test
    //SWITCH TO FRAME BY NAME
    public void switchFrameByName() {

        getDriver().get("http://cookbook.seleniumacademy.com/Frames.html");

        getDriver().switchTo().frame("right");
        String text = getDriver().findElement(By.tagName("p")).getText();
        System.out.println("Got by name ::: "+text);

        softAssert.assertEquals(text,"This is Right Frame");
        softAssert.assertAll();

        //an important step to be able to interact with elements out of frame
        getDriver().switchTo().defaultContent();
    }

    @Test
    //SWITCH TO FRAME BY ID
    public void switchFrameById() {

        getDriver().get("http://cookbook.seleniumacademy.com/Frames.html");

        getDriver().switchTo().frame("left");
        String text = getDriver().findElement(By.tagName("p")).getText();
        System.out.println("Got by id ::: "+text);

        softAssert.assertEquals(text,"This is Left Frame");
        softAssert.assertAll();

        //an important step to be able to interact with elements out of frame
        getDriver().switchTo().defaultContent();
    }

    @Test
    //SWITCH TO FRAME BY INDEX
    public void switchFrameByIndex() {

        getDriver().get("http://cookbook.seleniumacademy.com/Frames.html");

        getDriver().switchTo().frame(1);
        String text = getDriver().findElement(By.tagName("p")).getText();
        System.out.println("Got by index ::: "+text);

        softAssert.assertEquals(text,"This Frame doesn't have id or name");
        softAssert.assertAll();

        //an important step to be able to interact with elements out of frame
        getDriver().switchTo().defaultContent();
    }

}
