package pom;

import org.openqa.selenium.By;

public class FileUploaderPage {

    public void chooseFile(String file) {
        BaseClass.getDriver().findElement(By.id("file-upload")).sendKeys(file);
    }

    public void clickOnUpload() {
        BaseClass.getDriver().findElement(By.id("file-submit")).click();
    }

    public String getSuccessMessage() {
        return BaseClass.getDriver().findElement(By.xpath("//div[@id='content']/div/h3")).getText();
    }
}
