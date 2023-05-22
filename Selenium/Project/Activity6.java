package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs/");

        System.out.println("Home page title: " + driver.getTitle());
        //driver.findElement(By.id("menu-item-24")).click();
        driver.findElement(By.id("menu-item-24")).click();
        String title = driver.getTitle();
        Assert.assertEquals("Jobs – Alchemy Jobs", title);

        driver.findElement(By.xpath("//input[@id=\"search_keywords\"]")).sendKeys("Banking");
        driver.findElement((By.xpath("//input[@type=\"submit\"]"))).click();

        //List<WebElement> list = driver.findElements(By.xpath("//*[@id='post-7']/div/div/ul[@class='job_listings']/li"));
        //System.out.println("list size :- "+list.size());
        WebElement firstEle = driver.findElement(By.xpath("//*[@id='post-7']/div/div/ul[@class='job_listings']/li[1]/a"));
        firstEle.click();
        WebElement buttonClick = driver.findElement(By.xpath("//*[@id=\"post-5867\"]/div/div/div/div[3]/input[@value='Apply for job']"));
        buttonClick.click();
        String emailText = driver.findElement(By.xpath("//*[@id=\"post-5867\"]/div/div/div/div[3]/div/p/a")).getText();
        System.out.println("Email mentioned :- "+ emailText);
        // Close the browser
        driver.close();

    }
}
