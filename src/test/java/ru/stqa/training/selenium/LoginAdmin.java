package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

/**
 * Created by Andy on 22.04.2017.
 */
public class LoginAdmin extends TestBase {

//    private WebDriver driver;
//    private WebDriverWait wait;

//    @Before
//    public void start(){
//        //chrome
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability("unexpectedAlertBehaviour", "dismiss");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("start-maximized");
//        cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//        //driver = new ChromeDriver(cap);
//        FirefoxOptions firefoxOptions = new FirefoxOptions().setLegacy(false);
//        firefoxOptions.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Nightly\\firefox.exe")));
//        driver = new FirefoxDriver(firefoxOptions);
//        // driver = new InternetExplorerDriver();
//        // System.out.print(((HasCapabilities) driver).getCapabilities());
//        wait = new WebDriverWait(driver, 10);
//
//
//
//    }



    @Test
    public void loginAdmin()throws Exception {


        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name=\"login\"]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.name"))); //instead of thread sleep
      //  Thread.sleep(2000);
        driver.findElement(By.linkText("ACME Corp."));
    }


}
