package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Andy on 03.05.2017.
 */
public class TestStickers extends TestBase {

    @Test
    public void stickersTest()  {
        driver.get("http://localhost/litecart");
       // driver.findElement(By.cssSelector("li.category-1")).click();
        driver.findElement(By.xpath(""));


    }

}
