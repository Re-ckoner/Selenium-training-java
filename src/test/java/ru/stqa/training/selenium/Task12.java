package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

/**
 * Created by amil on 5/17/2017.
 */
public class Task12 extends TestBase{

    @Test
    public void addGoods() throws InterruptedException
    {
        driver.get("http://localhost/lightcart/public_html/admin");
        logIn();
        driver.findElement(By.linkText("Catalog")).click();
        driver.findElement(By.cssSelector("#main > ul > li:nth-child(3) > a")).click();
        driver.findElement(By.cssSelector(".form-group .form-control[name=code]")).sendKeys("12345");
        driver.findElement(By.cssSelector(".form-group .form-control[name*=name]")).sendKeys("Stuff");
        driver.findElement(By.cssSelector(".form-group .form-control[name=sku]")).sendKeys("sku");
        driver.findElement(By.cssSelector(".form-group .form-control[name=gtin]")).sendKeys("gtin");
        driver.findElement(By.cssSelector(".form-group .form-control[name=taric]")).sendKeys("taric");
        driver.findElement(By.cssSelector(".form-group .form-control[name=quantity]")).sendKeys("77");
        driver.findElement(By.cssSelector(".form-group .form-control[name=quantity]")).sendKeys("77");
        driver.findElement(By.cssSelector(".form-group .form-control[name=weight]")).sendKeys("700");
        driver.findElement(By.cssSelector(".form-group .form-control[name=dim_x]")).sendKeys("10");
        driver.findElement(By.cssSelector(".form-group .form-control[name=dim_y]")).sendKeys("20");
        driver.findElement(By.cssSelector(".form-group .form-control[name=dim_z]")).sendKeys("30");
        driver.findElement(By.cssSelector(".form-group .form-control[name=date_valid_from]")).sendKeys("01012010");
        driver.findElement(By.cssSelector(".form-group .form-control[name=date_valid_to]")).sendKeys("01012020");
        driver.findElement(By.cssSelector("#tab-general  div  div:nth-child(1)  div:nth-child(4) .checkbox:nth-child(4) input")).clear();
        driver.findElement(By.cssSelector("#tab-general  div  div:nth-child(1)  div:nth-child(4) .checkbox:nth-child(4) input")).click();



        Thread.sleep(5000);
    }



    public String randomString(int length)
    {
        String characters = "qwertyuiopasdfghjklzxcvbnm";
        Random rng = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
    public String randomNum(int length)
    {
        String characters = "1234567890";
        Random rng = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    public int randomInt(int length)
    {
        Random r = new Random();
        return r.nextInt(length);
    }
}
