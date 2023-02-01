package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pom.BaseClass;
import pom.HandlingListofWebElementsPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandlingListofWebElementsTest extends BaseClass{

    HandlingListofWebElementsPage handlingListofWebElementsPage = new HandlingListofWebElementsPage();
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        getDriver().get("https://www.demoblaze.com/");
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
    public void checkItems() {
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //very important step
        int numOfItems = handlingListofWebElementsPage.checkHomePageItemsCount();
        softAssert.assertEquals(numOfItems,9);
        System.out.println("Number of items on this page ::: "+numOfItems);
        List<WebElement> itemList = handlingListofWebElementsPage.getCurrencyVisibility();
        for (WebElement element : itemList) {
            softAssert.assertTrue(element.isDisplayed());
            System.out.println("Currency item ::: "+element.getText());
        }
        System.out.println("Number of currency items on this page ::: "+itemList.size());
    }
}