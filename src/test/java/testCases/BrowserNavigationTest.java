package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v106.indexeddb.model.Key;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom.BaseClass;
import pom.BrokenImagesPage;
import pom.BrowserNavigationPage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class BrowserNavigationTest extends BaseClass{


        BrowserNavigationPage browserNavigationPage = new BrowserNavigationPage();
        Robot robot = new Robot();

    public BrowserNavigationTest() throws AWTException {
    }

    @BeforeMethod
        public void beforeMethod() throws InterruptedException {
            getDriver().get("https://saucelabs.com/");
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
        public void navigation() throws IOException, InterruptedException {
            browserNavigationPage.clickContactSales();
            Thread.sleep(3000);
            getDriver().navigate().refresh();
            getDriver().navigate().back();
            getDriver().navigate().forward();
            Thread.sleep(3000);
            robot.keyPress(KeyEvent.VK_F5);
        }



}
