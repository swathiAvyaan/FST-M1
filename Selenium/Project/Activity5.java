package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity5 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs/");

        System.out.println("Home page title: " + driver.getTitle());
        //driver.findElement(By.id("menu-item-24")).click();
        driver.findElement(By.id("menu-item-24")).click();
        String title = driver.getTitle();
        Assert.assertEquals("Jobs – Alchemy Jobs", title);
        // Close the browser
        driver.close();
    }
}
