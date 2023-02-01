package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownListPage {


    public Select selection() {
        WebElement ddl = BaseClass.getDriver().findElement(By.id("dropdown"));
        Select select = new Select(ddl);
        return  select;
    }


    public void selectFromDDLByVisibleTxt(String option) {
        selection().selectByVisibleText(option);
    }

    public void selectFromDDLByIndex(int index) {
        selection().selectByIndex(index);
    }

    public void selectFromDDLByValue(String value) {
        selection().selectByValue(value);
    }
}
