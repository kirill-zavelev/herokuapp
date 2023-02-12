package com.herokuapp;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TyposTest extends BaseTest {

    @Test
    public void checkTypoInText() {
        String element = "//p/following-sibling::p";
        String actualText;
        String expectedText = "Sometimes you'll see a typo, other times you won't.";
        driver.get("http://the-internet.herokuapp.com/typos");
        actualText = driver.findElement(By.xpath(element)).getText();
        Assert.assertEquals(actualText, expectedText);
        driver.navigate().refresh();
        actualText = driver.findElement(By.xpath(element)).getText();
        Assert.assertEquals(actualText, expectedText);
    }
}
