package testCases;

import pom.BaseClass;
import pom.JQueryUiMenuPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JQueryUiMenuTest extends BaseClass {


    JQueryUiMenuPage jQueryUiMenuPage = new JQueryUiMenuPage();


    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        getDriver().get("https://the-internet.herokuapp.com/jqueryui/menu#");
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
    public void selectCSV() throws InterruptedException {
        jQueryUiMenuPage.selectFile("CSV");
        //Assertion
        jQueryUiMenuPage.assertionForDownload("CSV");
    }

    @Test
    public void selectExcel() throws InterruptedException {
        jQueryUiMenuPage.selectFile("Excel");
        //Assertion
        jQueryUiMenuPage.assertionForDownload("Excel");
    }

    @Test
    public void selectPDF() throws InterruptedException {
        jQueryUiMenuPage.selectFile("PDF");
        //Assertion
        jQueryUiMenuPage.assertionForDownload("PDF");
    }
}
