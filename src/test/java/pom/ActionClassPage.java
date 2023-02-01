package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ActionClassPage {


    //HOVER MOUSE
    public WebElement user01() {
        return BaseClass.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));

    }

    //HOVER MOUSE
    public WebElement viewProfileUser01() {
        return BaseClass.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a"));
    }

    //DOUBLE CLICK
    public WebElement getDoubleClickEle() {
        return BaseClass.getDriver().findElement(By.id("message"));
    }


    //DRAG AND DROP
    public WebElement source() {
        return BaseClass.getDriver().findElement(By.xpath("//*[@id=\"draggable\"]/p"));
    }

    //DRAG AND DROP
    public WebElement target() {
        return BaseClass.getDriver().findElement(By.xpath("//*[@id=\"droppable\"]/p"));
    }



}
