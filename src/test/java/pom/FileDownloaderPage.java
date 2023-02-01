package pom;

import org.openqa.selenium.By;

public class FileDownloaderPage {
    public void clickOnCypressLogo() {
        BaseClass.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/a[2]")).click();
    }
}
