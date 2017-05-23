package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy on 21.05.2017.
 */
public class Task17 extends TestBase {

    @Test
    public void logCheck() throws InterruptedException {
      //      driver.get("http://localhost/litecart/admin");
        driver.get("http://localhost/lightcart/public_html/admin");
        logIn();
        //driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        driver.get("http://localhost/lightcart/public_html/admin/?app=catalog&doc=catalog&category_id=1");
        java.util.List<WebElement> links = driver.findElements(By.cssSelector("#main > form > table > tbody > tr > td:nth-child(3) > a"));
        List<String> lotNames = new ArrayList<String>();

        for (int i=1; i<links.size(); i++)
        {
           lotNames.add(links.get(i).getText());
        }

        for (String s:lotNames){
            driver.findElement(By.linkText(s)).click();

            assert(driver.manage().logs().get("browser").getAll().size()==0);

            driver.navigate().back();

        }

       
    }
}
