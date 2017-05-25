package ru.stqa.training.selenium.Task19.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.TestBase;

/**
 * Created by amil on 5/25/2017.
 */
public class TrashCanPage extends TestBase{
    public void emptyTrashCan(){

     //   driver.findElement(By.cssSelector("body")).sendKeys(Keys.ESCAPE);
       // driver.findElement(By.id("cart")).click();
        int counter = driver.findElements(By.cssSelector("#box-checkout-cart > div > table > tbody tr")).size();
        while (driver.findElements(By.cssSelector("#box-checkout-cart > div > table > tbody tr")).size()>0)
        {
            driver.findElement(By.cssSelector("#box-checkout-cart div.table-responsive tbody tr td:last-child button")).click();
            wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("#box-checkout-cart > div > table > tbody tr"), counter - 1));
            counter--;
        }

    }

}
