import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Test1 {
    private static final By SEARCH_FIELD_SELECTOR = By.cssSelector(".search-input__input");

    public static void main(String[] args) {

        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\.."+"\\drivers\\chrome\\chromedriver.exe");

        // Instantiate a ChromeDriver class.
        WebDriver driver=new ChromeDriver();

        //Maximize the browser
        driver.manage().window().maximize();

        // Launch Website
        driver.navigate().to("http://loblaws.ca");

        WebDriverWait wait = new WebDriverWait(driver, 15);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15L), Duration.ofMillis(300));
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_FIELD_SELECTOR));

        WebElement searchField = driver.findElement(SEARCH_FIELD_SELECTOR);
        searchField.sendKeys("apple");
        searchField.sendKeys(Keys.ENTER);

        driver.quit();

    }

}
