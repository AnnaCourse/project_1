package org.qamation.course.pages;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class SearchPageTests {
    WebDriver driver;

    @BeforeAll
    public void setUp() {
        driver = ....
        HomePage = new Home(driver)
    }

    @AfterAll
    public void  tearDown() {}

    @Test
    public void testFoundCounter() {
        SearchResultPage res = homepage.search(.....)
        Assertions.assertEquals(399,res.found());
    }


}
