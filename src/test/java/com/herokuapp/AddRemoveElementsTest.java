package com.herokuapp;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveElementsTest extends BaseTest {

    private static final String BUTTON_NAME = "//button[text()='%s']";
    private static final String URL = "https://the-internet.herokuapp.com/add_remove_elements/";

    @Test
    public void checkThatElementCanBeAddedAndDeleted() {
        final int amountOfClicksForAddElementBtn = 2;
        final int amountOfClicksForDeleteElementBtn = 1;
        final String addElementButton = "Add Element";
        final String deleteElementButton = "Delete";
        driver.get(URL);
        clickButtonCertainAmountOfTimes(addElementButton, amountOfClicksForAddElementBtn);
        int actualSizeAfterAdd = driver.findElements(By.xpath(String.format(BUTTON_NAME, deleteElementButton))).size();
        Assert.assertEquals(actualSizeAfterAdd, amountOfClicksForAddElementBtn,
                "There should be 2 elements");
        clickButtonCertainAmountOfTimes(deleteElementButton, amountOfClicksForDeleteElementBtn);
        int actualSizeAfterDelete = driver.findElements(By.xpath(String.format(BUTTON_NAME, deleteElementButton))).size();
        Assert.assertEquals(actualSizeAfterDelete, amountOfClicksForDeleteElementBtn,
                "There should be 1 element");
    }

    private void clickButtonCertainAmountOfTimes(String buttonName, int amountOfTimes) {
        for (int i = 0; i < amountOfTimes; i++) {
            driver.findElement(By.xpath(String.format(BUTTON_NAME, buttonName))).click();
        }
    }
}
