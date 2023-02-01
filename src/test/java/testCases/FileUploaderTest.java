package testCases;

import pom.BaseClass;
import pom.FileUploaderPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploaderTest extends BaseClass {


    FileUploaderPage fileUploaderPage = new FileUploaderPage();



    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        getDriver().get("https://the-internet.herokuapp.com/upload");
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
    public void uploadPhoto() throws InterruptedException {
        fileUploaderPage.chooseFile("C:\\Users\\HELAL's\\Desktop\\Selenium Img.jpg");
        fileUploaderPage.clickOnUpload();
        String successMessage = fileUploaderPage.getSuccessMessage();
        Thread.sleep(3000);
        Assert.assertTrue(successMessage.contains("Uploaded!"));
    }
}
