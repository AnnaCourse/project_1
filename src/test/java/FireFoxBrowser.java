import org.openqa.selenium.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FireFoxBrowser {

    public static final By SEARCH_FIELD_SELECTOR = By.cssSelector(".search-input__input");

    public static void main (String[] args) throws InterruptedException {


        // System Property for Gecko Driver
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\.."+"\\drivers\\firefox\\geckodriver.exe" );

        // Initialize Gecko Driver using Desired Capabilities Class
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette",true);
        WebDriver driver= new FirefoxDriver();

        //Maximize the browser
        driver.manage().window().maximize();

        // Launch Website
        driver.navigate().to("https://www.loblaws.ca/");

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_FIELD_SELECTOR));

        WebElement searchField = driver.findElement(SEARCH_FIELD_SELECTOR);
        searchField.sendKeys("apple");
        searchField.sendKeys(Keys.ENTER);

        driver.quit();
    }

}

