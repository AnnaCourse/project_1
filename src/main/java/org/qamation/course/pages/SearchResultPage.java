package org.qamation.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends BasePage{
    private static By counterLocator = By.xpath("(//*[@class='tab__counter'])[1]");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public int found() {
        List<WebElement> els = driver.findElements(counterLocator);
        if (els.size()==1) {
            WebElement el = els.get(0);
            String content = el.getText();

        }
        throw new RuntimeException("Too many elements found for counter.");
    }

    public void sortLowToHigh() {

    }
    public void sortHighToLow() {

    }

}
