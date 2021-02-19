import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qamation.course.config.Config;
import org.qamation.course.config.ConfigFF;


public class Test1 {
    private static final By SEARCH_FIELD_SELECTOR = By.cssSelector(".search-input__input");

    public static void main(String[] args) {

        System.setProperty("env",args[0]);
//
        String env = args[0];
        String browserName = args[1];
        Config config = Config.getConfig();


        WebDriver driver = WebDriverFactory.getWebDriver(browserName);}

        private static class WebDriverFactory {
            public static WebDriver getWebDriver(String browserName) {

                //
                if (browserName.equalsIgnoreCase("Chrome")) {
                    //
                    WebDriver driver = new ChromeDriver();

                    return new ChromeDriver();
                }
                //
                else if (browserName.equalsIgnoreCase("Firefox")) {
                    //
                    System.setProperty("webdriver.gecko.driver", ConfigFF.getConfig().getFirefoxDriverPath());
                    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                    capabilities.setCapability("marionette", true);
                    WebDriver driver = new FirefoxDriver();

                    return new FirefoxDriver();
                }

                //Maximize the browser
                WebDriver driver = new FirefoxDriver();
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

                return driver;

            }

        }
    }

        
