package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by amil on 5/19/2017.
 */
public class Task13 extends TestBase{

    @Test
    public void trashCan() throws InterruptedException
    {
        driver.get("http://localhost/lightcart/public_html/en/");

        //adding
        driver.findElement(By.cssSelector("#main #content a.link")).click();
        Select select = new Select(driver.findElement(By.cssSelector("#box-product > div > div:nth-child(3) > div > div.buy_now > form > div.form-group.required > select")));
        select.selectByIndex(2);
        driver.findElement(By.cssSelector("#box-product > div > div:nth-child(3) > div > div.buy_now > form > div:nth-child(4) > div > div:nth-child(2) > button")).click();
        System.out.println("wololo "+driver.findElement (By.cssSelector("#cart > a > div > div:nth-child(2) > span.quantity")).getText());
       // driver.findElement(By.cssSelector("body")).sendKeys(Keys.ESCAPE);
        //checking cart



        Thread.sleep(3000);
        System.out.println("wololo "+driver.findElement (By.cssSelector("#cart > a > div > div:nth-child(2) > span.quantity")).getText());
    }
}
