package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Andy on 16.05.2017.
 */
public class Mock extends TestBase {
    @Test
    public void justMock(){
        driver.get("http://localhost/litecart/admin/?app=countries&doc=edit_country&country_code=CA");
        logIn();
        List<WebElement> geoZones = driver.findElements(By.cssSelector("tbody>tr>td>input[name*=name]"));
        System.out.println(geoZones.size());
        for (WebElement e:geoZones) {
            System.out.println(e.getAttribute("value"));
        }
    }

}
