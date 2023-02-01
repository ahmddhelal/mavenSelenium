package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserNavigationPage {


    public void clickContactSales() {
        BaseClass.getDriver().findElement(By.xpath("//*[@id=\"entry-3qDFahnypj1KkiORyU1Zyh\"]/div" +
                "/div/div/div[1]/div/div[2]/ul/li[2]/a")).click();
    }
}
