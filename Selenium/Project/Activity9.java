package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;


public class Activity9 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));

        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs/");

        System.out.println("Home page title: " + driver.getTitle());
        //driver.findElement(By.id("menu-item-24")).click();
        driver.findElement(By.id("menu-item-24")).click();
        String title = driver.getTitle();
        Assert.assertEquals("Jobs – Alchemy Jobs", title);
    }
}
