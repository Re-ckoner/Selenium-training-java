package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

/**
 * Created by Andy on 17.05.2017.
 */
public class Task11 extends TestBase{

    @Test
    public void registration() throws InterruptedException {
       // driver.get("http://localhost/litecart");
        driver.get("http://localhost/lightcart/public_html");
        String email = randomString(7)+"@mail.ru";
        driver.findElement(By.linkText("New customers click here")).click();
        driver.findElement(By.cssSelector("#box-create-account .form-control[name=firstname]")).sendKeys(randomString(7));
        driver.findElement(By.cssSelector("#box-create-account .form-control[name=lastname]")).sendKeys(randomString(8));
        driver.findElement(By.cssSelector("#box-create-account .form-control[name=address1]")).sendKeys(randomString(5)+" str "+"33");
        driver.findElement(By.cssSelector("#box-create-account .form-control[name=address2]")).sendKeys(randomString(6)+" ave "+"21");
        driver.findElement(By.cssSelector("#box-create-account .form-control[name=tax_id]")).sendKeys("124321");
        driver.findElement(By.cssSelector("#box-create-account .form-control[name=company]")).sendKeys(randomString(8)+". Ltd");
        driver.findElement(By.cssSelector("#box-create-account .form-control[name=postcode]")).sendKeys(randomNum(5));
        driver.findElement(By.cssSelector("#box-create-account .form-control[name=city]")).sendKeys("New "+randomString(6));
       // WebElement countryDropdown = driver.findElement(By.cssSelector("#box-create-account .form-control[name=country_code]"));
     //   countryDropdown.click();
        Select selectCountry = new Select(driver.findElement(By.cssSelector("#box-create-account .form-control[name=country_code]")));
        selectCountry.selectByValue("US");
        Select selectState = new Select(driver.findElement(By.cssSelector("#box-create-account .form-control[name=zone_code]")));
        selectState.selectByIndex(randomInt(20));
        driver.findElement(By.cssSelector("#box-create-account .form-control[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("#box-create-account .form-control[name=phone]")).sendKeys("+"+randomNum(9));
        driver.findElement(By.cssSelector("#box-create-account .form-control[name=password]")).sendKeys("123");
        driver.findElement(By.cssSelector("#box-create-account .form-control[name=confirmed_password]")).sendKeys("123");
        driver.findElement(By.cssSelector("#box-create-account div.btn-group button")).click();
        //logout
        driver.findElement(By.cssSelector("#box-account > ul > li:nth-child(3) > a")).click();
        //log in
        driver.findElement(By.cssSelector("div.form-group.required > div > input")).sendKeys(email);
        driver.findElement(By.cssSelector("#box-account-login > form > div:nth-child(4) > div > input")).sendKeys("123");
        //log in
        driver.findElement(By.cssSelector("#box-account-login > form > div.btn-group.btn-block > button")).click();
        //log out
        driver.findElement(By.cssSelector("#box-account > ul > li:nth-child(3) > a")).click();



        
    }

    public String randomString(int length)
    {
        String characters = "qwertyuiopasdfghjklzxcvbnm";
        Random rng = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
    public String randomNum(int length)
    {
        String characters = "1234567890";
        Random rng = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    public int randomInt(int length)
    {
        Random r = new Random();
        return r.nextInt(length);
    }
}
