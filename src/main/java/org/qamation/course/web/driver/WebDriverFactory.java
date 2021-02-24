package org.qamation.course.web.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.qamation.course.config.Config;

public class WebDriverFactory {
    public static WebDriver getWebDriver(String browserName) {

        //
        if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", Config.getConfig().getChromeDriverPath());
            return new ChromeDriver();


        } else if (browserName.equalsIgnoreCase("Firefox")) {
            //
            System.setProperty("webdriver.gecko.driver", Config.getConfig().getFirefoxDriverPath());
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);

            return new FirefoxDriver();
        }
        return null;
    }
    }
