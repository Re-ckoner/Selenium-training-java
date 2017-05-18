package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by amil on 5/17/2017.
 */
public class Task12 extends TestBase{

    @Test
    public void addGoods() throws InterruptedException, IOException
    {
        driver.get("http://localhost/lightcart/public_html/admin");
        //driver.get("http://localhost/litecart/admin");
        logIn();
        driver.findElement(By.linkText("Catalog")).click();
        driver.findElement(By.cssSelector("#main > ul > li:nth-child(3) > a")).click();
        driver.findElement(By.cssSelector(".form-group .form-control[name=code]")).sendKeys("12345");
        driver.findElement(By.cssSelector(".form-group .form-control[name*=name]")).sendKeys("Suicide duck");
        driver.findElement(By.cssSelector(".form-group .form-control[name=sku]")).sendKeys("sku");
        driver.findElement(By.cssSelector(".form-group .form-control[name=gtin]")).sendKeys("gtin");
        driver.findElement(By.cssSelector(".form-group .form-control[name=taric]")).sendKeys("taric");
        driver.findElement(By.cssSelector(".form-group .form-control[name=quantity]")).sendKeys("77");
        driver.findElement(By.cssSelector(".form-group .form-control[name=quantity]")).sendKeys("77");
        driver.findElement(By.cssSelector(".form-group .form-control[name=weight]")).sendKeys("100");
        driver.findElement(By.cssSelector(".form-group .form-control[name=dim_x]")).sendKeys("10");
        driver.findElement(By.cssSelector(".form-group .form-control[name=dim_y]")).sendKeys("20");
        driver.findElement(By.cssSelector(".form-group .form-control[name=dim_z]")).sendKeys("30");
        driver.findElement(By.cssSelector(".form-group .form-control[name=date_valid_from]")).sendKeys("01012010");
        driver.findElement(By.cssSelector(".form-group .form-control[name=date_valid_to]")).sendKeys("01012020");
        driver.findElement(By.cssSelector(".col-md-4:nth-of-type(1) .form-group:nth-of-type(4) .checkbox:nth-of-type(3) input")).click();
        Select delivery = new Select(driver.findElement(By.cssSelector(".col-md-4:nth-of-type(2) .form-group:nth-of-type(7) select")));
        delivery .selectByIndex(1);
        Select sold = new Select(driver.findElement(By.cssSelector(".col-md-4:nth-of-type(2) .form-group:nth-of-type(8) select")));
        sold.selectByIndex(2);
        File pic = new File("src\\electroduck.jpg");
        driver.findElement(By.cssSelector(".col-md-4:nth-of-type(3) .form-control")).sendKeys(pic.getCanonicalPath());

        //info tab
        driver.findElement(By.cssSelector("#main form div ul li a[href*=info]")).click();



        driver.findElement(By.cssSelector("#main > form > p > button:nth-child(1)")).click();



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
