package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by amil on 5/19/2017.
 */
public class Task13a extends TestBase{

    int goodsNumber;

    public void open(){
       // driver.get("http://localhost/litecart/en/");
        driver.get("http://localhost/lightcart/public_html");
    }

    public int getGoodsNum()
    {
        return Integer.parseInt(driver.findElement(By.cssSelector("#cart > a > div > div:nth-child(2) > span.quantity")).getText());
    }

    public void addDuck(){
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ESCAPE);
        driver.findElement(By.cssSelector("#main #content a.link")).click();
        Select select1 = new Select(driver.findElement(By.cssSelector("#box-product > div > div:nth-child(3) > div > div.buy_now > form > div > select.form-control")));
        select1.selectByIndex(3);
        driver.findElement(By.cssSelector("#box-product > div > div:nth-child(3) > div > div.buy_now > form > div:nth-child(4) > div > div:nth-child(2) > button")).click();
        driver.findElement(By.cssSelector("#box-product")).click();
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

    public void emptyTrashCan(){

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ESCAPE);
        driver.findElement(By.id("cart")).click();
        int counter = driver.findElements(By.cssSelector("#box-checkout-cart > div > table > tbody tr")).size();
        while (driver.findElements(By.cssSelector("#box-checkout-cart > div > table > tbody tr")).size()>0)
        {
            driver.findElement(By.cssSelector("#box-checkout-cart div.table-responsive tbody tr td:last-child button")).click();
            wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("#box-checkout-cart > div > table > tbody tr"), counter - 1));
            counter--;
        }

    }

    @Test
    public void trashCan() throws InterruptedException{
        //driver.get("http://localhost/lightcart/public_html/en/");

        open();
        goodsNumber = getGoodsNum();
        addDuck();
        goodsNumber++;
        assert(checkCart(goodsNumber));
        open();
        addDuck();
        goodsNumber++;
        assert(checkCart(goodsNumber));
        emptyTrashCan();
        //check cart



        //add 2
      //  driver.get("http://localhost/litecart/en/");
        //goodsNum = Integer.parseInt(driver.findElement(By.cssSelector("#cart > a > div > div:nth-child(2) > span.quantity")).getText());
//        driver.findElement(By.cssSelector("#main #content a.link")).click();
//        driver.findElement(By.cssSelector("#box-product"));
//
//        Select select1 = new Select(driver.findElement(By.cssSelector("#box-product > div > div:nth-child(3) > div > div.buy_now > form > div > select.form-control")));
//        select1.selectByIndex(3);
//        driver.findElement(By.cssSelector("#box-product > div > div:nth-child(3) > div > div.buy_now > form > div:nth-child(4) > div > div:nth-child(2) > button")).click();
//        driver.findElement(By.cssSelector("#box-product")).click();
        //goodsNum++;
       // wait.until((WebDriver d) -> d.findElement(By.cssSelector("#cart > a > div > div:nth-child(2) > span.quantity")).getText().equals(Integer.toString(goodsNum)));

        //add 3
      //  driver.get("http://localhost/litecart/en/");
        //goodsNum = Integer.parseInt(driver.findElement(By.cssSelector("#cart > a > div > div:nth-child(2) > span.quantity")).getText());
      //  driver.findElement(By.cssSelector("#main #content a.link")).click();
        //select = new Select(driver.findElement(By.cssSelector("#box-product > div > div:nth-child(3) > div > div.buy_now > form > div > select.form-control")));
        //select.selectByIndex(1);
       // driver.findElement(By.cssSelector("#box-product > div > div:nth-child(3) > div > div.buy_now > form > div:nth-child(4) > div > div:nth-child(2) > button")).click();
        //goodsNum++;
       // wait.until((WebDriver d) -> d.findElement(By.cssSelector("#cart > a > div > div:nth-child(2) > span.quantity")).getText().equals(Integer.toString(goodsNum)));

        //remove
//        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ESCAPE);
//        driver.findElement(By.id("cart")).click();
//        while (driver.findElements(By.cssSelector("#box-checkout-cart > div > table > tbody tr")).size()>0){
//            driver.findElement(By.cssSelector("#box-checkout-cart div.table-responsive tbody tr td:last-child button")).click();
//          //  wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("#box-checkout-cart > div > table > tbody tr"),goodsNum-1));
//            //goodsNum--;
        }



    }

