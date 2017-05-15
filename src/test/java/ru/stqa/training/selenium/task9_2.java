package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy on 16.05.2017.
 */
public class task9_2 extends TestBase {
    @Test
    public void testZones(){
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        logIn();
        List<String> links = new ArrayList<String>();
       List<WebElement> countries = driver.findElements(By.cssSelector("tbody>tr>td a:not([title=Edit])"));
        for (WebElement e:countries) {
            links.add(e.getAttribute("href"));
            System.out.println(e.getAttribute("href"));
        }
    }



}
