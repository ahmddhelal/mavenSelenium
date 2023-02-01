package testCases;

import org.testng.asserts.SoftAssert;
import pom.BaseClass;
import pom.DropdownListPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropdownListTest extends BaseClass {


    DropdownListPage dropdownListPage = new DropdownListPage();
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        getDriver().get("https://the-internet.herokuapp.com/dropdown");
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
    public void selectFromDDL() throws InterruptedException {

        //select from DDL using visible text
        dropdownListPage.selectFromDDLByVisibleTxt("Option 1");
        Thread.sleep(4000);

        //select from DDL using value
        dropdownListPage.selectFromDDLByValue("1");
        Thread.sleep(4000);

        //select from DDL using index
        dropdownListPage.selectFromDDLByIndex(2);
        Thread.sleep(4000);

        //validate on selected option
        softAssert.assertEquals("Option 2", dropdownListPage.selection().getFirstSelectedOption().getText());

        //validate that DDL don't provide multiple selections of options
        softAssert.assertFalse(dropdownListPage.selection().isMultiple());

        //validate that DDL the No. of options is equal 3
        softAssert.assertEquals(3, dropdownListPage.selection().getOptions().size());

    }

}
