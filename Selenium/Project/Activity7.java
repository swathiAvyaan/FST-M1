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

public class Activity7 {


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

        driver.findElement(By.xpath("//input[@id=\"search_keywords\"]")).sendKeys("Banking");
        driver.findElement((By.xpath("//input[@type=\"submit\"]"))).click();

        //List<WebElement> list = driver.findElements(By.xpath("//*[@id='post-7']/div/div/ul[@class='job_listings']/li"));
        //System.out.println("list size :- "+list.size());
        WebElement firstEle = driver.findElement(By.xpath("//li[@id=\"menu-item-26\"]"));
        firstEle.click();

        WebElement emailField = driver.findElement((By.xpath("//*[@id='create_account_email']")));
        emailField.sendKeys("swathikbca@gmail.com");
        //emailField.sendKeys(Keys.CONTROL+"t");

        WebElement jobTitle = driver.findElement((By.xpath("//*[@id='job_title']")));
        jobTitle.sendKeys("Automation Test Engineer");
        // Close the browser
        // jobTitle.sendKeys(Keys.CONTROL+"t");

        WebElement location = driver.findElement((By.xpath("//*[@id='job_location']")));
        location.sendKeys("London");
        //location.sendKeys(Keys.CONTROL+"t");


//            WebElement drop=driver.findElement((By.xpath("//div[@class=\"field required-field\"]")));
//            drop.click();
        Select dropdown = new Select(driver.findElement(By.id("job_type")));
        dropdown.selectByVisibleText("Internship");
        //dropdown.selectByVisibleText("Full Time");
        //driver.findElement(By.id("job_type")).sendKeys(Keys.CONTROL+"t");
        System.out.println("selected job");
        // Thread.sleep(5000);
        WebElement framelink = driver.findElement(By.xpath("//*[(@id='job_description_ifr')]"));
        driver.switchTo().frame(framelink);
        System.out.println("switched to frame");
        WebElement description = driver.findElement((By.xpath("//*[@id='tinymce']/p")));
        //description.click();
        System.out.println("Clicked elements");
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000000));
        WebElement description1 = driver.findElement((By.xpath("//*[@id=\"mceu_16\"]")));
        description1.sendKeys("Working as tester");
        System.out.println("passed description");
        driver.switchTo().defaultContent();


        System.out.println("entered the text and back to form window");


        WebElement workURL = driver.findElement((By.xpath("//*[@id='application']")));
        workURL.sendKeys("test@gmail.com");


        WebElement company = driver.findElement((By.xpath("//*[@id='company_name']")));
        company.sendKeys("IBM");


        WebElement preview = driver.findElement((By.xpath("//input[@value='Preview']")));
        Thread.sleep(5000);
        preview.click();

        WebElement submitListing=driver.findElement((By.xpath("job_preview_submit_button")));
        submitListing.click();

        driver.close();

    }
}


