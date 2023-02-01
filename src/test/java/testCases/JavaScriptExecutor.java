package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pom.BaseClass;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class JavaScriptExecutor extends BaseClass {


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
    //GET PAGE TITLE
    public void javaScriptExecutorGetTitle() {

        getDriver().get("https://www.google.com");

        //down casting done because WebDriver is superclass for subclass javascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        //within script, we can execute any js code
        String title = (String) js.executeScript("return document.title");

        softAssert.assertEquals(title, "Google");
        System.out.println(title);

        softAssert.assertAll();
    }

    @Test
    //GET NUMBER OF LINKS
    public void javaScriptExecutorGetNumOfLinks() {

        getDriver().get("https://www.google.com");

        //down casting done because WebDriver is superclass for subclass javascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        //within script, we can execute any js code
        long links = (long) js.executeScript("var lnk = document.getElementsByTagName('A'); return lnk.length");
        System.out.println(links);

        softAssert.assertAll();
    }


    @Test
    //SCROLL TO ELEMENT
    public void javaScriptExecutorScrollingToElement() throws InterruptedException, AWTException {

        getDriver().get("https://magento.softwaretestingboard.com/");
        WebElement babySection = getDriver().findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol"));

        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", babySection);

        Thread.sleep(3000);

    }

    @Test
    //SCROLL BY AXES
    public void javaScriptExecutorScrollingByAxes() throws InterruptedException, AWTException {

        getDriver().get("https://magento.softwaretestingboard.com/");

        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("scrollBy(0, 3000)");

        Thread.sleep(3000);

    }

}
