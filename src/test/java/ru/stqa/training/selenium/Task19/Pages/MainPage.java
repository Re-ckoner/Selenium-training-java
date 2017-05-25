package ru.stqa.training.selenium.Task19.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import ru.stqa.training.selenium.TestBase;

/**
 * Created by amil on 5/24/2017.
 */
public class MainPage extends TestBase
{
    public void open(){
         driver.get("http://localhost/litecart");
        //driver.get("http://localhost/lightcart/public_html");
    }
    public int getGoodsNum()
    {
        return Integer.parseInt(driver.findElement(By.cssSelector("#cart > a > div > div:nth-child(2) > span.quantity")).getText());
    }
    public void clickToPurchase(){
        driver.findElement(By.cssSelector("#main #content a.link")).click();
    }

    public boolean checkCart(int gn){
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ESCAPE);
        try{
            wait.until((WebDriver d) -> d.findElement(By.cssSelector("#cart > a > div > div:nth-child(2) > span.quantity")).getText().equals(Integer.toString(gn)));
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    public void goToTrashCan(){
        driver.findElement(By.id("cart")).click();
    }

}
