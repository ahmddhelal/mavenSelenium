package testCases;

import pom.BaseClass;
import pom.FileDownloaderPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;

public class FileDownloaderTest extends BaseClass {

    FileDownloaderPage fileDownloaderPage = new FileDownloaderPage();
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        getDriver().get("https://the-internet.herokuapp.com/download");
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
    public void downloadFile() throws InterruptedException {
        fileDownloaderPage.clickOnCypressLogo();
        Thread.sleep(6000);
        File file = new File("C:\\Users\\HELAL's\\Downloads\\cypressLogo.png") ;
        softAssert.assertTrue(file.exists());
        softAssert.assertAll();
    }
}
