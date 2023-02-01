package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LumaHomePage {

    public WebElement radiantTeeBlueColor() {
        return BaseClass.getDriver().findElement(By.id("option-label-color-93-item-50"));
    }

    public WebElement radiantTeeOrangeColor() {
        return BaseClass.getDriver().findElement(By.id("option-label-color-93-item-56"));
    }
}
