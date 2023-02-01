package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SwitchMethodsPage {


    //////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////ALERT/////////////////////////////////////
    //JAVA SCRIPT ALERT HANDLING
    public void ClickOnJSAlert() throws InterruptedException {
        BaseClass.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
    }

    //JAVA SCRIPT ALERT HANDLING
    public void ClickOnJSConfirm() {
        BaseClass.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
    }

    //JAVA SCRIPT ALERT HANDLING
    public void ClickOnJSPrompt() {
        BaseClass.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
    }

    //JAVA SCRIPT ALERT HANDLING
    public String getJsAlertMessage() {
        return BaseClass.getDriver().findElement(By.xpath("//*[@id=\"result\"]")).getText();
    }

    //JAVA SCRIPT ALERT HANDLING
    public String getJsConfirmMessage() {
        return BaseClass.getDriver().findElement(By.xpath("//*[@id=\"result\"]")).getText();
    }

    //JAVA SCRIPT ALERT HANDLING
    public String getJsPromptMessage() {
        return BaseClass.getDriver().findElement(By.xpath("//*[@id=\"result\"]")).getText();
    }

    // NEW WINDOW HANDLING
    public void clickOnNewWindows() {
        BaseClass.getDriver().findElement(By.id("newWindowBtn")).click();
    }

    //////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////Window Handling////////////////////////////////
    public WebElement getVisitUsButton() {
        return BaseClass.getDriver().findElement(By.id("visitbutton"));
    }

}
