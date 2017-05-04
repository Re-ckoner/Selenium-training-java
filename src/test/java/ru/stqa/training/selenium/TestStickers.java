package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Andy on 03.05.2017.
 */
public class TestStickers extends TestBase {

    @Test
    public void stickersTest() throws InterruptedException
    {
        driver.get("http://localhost/litecart");
        //driver.get("http://localhost/lightcart/public_html");
        List<WebElement> goods =  driver.findElements(By.xpath("//div[@class='image-wrapper']"));
        System.out.println("images number = "+goods.size());
        for (WebElement e :goods){
            assert(e.findElements(By.xpath(".//div[contains(@class,'sticker')]")).size()==1);
        }
    }

}
