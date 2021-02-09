import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StartBrowser {

    private static final By SEARCH_FIELD_SELECTOR = By.cssSelector(".search-input__input");

    public static void main(String[] args) throws InterruptedException {

        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\.."+"\\drivers\\chrome\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+System.getProperty("chromeDriverPath"));
        System.setProperty("webdriver.chrome.driver", System.getProperty("chromeDriverPath"));
        // Instantiate a ChromeDriver class.
        WebDriver driver = new ChromeDriver();

        //Maximize the browser
        driver.manage().window().maximize();

        // Launch Website
        driver.navigate().to("http://loblaws.ca");

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_FIELD_SELECTOR));

        WebElement searchField = driver.findElement(SEARCH_FIELD_SELECTOR);
        searchField.sendKeys("apple");
        searchField.sendKeys(Keys.ENTER);

        driver.quit();



    }
}

