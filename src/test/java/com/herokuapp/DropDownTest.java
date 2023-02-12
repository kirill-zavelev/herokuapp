package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest extends BaseTest {

    private static final String DROP_DOWN_ITEM_NAME = "//select/option[text()='%s']";
    private static final String URL = "http://the-internet.herokuapp.com/dropdown";

    @Test
    public void checkSelectAndUnselectItemFromDropdown() {
        boolean actualResult;
        final String firstItemName = "Option 1";
        final String secondItemName = "Option 2";
        driver.get(URL);
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select dropDownA = new Select(dropDown);
        Assert.assertNotNull(dropDownA.getOptions(), "Dropdown shouldn't be empty");
        dropDownA.selectByVisibleText(firstItemName);
        actualResult = driver.findElement(By.xpath(String.format(DROP_DOWN_ITEM_NAME, firstItemName))).isSelected();
        Assert.assertTrue(actualResult, firstItemName + " should be selected");
        dropDownA.selectByVisibleText(secondItemName);
        actualResult = driver.findElement(By.xpath(String.format(DROP_DOWN_ITEM_NAME, secondItemName))).isSelected();
        Assert.assertTrue(actualResult, secondItemName + " should be selected");
    }
}
