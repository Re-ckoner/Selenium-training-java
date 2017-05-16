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
       // driver.get("http://localhost/lightcart/public_html");
        driver.get("http://localhost/litecart");

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
        //System.out.print(grey);
        assert((parseColor(grey)[0].equals(parseColor(grey)[1]))&&parseColor(grey)[0].equals(parseColor(grey)[2]));
        assert((parseColor(red)[1].equals("0"))&&(parseColor(red)[2].equals("0")));

        String font = driver.findElement(By.cssSelector("#box-campaigns > div > div > div > a .price-wrapper s")).getCssValue("text-decoration");
        assert(font.contains("line-through"));
        String fontA = driver.findElement(By.cssSelector("#box-campaigns > div > div > div > a .price-wrapper strong")).getCssValue("font-weight");
        assert((fontA.contains("bold"))||(fontA.contains("700")));
        String fontSize = driver.findElement(By.cssSelector("#box-campaigns > div > div > div > a .price-wrapper s")).getCssValue("font-size");
        String fontSizeA = driver.findElement(By.cssSelector("#box-campaigns > div > div > div > a .price-wrapper strong")).getCssValue("font-size");
        assert(fontSizeA.compareTo(fontSize)>0);
        // assert (parseColor(grey)[1]==parseColor(grey)[2]);



        driver.findElement(By.cssSelector("#box-campaigns > div > div > div > a")).click();
        assert(driver.findElement(By.cssSelector("#box-product > div.row > div:nth-child(2) > h1"))
        .getText()).equals(map.get("name"));
        //System.out.println(driver.findElement(By.cssSelector("#box-product > div.row > div:nth-child(2) > h1")).getText());
        assert(driver.findElement(By.cssSelector(".regular-price")).getText().equals(map.get("price")));
        assert(driver.findElement(By.cssSelector(".campaign-price")).getText().equals(map.get("priceA")));
        grey = driver.findElement(By.cssSelector(".regular-price")).getCssValue("color");
        red = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
        assert((parseColor(grey)[0].equals(parseColor(grey)[1]))&&parseColor(grey)[0].equals(parseColor(grey)[2]));
        assert((parseColor(red)[1].equals("0"))&&(parseColor(red)[2].equals("0")));

        font = driver.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration");
        assert(font.contains("line-through"));
        fontA = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("font-weight");
        assert((fontA.contains("bold"))||(fontA.contains("700")));

        fontSize = driver.findElement(By.cssSelector(".regular-price")).getCssValue("font-size");
        fontSizeA = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("font-size");
        assert(fontSizeA.compareTo(fontSize)>0);
    }




    public String[] parseColor(String input)
    {
        String str = input.replaceAll("[a-z]", "");
        //System.out.println(str);
        String res[] = str.substring(1,str.length() - 1 ).split(", ");

        return res;
    }
}
