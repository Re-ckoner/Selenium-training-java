package ru.stqa.training.selenium;

import org.junit.Test;

/**
 * Created by Andy on 21.05.2017.
 */
public class Task17 extends TestBase {

    @Test
    public void logCheck() throws InterruptedException {
        driver.get("http://localhost/litecart/admin");
        logIn();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");

        Thread.sleep(1000);
    }
}
