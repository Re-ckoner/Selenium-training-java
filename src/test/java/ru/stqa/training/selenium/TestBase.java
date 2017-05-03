package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andy on 26.04.2017.
 */
public class TestBase {

    public static  WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void start (){
        if(driver != null) {return;}
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("unexpectedAlertBehaviour", "dismiss");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        driver = new ChromeDriver(cap);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {driver.quit(); driver = null;}));

    }

    public void logIn()
    {
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("button.btn.btn-default")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.name")));
    }

    @After
    public void stop(){
      // if(driver != null){driver.quit();}
    }

}
