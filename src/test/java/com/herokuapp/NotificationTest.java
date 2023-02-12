package com.herokuapp;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationTest extends BaseTest {

    @Test
    public void checkNotificationMessage() {
        String expectedText = "Action successful";
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.xpath("//a[text()='Click here']")).click();
        boolean isMessageSuccessful = driver.findElement(By.xpath("//div[@class='flash notice']")).getText().contains(expectedText);
        Assert.assertTrue(isMessageSuccessful);
    }
}
