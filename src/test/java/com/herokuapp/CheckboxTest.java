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
        Assert.assertTrue(firstCheckBox.isEnabled());
        firstCheckBox.click();
        Assert.assertTrue(firstCheckBox.isSelected());
        Assert.assertTrue(secondCheckBox.isSelected());
        secondCheckBox.click();
        Assert.assertTrue(secondCheckBox.isEnabled());
    }
}
