package com.herokuapp;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    @Test
    public void checkAlert() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();
        Alert alert = driver.switchTo().alert();
        String expectedAlertText = "You selected a context menu";
        Assertions.assertThat(alert.getText())
                .as("'" + expectedAlertText + "' should be displayed in alert")
                .isEqualTo(expectedAlertText);
        alert.getText();
    }
}
