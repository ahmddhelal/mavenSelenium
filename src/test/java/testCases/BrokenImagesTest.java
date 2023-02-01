package testCases;

import pom.BaseClass;
import pom.BrokenImagesPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class BrokenImagesTest extends BaseClass {


    BrokenImagesPage brokenImagesPage = new BrokenImagesPage();

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        getDriver().get("https://the-internet.herokuapp.com/broken_images");
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
    public void brokenImage() throws IOException {
        brokenImagesPage.getBrokenImgs();

    }

}
