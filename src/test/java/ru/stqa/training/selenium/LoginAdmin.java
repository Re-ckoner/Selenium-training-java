package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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


        driver.get("http://localhost/litecart/admin");
       // driver.get("http://localhost/lightcart/public_html/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("button.btn.btn-default")).click();
        // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.name")));
        System.out.println("number of main menu entries " + driver.findElements(By.cssSelector("#box-apps-menu-wrapper li")).size());
        System.out.println("number of main menu entries " + driver.findElements(By.cssSelector("span.name")).size()); //just another way

        driver.findElement(By.linkText("Appearance")).click();
        assert (isHeaderPresent(driver));

        driver.findElement(By.linkText("Template")).click();
        assert (isHeaderPresent(driver));

        driver.findElement(By.linkText("Logotype")).click();
        assert (isHeaderPresent(driver));

        driver.findElement(By.linkText("Catalog")).click();
        assert (isHeaderPresent(driver));
             driver.findElement(By.linkText("Product Groups")).click();
             driver.findElement(By.linkText("Option Groups")).click();
             driver.findElement(By.linkText("Manufacturers")).click();
             driver.findElement(By.linkText("Suppliers")).click();
             driver.findElement(By.linkText("Delivery Statuses")).click();
             driver.findElement(By.linkText("Sold Out Statuses")).click();
             driver.findElement(By.linkText("Quantity Units")).click();
             driver.findElement(By.linkText("CSV Import/Export")).click();
             driver.findElement(By.id("doc-catalog")).click();

        driver.findElement(By.linkText("Countries")).click();
        assert (isHeaderPresent(driver));

        driver.findElement(By.linkText("Currencies")).click();
        assert (isHeaderPresent(driver));

        driver.findElement(By.linkText("Customers")).click();
        assert (isHeaderPresent(driver));
             driver.findElement(By.linkText("CSV Import/Export")).click();
             driver.findElement(By.linkText("Newsletter")).click();
             driver.findElement(By.cssSelector("#doc-customers")).click();

        driver.findElement(By.linkText("Geo Zones")).click();
        assert (isHeaderPresent(driver));

        driver.findElement(By.linkText("Languages")).click();
        assert (isHeaderPresent(driver));
             driver.findElement(By.linkText("Storage Encoding")).click();
             driver.findElement(By.cssSelector("#doc-languages")).click();

        driver.findElement(By.linkText("Modules")).click();
        assert (isHeaderPresent(driver));
             driver.findElement(By.linkText("Customer Modules")).click();
             driver.findElement(By.linkText("Shipping Modules")).click();
             driver.findElement(By.linkText("Payment Modules")).click();
             driver.findElement(By.linkText("Order Modules")).click();
             driver.findElement(By.linkText("Order Total Modules")).click();
             driver.findElement(By.linkText("Job Modules")).click();

        driver.findElement(By.linkText("Orders")).click();
        assert (isHeaderPresent(driver));
            driver.findElement(By.linkText("Order Statuses")).click();
            driver.findElement(By.cssSelector("#doc-orders")).click();

        driver.findElement(By.linkText("Pages")).click();
        assert (isHeaderPresent(driver));
            driver.findElement(By.linkText("CSV Import/Export")).click();
            driver.findElement(By.cssSelector("#doc-pages")).click();

        driver.findElement(By.linkText("Reports")).click();
        assert (isHeaderPresent(driver));
            driver.findElement(By.linkText("Monthly Sales")).click();
            driver.findElement(By.linkText("Most Sold Products")).click();
            driver.findElement(By.linkText("Most Shopping Customers")).click();

        driver.findElement(By.linkText("Settings")).click();
        assert (isHeaderPresent(driver));
           driver.findElement(By.linkText("Store Info")).click();
           driver.findElement(By.linkText("Defaults")).click();
           driver.findElement(By.linkText("General")).click();
           driver.findElement(By.linkText("Listings")).click();
           driver.findElement(By.linkText("Images")).click();
           driver.findElement(By.linkText("Checkout")).click();
           driver.findElement(By.linkText("Advanced")).click();
           driver.findElement(By.linkText("Security")).click();

        driver.findElement(By.linkText("Slides")).click();
        assert (isHeaderPresent(driver));

        driver.findElement(By.linkText("Tax")).click();
        assert (isHeaderPresent(driver));
            driver.findElement(By.linkText("Tax Rates")).click();
            driver.findElement(By.linkText("Tax Classes")).click();

        driver.findElement(By.linkText("Translations")).click();
        assert (isHeaderPresent(driver));
            driver.findElement(By.linkText("Search Translations")).click();
            driver.findElement(By.linkText("Scan Files")).click();
            driver.findElement(By.linkText("CSV Import/Export")).click();

        driver.findElement(By.linkText("Users")).click();
        assert (isHeaderPresent(driver));

        driver.findElement(By.linkText("vQmods")).click();
        assert (isHeaderPresent(driver));
    }

        public void printList(List<WebElement> list){
        for (WebElement s :list){
            System.out.println("sub-menu "+ s.getText());
        }
            System.out.println("==================================================================");
       }

       public boolean isHeaderPresent(WebDriver d)
       {
           List<WebElement> list= d.findElements(By.cssSelector("h1"));
           return list.size()>0;
       }


}
