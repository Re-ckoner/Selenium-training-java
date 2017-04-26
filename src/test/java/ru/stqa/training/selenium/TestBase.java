package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        wait = new WebDriverWait(driver, 20);
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {driver.quit(); driver = null;}));

    }

    @After
    public void stop(){
      // if(driver != null){driver.quit();}
    }

}
