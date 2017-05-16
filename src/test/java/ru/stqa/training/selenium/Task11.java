package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

/**
 * Created by Andy on 17.05.2017.
 */
public class Task11 extends TestBase{

    @Test
    public void registration() throws InterruptedException {
        driver.get("http://localhost/litecart");
        driver.findElement(By.linkText("New customers click here")).click();
        driver.findElement(By.cssSelector("#box-create-account .form-control[name=firstname]")).sendKeys(randomString(7));
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
}
