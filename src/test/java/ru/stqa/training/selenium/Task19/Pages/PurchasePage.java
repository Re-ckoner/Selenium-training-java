package ru.stqa.training.selenium.Task19.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.training.selenium.TestBase;

/**
 * Created by amil on 5/25/2017.
 */
public class PurchasePage extends TestBase
{
    public void addDuck(){
        //driver.findElement(By.cssSelector("#main #content a.link")).click();
        Select select1 = new Select(driver.findElement(By.cssSelector("#box-product > div > div:nth-child(3) > div > div.buy_now > form > div > select.form-control")));
        select1.selectByIndex(3);
        driver.findElement(By.cssSelector("#box-product > div > div:nth-child(3) > div > div.buy_now > form > div:nth-child(4) > div > div:nth-child(2) > button")).click();
        driver.findElement(By.cssSelector("#box-product")).click();
       // driver.findElement(By.cssSelector("body")).sendKeys(Keys.ESCAPE);
    }
}
