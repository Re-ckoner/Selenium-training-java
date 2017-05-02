package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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
    public void loginAdmin()throws Exception
    {


        //driver.get("http://localhost/litecart/admin");
        driver.get("http://localhost/lightcart/public_html/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("button.btn.btn-default")).click();
        // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.name")));
        System.out.println("number of main menu entries " + driver.findElements(By.cssSelector("#box-apps-menu-wrapper li")).size());
        System.out.println("number of main menu entries " + driver.findElements(By.cssSelector("span.name")).size()); //just another way

        WebElement e; //for storing the sub-menu

        driver.findElement(By.linkText("Appearance")).click();
        driver.findElement(By.linkText("Template")).click();
        driver.findElement(By.linkText("Logotype")).click();

        driver.findElement(By.linkText("Catalog")).click();
        e =  driver.findElement(By.cssSelector("ul.docs"));
             e.findElement(By.linkText("Product Groups")).click();
             e.findElement(By.linkText("Option Groups")).click();
             e.findElement(By.linkText("Catalog")).click();
             e.findElement(By.linkText("Manufacturers")).click();
             e.findElement(By.linkText("Suppliers")).click();
             e.findElement(By.linkText("Delivery Statuses")).click();
             e.findElement(By.linkText("Sold Out Statuses")).click();
             e.findElement(By.linkText("Quantity Units")).click();
             e.findElement(By.linkText("CSV Import/Export")).click();

        driver.findElement(By.linkText("Countries")).click();
        driver.findElement(By.linkText("Currencies")).click();

        driver.findElement(By.linkText("Customers")).click();
        e =  driver.findElement(By.cssSelector(".docs"));
            e.findElement(By.linkText("CSV Import/Export")).click();
            e.findElement(By.linkText("Newsletter")).click();
            e.findElement(By.linkText("Customers")).click();

        driver.findElement(By.linkText("Geo Zones")).click();

        driver.findElement(By.linkText("Languages")).click();
        e =  driver.findElement(By.cssSelector("#doc-catalog"));
         e.findElement(By.linkText("Storage Encoding")).click();
         e.findElement(By.linkText("Languages")).click();

        driver.findElement(By.linkText("Modules")).click();
             driver.findElement(By.linkText("Customer Modules")).click();
             driver.findElement(By.linkText("Shipping Modules")).click();
             driver.findElement(By.linkText("Payment Modules")).click();
             driver.findElement(By.linkText("Order Modules")).click();
             driver.findElement(By.linkText("Order Total Modules")).click();
             driver.findElement(By.linkText("Job Modules")).click();

        driver.findElement(By.linkText("Orders")).click();
        e =  driver.findElement(By.cssSelector("#doc-catalog"));
            e.findElement(By.linkText("Order Statuses")).click();
            e.findElement(By.linkText("Orders")).click();

        driver.findElement(By.linkText("Pages")).click();
        e =  driver.findElement(By.cssSelector("#doc-catalog"));
            e.findElement(By.linkText("CSV Import/Export")).click();
            e.findElement(By.linkText("Pages")).click();

        driver.findElement(By.linkText("Reports")).click();
        driver.findElement(By.linkText("Settings")).click();
        driver.findElement(By.linkText("Slides")).click();
        driver.findElement(By.linkText("Tax")).click();
        driver.findElement(By.linkText("Translations")).click();
        driver.findElement(By.linkText("Users")).click();
        driver.findElement(By.linkText("vQmods")).click();
    }

        public void printList(List<WebElement> list){
        for (WebElement s :list){
            System.out.println("sub-menu "+ s.getText());
        }
            System.out.println("==================================================================");
       }


}
