package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amil on 5/5/2017.
 */
public class Task9 extends TestBase
{
    @Test
    public void testCountries() throws InterruptedException
    {
        //driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.get("http://localhost/lightcart/public_html/admin//?app=countries&doc=countries");
        logIn();
      // driver.get("http://localhost/litecart/admin//?app=countries&doc=countries");
        List<WebElement> countries = driver.findElements(By.cssSelector(".table.table-striped.data-table tbody tr a:not([title=Edit])"));
        System.out.println("countries found "+countries.size());
        System.out.println("last "+countries.get(countries.size()-1).getText());
        System.out.println("first "+countries.get(0).getAttribute("textContent"));
      //  assert(isSorted(countries));
    //    isSorted(countries);

        List<WebElement> zones = driver.findElements(By.cssSelector(".table.table-striped.data-table > tbody > tr > td.text-center"));
        System.out.println("zones found "+ zones.size());
        List<String> notEmptyZones = new ArrayList<String>();
        for (WebElement e:zones){
            if(!(e.getText().equals("0"))){
            notEmptyZones.add(e.getText());
            }
        }

        for(int i=0; i<countries.size()-1; i++){
            countries.get(i);
        }
    }


    boolean isSorted(List<WebElement> list){

        for (int i=1; i<list.size()-1; i++){
            //arr[i] = list.get(i).getText();
           // System.out.println(list.get(i).getText() +" "+ list.get(i-1).getText()+ " compare result= "  + list.get(i).getText().compareTo(list.get(i-1).getText()));
            if(list.get(i).getText().compareTo(list.get(i-1).getText())<0){
                System.out.println(list.get(i).getText() +" "+ list.get(i-1).getText()+ " compare result= "  + list.get(i).getText().compareTo(list.get(i-1).getText()));
                return false;
            }
        }
        return true;

   }

}
