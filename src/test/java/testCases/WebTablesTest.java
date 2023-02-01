package testCases;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom.BaseClass;
import pom.WebTablesPage;

import java.io.IOException;


public class WebTablesTest extends BaseClass {

    WebTablesPage webTablesPage = new WebTablesPage();

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        getDriver().get("https://the-internet.herokuapp.com/tables");
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
    public void testWebElement() throws IOException, InterruptedException {

        WebElement table01 = webTablesPage.getTable01();

        /////////////////////webTablesPage.getRows(table01) returns list of table's rows
        for (WebElement row: webTablesPage.getRows(table01)) {

            //////////////////////webTablesPage.getColumns(row) returns list of columns for each row
            for (WebElement col : webTablesPage.getColumns(row)) {
                System.out.print(col.getText()+"\t");
            }
            System.out.println();
        }
    }

}
