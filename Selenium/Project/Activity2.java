package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity2{
    public static void main(String[] args) throws InterruptedException{
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs/");

        System.out.println("Home page title: " + driver.getTitle());

//        // Find About Us link using id and click it
//        driver.findElement(By.id("about-link")).click();
//        // Print the title of the new page
//        System.out.println("About page title: " + driver.getTitle());
        String title = driver.getTitle();
        Assert.assertEquals("Alchemy Jobs – Job Board Application", title);
       String headingText= driver.findElement(By.xpath("//h1[text()='Welcome to Alchemy Jobs']")).getText();
        Assert.assertEquals("Welcome to Alchemy Jobs", headingText);
        System.out.println("heading matched");




        // Close the browser
        driver.close();
    }
}

