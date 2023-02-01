package testCases;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pom.BaseClass;
import pom.LumaHomePage;
import pom.LumaSignInPage;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitsTest extends BaseClass {


    LumaSignInPage lumaSignInPage = new LumaSignInPage();
    LumaHomePage lumaHomePage = new LumaHomePage();
    SoftAssert softAssert = new SoftAssert();


    @BeforeMethod
    public void beforeMethod() throws InterruptedException {

    }

    @AfterMethod
    public void afterMethod() {
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
    //IMPLICIT WAIT
    public void implicitWait() throws IOException, InterruptedException {

        getDriver().get("https://magento.softwaretestingboard.com/customer/account/login");

        lumaSignInPage.emailTxtBox().sendKeys("tommy@gmail.com");
        lumaSignInPage.passWordTxtBox().sendKeys("123");
        lumaSignInPage.signInButton().click();

        //try to comment the wait line to fail the test
//        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String errorMsg = lumaSignInPage.errorMsg().getText();
        softAssert.assertTrue(errorMsg.contains("incorrect"));
        softAssert.assertAll();

    }

    @Test
    //EXPLICIT WAIT BY VISIBILITY
    public void explicitWaitByVisibility() throws IOException, InterruptedException {
        getDriver().get("https://magento.softwaretestingboard.com/customer/account/login");

        lumaSignInPage.emailTxtBox().sendKeys("tommy@gmail.com");
        lumaSignInPage.passWordTxtBox().sendKeys("123");
        lumaSignInPage.signInButton().click();

        //try to comment the wait line to fail the test
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(lumaSignInPage.errorMsg())) ;

        String errorMsg = lumaSignInPage.errorMsg().getText();
        softAssert.assertTrue(errorMsg.contains("Incorrect"));
        softAssert.assertAll();

    }

    @Test
    //EXPLICIT WAIT BY ATTRIBUTE VALUE
    public void explicitWaitByAttributeValue() throws IOException, InterruptedException {
        getDriver().get("https://magento.softwaretestingboard.com/");

        Thread.sleep(5000);

        //blue color is selected
        lumaHomePage.radiantTeeBlueColor().click();

        Thread.sleep(5000);

        //wait for 60 secs or for orange selection
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.attributeContains(lumaHomePage.radiantTeeOrangeColor(), "class", "selected"));

    }

}
