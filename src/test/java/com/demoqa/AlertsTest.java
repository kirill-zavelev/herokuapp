package com.demoqa;

import com.herokuapp.BaseTest;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    private static final String ACCEPT_ALERT = "accept";
    private static final String DISMISS_ALERT = "dismiss";

    @Test
    public void checkAlertsTextAndActions() {
        driver.get("https://demoqa.com/alerts");

        String expectedAlertText = "You clicked a button";
        By alert = By.id("alertButton");
        acceptOrDismissAlertAndVerifyText(alert, expectedAlertText, ACCEPT_ALERT);

        String expectedTimerAlertText = "This alert appeared after 5 seconds";
        By timerAlert = By.id("timerAlertButton");
        acceptOrDismissAlertAndVerifyText(timerAlert, expectedTimerAlertText, ACCEPT_ALERT);

        String expectedConfirmAlertText = "Do you confirm action?";
        By confirmAlert = By.id("confirmButton");
        acceptOrDismissAlertAndVerifyText(confirmAlert, expectedConfirmAlertText, DISMISS_ALERT);
        String expectedTextAfterAlertDismissing = "You selected Cancel";
        WebElement confirmResult = driver.findElement(By.id("confirmResult"));
        verifyTextAfterActionWithAlert(confirmResult, expectedTextAfterAlertDismissing);

        String expectedPromptAlertText = "Please enter your name";
        By promptAlert = By.id("promtButton");
        acceptOrDismissAlertAndVerifyText(promptAlert, expectedPromptAlertText, "Kirill", ACCEPT_ALERT);
        String promptResultExpectedText = "You entered Kirill";
        WebElement promptResult = driver.findElement(By.id("promptResult"));
        verifyTextAfterActionWithAlert(promptResult, promptResultExpectedText);
    }

    private void acceptOrDismissAlertAndVerifyText(By alert, String expectedAlertText, String alertAction) {
        driver.findElement(alert).click();
        String actualAlertText = wait.until(ExpectedConditions.alertIsPresent()).getText();
        Assertions.assertThat(actualAlertText)
                .isEqualTo(expectedAlertText)
                .as("Text in alert should be: " + expectedAlertText);
        acceptOrDismissAlert(alertAction);
    }

    private void acceptOrDismissAlertAndVerifyText(By alert, String expectedAlertText, String textToSetInAlertInput,
                                                   String alertAction) {
        driver.findElement(alert).click();
        String actualAlertText = wait.until(ExpectedConditions.alertIsPresent()).getText();
        Assertions.assertThat(actualAlertText)
                .isEqualTo(expectedAlertText)
                .as("Text in alert should be: " + expectedAlertText);
        driver.switchTo().alert().sendKeys(textToSetInAlertInput);
        acceptOrDismissAlert(alertAction);
    }

    private void acceptOrDismissAlert(String alertAction) {
        if (alertAction.equals("accept")) {
            driver.switchTo().alert().accept();
        } else {
            driver.switchTo().alert().dismiss();
        }
    }

    private void verifyTextAfterActionWithAlert(WebElement elementWithText, String expectedText) {
        String actualText = elementWithText.getText();
        Assertions.assertThat(actualText)
                .isEqualTo(expectedText)
                .as("Text after alert action should be: " + expectedText);
    }
}
