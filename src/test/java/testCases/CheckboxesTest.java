package testCases;

import pom.BaseClass;
import pom.CheckboxesPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckboxesTest extends BaseClass{


    CheckboxesPage checkboxesPage = new CheckboxesPage();


    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        getDriver().get("https://the-internet.herokuapp.com/checkboxes");
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
    public void checkBox() throws IOException, InterruptedException {

        //check on box 01
        Thread.sleep(3000);
        checkboxesPage.checkBox01().click();

        //validate box 02 not checked
        Thread.sleep(3000);
        if (checkboxesPage.checkBox02().isSelected()) {
            checkboxesPage.checkBox02().click();
        }

        Thread.sleep(3000);
        int numberOfCheckBoxs = checkboxesPage.numberOfCheckBoxs();
        System.out.println(numberOfCheckBoxs);

    }

}