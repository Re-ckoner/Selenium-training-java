package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amil on 5/5/2017.
 */
public class Task9b extends TestBase {
    @Test
    public void testCountries1() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
//        driver.get("http://localhost/lightcart/public_html/admin//?app=countries&doc=countries");
        logIn();
        // driver.get("http://localhost/litecart/admin//?app=countries&doc=countries");
        List<WebElement> lines = driver.findElements(By.cssSelector(
                ".table.table-striped.data-table tbody tr"));
        List<String> links = new ArrayList<String>();
        System.out.println("lines found " + lines.size());
        List<Integer> lineNums = new ArrayList<Integer>();
        for (int i = 0; i < lines.size(); i++) {
            if (!(lines.get(i).findElement(By.cssSelector("td.text-center")).getText().equals("0"))) {
                lineNums.add(i);
            }
        }

        for (Integer i : lineNums) {
            links.add(lines.get(i).findElement(By.cssSelector("a:not([title=Edit])")).getAttribute("href"));
        }
        for (String l : links) {
          //  System.out.println(l);
            driver.get(l);
            //logIn();
            List<WebElement> geoZones = driver.findElements(By.cssSelector("tbody>tr>td>input[name*=name]"));
            assert (isSortedb(geoZones));
           // System.out.println(isSortedb(geoZones));

        }


    }


    boolean isSortedb(List<WebElement> list) {

        for (int i = 1; i < list.size() - 1; i++) {
            //arr[i] = list.get(i).getText();
            // System.out.println(list.get(i).getText() +" "+ list.get(i-1).getText()+ " compare result= "  + list.get(i).getText().compareTo(list.get(i-1).getText()));
            if (list.get(i).getAttribute("value").compareTo(list.get(i - 1).getAttribute("value")) < 0) {
                System.out.println(list.get(i).getAttribute("value") + " " + list.get(i - 1).getAttribute("value") + " compare result= " + list.get(i).getAttribute("value").compareTo(list.get(i - 1).getAttribute("value")));
                return false;
            }
        }
        return true;

    }

}
