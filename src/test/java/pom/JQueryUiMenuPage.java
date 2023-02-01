package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.HashMap;

public class JQueryUiMenuPage {

    public void selectFile(String fileName) throws InterruptedException {


        WebElement elem01 = BaseClass.getDriver().findElement(By.xpath("//*[@id=\"ui-id-3\"]/a"));
        WebElement elem02 = BaseClass.getDriver().findElement(By.xpath("//*[@id=\"ui-id-4\"]/a"));


        HashMap <String, Integer> fileXpath = new HashMap<>() ;
        fileXpath.put("Excel", 7);  //*[@id="ui-id-7"]  Excel
        fileXpath.put("PDF", 5);    //*[@id="ui-id-5"]  PDF
        fileXpath.put("CSV", 6);    //*[@id="ui-id-6"]  CSV

        WebElement elem03 = BaseClass.getDriver().findElement(By.xpath("//*[@id=\"ui-id-"+fileXpath.get(fileName)+"\"]"));

        Actions actions = new Actions(BaseClass.getDriver());
        actions.moveToElement(elem01).perform();
        Thread.sleep(3000);
        actions.moveToElement(elem02).perform();
        Thread.sleep(3000);
        actions.moveToElement(elem03).perform();

        actions.click().build().perform();
        Thread.sleep(3000);

    }

    public void assertionForDownload(String fileName) {

        SoftAssert softAssert = new SoftAssert();
        String fullFileName = null;
        switch (fileName) {
            case "Excel":
                fullFileName = "menu.xls";
                break;
            case "PDF":
                fullFileName = "menu.pdf";
                break;
            case "CSV":
                fullFileName = "menu.csv";
                break;
        }
        File file = new File("C:\\Users\\HELAL's\\Downloads\\"+fullFileName);
        softAssert.assertTrue(file.exists());
        softAssert.assertAll();
    }

}
