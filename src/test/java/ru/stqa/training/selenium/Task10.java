package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

import java.util.HashMap;

/**
 * Created by amil on 5/16/2017.
 */
public class Task10 extends TestBase{

    @Test
    public void testGoods() throws Exception{
        driver.get("http://localhost/lightcart/public_html");

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("name", driver.findElement(
                By.cssSelector("#box-campaigns > div > div > div > a")).getAttribute("title"));
        map.put("price", driver.findElement(
                By.cssSelector("#box-campaigns > div > div > div > a .price-wrapper s")).getText());
        map.put("priceA", driver.findElement(
                By.cssSelector("#box-campaigns > div > div > div > a .price-wrapper strong")).getText());
        //System.out.println(map.get("name"));
        String grey = driver.findElement(By.cssSelector("#box-campaigns > div > div > div > a .price-wrapper s")).getCssValue("color");
        String red = driver.findElement(By.cssSelector("#box-campaigns > div > div > div > a .price-wrapper strong")).getCssValue("color");
        assert((parseColor(grey)[0].equals(parseColor(grey)[1]))&&parseColor(grey)[0].equals(parseColor(grey)[2]));
        assert((parseColor(red)[1].equals("0"))&&(parseColor(red)[2].equals("0")));

        String font = driver.findElement(By.cssSelector("#box-campaigns > div > div > div > a .price-wrapper s")).getCssValue("text-decoration");
        assert(font.contains("line-through"));
        String fontA = driver.findElement(By.cssSelector("#box-campaigns > div > div > div > a .price-wrapper strong")).getCssValue("font-weight");
        assert(fontA.contains("bold"));


        // assert (parseColor(grey)[1]==parseColor(grey)[2]);



        driver.findElement(By.cssSelector("#box-campaigns > div > div > div > a")).click();
        assert(driver.findElement(By.cssSelector("#box-product > div.row > div:nth-child(2) > h1"))
        .getText()).equals(map.get("name"));
        //System.out.println(driver.findElement(By.cssSelector("#box-product > div.row > div:nth-child(2) > h1")).getText());
        assert(driver.findElement(By.cssSelector(".regular-price")).getText().equals(map.get("price")));
        assert(driver.findElement(By.cssSelector(".campaign-price")).getText().equals(map.get("priceA")));
    }




    public String[] parseColor(String input)
    {
        return input.substring(5, input.length() - 1 ).split(", ");
    }
}
