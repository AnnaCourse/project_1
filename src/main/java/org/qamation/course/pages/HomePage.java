package org.qamation.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    private static final By SEARCH_FIELD_SELECTOR = By.cssSelector(".search-input__input");

    public HomePage(WebDriver driver) {
        super(driver);
        driver.navigate().to("http://loblaws.ca");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15L), Duration.ofMillis(300));
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_FIELD_SELECTOR));
    }

    public SearchResultPage search(String something) {
        WebElement searchField = driver.findElement(SEARCH_FIELD_SELECTOR);
        searchField.sendKeys(something);
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }
}
