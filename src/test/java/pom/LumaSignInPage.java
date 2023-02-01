package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LumaSignInPage {

    public WebElement emailTxtBox() {
        return BaseClass.getDriver().findElement(By.id("email"));
    }

    public WebElement passWordTxtBox() {
        return BaseClass.getDriver().findElement(By.id("pass"));
    }

    public WebElement signInButton() {
        return BaseClass.getDriver().findElement(By.id("send2"));
    }

    public WebElement errorMsg() {
        return BaseClass.getDriver().findElement(By.xpath("//*[@data-ui-id=\"message-error\"]"));
    }
}
