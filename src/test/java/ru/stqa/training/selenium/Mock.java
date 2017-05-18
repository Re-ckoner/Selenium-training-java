package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Andy on 16.05.2017.
 */
public class Mock extends TestBase {
    @Test
    public void justMock() throws InterruptedException
    {
        driver.get("http://localhost/lightcart/public_html/admin");
        logIn();
        driver.findElement(By.linkText("Catalog")).click();
        driver.findElement(By.cssSelector("#main > ul > li:nth-child(3) > a")).click();

        //driver.findElement(By.cssSelector("#main form div ul li:nth-child(2) a")).click();
        driver.findElement(By.cssSelector("#main form div ul li a[href*=info]")).click();
        Select manuf = new Select(driver.findElement(By.cssSelector("#tab-information select[name=manufacturer_id]")));
        manuf.selectByIndex(1);
        driver.findElement(By.cssSelector("#tab-information > div:nth-child(2) > div > input")).sendKeys("duck, fun, bath, electricity");
        driver.findElement(By.cssSelector("#tab-information > div:nth-child(3) > div > div > input")).sendKeys("bath like hell!");
        driver.findElement(By.cssSelector("#tab-information > div:nth-child(3) > div > input")).sendKeys(Keys.TAB, "aa");






        Thread.sleep(5000);
    }

}
