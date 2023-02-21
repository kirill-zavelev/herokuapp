package com.herokuapp;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void checkDynamicControls() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        By checkBox = By.id("checkbox");
        Assertions.assertThat(isElementPresent(checkBox)).isTrue().as("Checkbox should be visible");
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        By checkBoxMessageLocator = By.id("message");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(checkBoxMessageLocator, "It's gone!"));
        Assertions.assertThat(isElementPresent(checkBox))
                .isFalse()
                .as("Checkbox should not be visible");
        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertThat(input.isEnabled())
                .isFalse()
                .as("Input field should be disabled");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        By inputMessageLocator = By.xpath("//form[@id='input-example']/p");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(inputMessageLocator, "It's enabled!"));
        Assertions.assertThat(input.isEnabled())
                .isTrue()
                .as("Input field should be enabled");
    }

    private boolean isElementPresent(By checkBoxLocator) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        if (driver.findElements(checkBoxLocator).size() == 0) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return false;
        } else {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return true;
        }
    }
}
