package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTablesPage {

    public WebElement getTable01() {
        return BaseClass.getDriver().findElement(By.id("table1"));
    }

    public WebElement getTable02() {
        return BaseClass.getDriver().findElement(By.id("table2"));
    }

    //return list of table's rows
    public List<WebElement> getRows(WebElement table) {
        return table.findElements(By.tagName("tr"));
    }

    //return list of columns for each row
    public List<WebElement> getColumns (WebElement row) {
        return row.findElements(By.tagName("td"));
    }

}
