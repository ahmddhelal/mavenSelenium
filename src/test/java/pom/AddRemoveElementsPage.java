package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddRemoveElementsPage {

    public void addElement() {
        BaseClass.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
    }


    public void deleteElement() {
        BaseClass.getDriver().findElement(By.xpath("//*[@id=\"elements\"]/button")).click();
    }

    public boolean isDeleteButtonDisplayed() {
        return deleteButton().isDisplayed();
    }

    public WebElement deleteButton() {
        return BaseClass.getDriver().findElement(By.id("elements")) ;
    }
}
