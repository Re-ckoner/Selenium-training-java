package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andy on 22.04.2017.
 */
public class LoginAdmin {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void loginAdmin()throws Exception {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name=\"login\"]")).click();
        Thread.sleep(2000); //later change it to something better!!
        driver.findElement(By.linkText("ACME Corp."));
    }

    @After
    public void stop(){
        try {
            driver.quit();
        }
        catch (Exception e){
            //do nothing
        }
    }

}
