package ru.stqa.training.selenium;

import javafx.print.Printer;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

/**
 * Created by Andy on 21.05.2017.
 */
public class Task14 extends TestBase {

    @Test
    public void openLinks() throws InterruptedException {
        driver.get("http://localhost/litecart/admin");
        logIn();
        driver.findElement(By.linkText("Countries")).click();
        driver.findElement(By.cssSelector(".fa.fa-pencil")).click();
        List<WebElement> links = driver.findElements(By.cssSelector(".fa.fa-external-link"));
        String mainWIndow = driver.getWindowHandle();

        for (WebElement e:links ){
            e.click();
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            for (String s: driver.getWindowHandles()) {
               if(!(s.equals(mainWIndow))){
                   System.out.println(s);
                   driver.switchTo().window(s);
                   driver.close();
                   driver.switchTo().window(mainWIndow);

               }

            }
        }




        Thread.sleep(1000);
    }
}
