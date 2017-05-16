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
        //driver.get("http://localhost/lightcart/public_html/admin/?app=geo_zones&doc=geo_zones");
        logIn();
        List<String> links = new ArrayList<String>();
       List<WebElement> countries = driver.findElements(By.cssSelector("tbody>tr>td a:not([title=Edit])"));
        for (WebElement e:countries) {
            links.add(e.getAttribute("href"));
           }
        for (String s:links){
            driver.get(s);
            List<WebElement> geoZones = driver.findElements(By.xpath("//tbody/tr/td[4]/input"));
            List<String> zoneNames = new ArrayList<String>();
            for (WebElement e:geoZones){
                zoneNames.add(e.getAttribute("value"));
            }
            assert(isSorted(zoneNames));
        }
    }

    boolean isSorted(List<String> list){

        for (int i=1; i<list.size()-1; i++){
            //arr[i] = list.get(i).getText();
            // System.out.println(list.get(i).getText() +" "+ list.get(i-1).getText()+ " compare result= "  + list.get(i).getText().compareTo(list.get(i-1).getText()));
            if(list.get(i).compareTo(list.get(i-1))<0){
                System.out.println(list.get(i) +" "+ list.get(i-1)+ " compare result= "  + list.get(i).compareTo(list.get(i-1)));
                return false;
            }
        }
        return true;

    }

}
