package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenImagesPage {

    public void getBrokenImgs() throws IOException {
        List<WebElement> imgList = BaseClass.getDriver().findElements(By.tagName("img"));


//        imgList.forEach((v) -> System.out.println(v.getAttribute("src")));
        for (WebElement ele : imgList){
            String imgSrc = ele.getAttribute("src");
            try {
                URL u = new URL(imgSrc) ;
                HttpURLConnection httpURLConn = (HttpURLConnection) u.openConnection();
                System.out.println("The Src::: "+imgSrc+" :::Resp Code::: "+httpURLConn.getResponseCode()+" :::Resp Msg::: "+httpURLConn.getResponseMessage());

            } catch (Exception e){
                System.out.println("This is from Catch bock ::: "+imgSrc);
            }


        }


    }
}
