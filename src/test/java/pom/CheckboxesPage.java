package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckboxesPage {


    public WebElement checkBox01() {
        return BaseClass.getDriver().findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
    }

    public WebElement checkBox02() {
        return BaseClass.getDriver().findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
    }

    public int numberOfCheckBoxs() {
        return BaseClass.getDriver().findElements(By.xpath("//input[@type=\"checkbox\"]")).size();
    }


}
