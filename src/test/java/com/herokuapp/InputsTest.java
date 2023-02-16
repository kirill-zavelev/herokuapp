package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputsTest extends BaseTest {

    private static final String INPUT_ELEMENT = "//input[@type='number']";
    private static final String URL = "http://the-internet.herokuapp.com/inputs";

    @Test
    public void checkPossibilityToRegulateInput() {
        driver.get(URL);
        String attribute = "value";
        String actualResult;
        driver.findElement(By.xpath(INPUT_ELEMENT)).sendKeys("1");
        actualResult = driver.findElement(By.xpath(INPUT_ELEMENT)).getAttribute(attribute);
        Assert.assertEquals(actualResult, "1", "field should contain '1' inside");
        WebElement element = driver.findElement(By.xpath(INPUT_ELEMENT));
        element.sendKeys(Keys.ARROW_UP);
        actualResult = driver.findElement(By.xpath(INPUT_ELEMENT)).getAttribute(attribute);
        Assert.assertEquals(actualResult, "2", "field should contain '2' inside");
        element.sendKeys(Keys.ARROW_DOWN);
        actualResult = driver.findElement(By.xpath(INPUT_ELEMENT)).getAttribute(attribute);
        Assert.assertEquals(actualResult, "1", "field should contain '1' inside");
    }
}
