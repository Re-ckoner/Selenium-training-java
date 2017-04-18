package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by amil on 4/18/2017.
 */
public class MyFirstTest
{
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start()
    {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void firstTest(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java");
        driver.findElement(By.name("btnG")).click();
        System.out.println(driver.getTitle());
        wait.until(titleIs("java - Поиск в Google"));
        System.out.println(driver.getTitle());
    }


    @After
    public void stop()
    {
       try{
            driver.quit();
            driver = null;
       }
       catch(Exception e){
//            do nothing
       }
    }
}
