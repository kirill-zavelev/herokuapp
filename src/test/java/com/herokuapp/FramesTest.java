package com.herokuapp;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    @Test
    public void checkTextInFrame() {
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//a[text()='iFrame']")).click();
        driver.switchTo().frame("mce_0_ifr");
        String expectedText = "Your content goes here.";
        String actualText = driver.findElement(By.xpath("//body[@id='tinymce']/p")).getText();
        Assertions.assertThat(actualText)
                .isEqualTo(expectedText)
                .as("Text should be: '" + expectedText + "'");
    }
}
