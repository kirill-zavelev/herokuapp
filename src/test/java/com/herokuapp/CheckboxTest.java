package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {

    @Test
    public void checkAndUncheckCheckBox() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckBox = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement secondCheckBox = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        Assert.assertTrue(firstCheckBox.isEnabled(), "First check box should be enabled");
        firstCheckBox.click();
        Assert.assertTrue(firstCheckBox.isSelected(), "First check box should be selected");
        Assert.assertTrue(secondCheckBox.isSelected(), "Second check box should be selected");
        secondCheckBox.click();
        Assert.assertTrue(secondCheckBox.isEnabled(), "Second check box should be enabled");
    }
}
