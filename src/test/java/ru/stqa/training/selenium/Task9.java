package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by amil on 5/5/2017.
 */
public class Task9 extends TestBase
{
    @Test
    public void testCountries() throws InterruptedException
    {
       // driver.get("http://localhost/litecart/public_html/admin/?app=countries&doc=countries");
        driver.get("http://localhost/lightcart/public_html/admin//?app=countries&doc=countries");
        logIn();
        driver.get("http://localhost/lightcart/public_html/admin//?app=countries&doc=countries");
        List<WebElement> countries = driver.findElements(By.cssSelector(".table.table-striped.data-table tbody tr"));
        System.out.println("countries found "+countries.size());
        System.out.println("last "+countries.get(countries.size()-1).getText());
        System.out.println("first "+countries.get(0).getText());

        Thread.sleep(6000);

    }

    boolean isSorted(List<WebElement> list){
        String[] arr = new String[list.size()];

        for (WebElement e:list){
            arr
        }
    }

}
