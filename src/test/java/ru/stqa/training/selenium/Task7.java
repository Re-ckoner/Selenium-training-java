package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amil on 5/3/2017.
 */
public class Task7 extends TestBase{
    int count = 0;
    @Test
    public void testAdminMenu() throws InterruptedException
    {

        //driver.get("http://localhost/litecart/admin")
        driver.get("http://localhost/lightcart/public_html/admin");
        logIn();
        List<WebElement> list = driver.findElements(By.cssSelector("#box-apps-menu li#app-  "));
        System.out.print(list.size());
        ArrayList<String> menuItems = new ArrayList<String>();
        for (WebElement e :list){ 
                menuItems.add(e.getText());
        }
        for (String s:menuItems){
                driver.findElement(By.linkText(s)).click();
                List<WebElement> subMenu = driver.findElements(By.cssSelector("ul.docs span.name"));
                ArrayList<String> subItems = new ArrayList<String>();
               assert (isHeaderPresent(driver));
               // System.out.println(subMenu.size());
            for (WebElement we:subMenu){
                subItems.add(we.getText());
            }
            for (String si: subItems){
                driver.findElement(By.linkText(si)).click();
                assert (isHeaderPresent(driver));
            }
                
                
            }
    System.out.print("headers "+count);

    }

    public boolean isHeaderPresent(WebDriver d)
    {
        List<WebElement> list= d.findElements(By.cssSelector("h1"));
        count++;
        return list.size()>0;


    }
}
