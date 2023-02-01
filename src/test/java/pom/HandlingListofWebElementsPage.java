package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HandlingListofWebElementsPage {

    public int checkHomePageItemsCount() {
        List<WebElement> itemList = BaseClass.getDriver().findElements(By.xpath("//*[@id=\"tbodyid\"]/div"));
        return itemList.size();
    }

    public List<WebElement> getCurrencyVisibility() {
        return BaseClass.getDriver().findElements(By.xpath("//*[@id=\"tbodyid\"]/div/div/div/h5"));
    }
}
