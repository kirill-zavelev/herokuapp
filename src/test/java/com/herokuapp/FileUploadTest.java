package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    @Test
    public void checkFileUpload() {
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys(System.getProperty("user.dir")
                + "/src/test/resources/photoTest.jpg");
        driver.findElement(By.id("file-submit")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("uploaded-files"), "photoTest.jpg"));
    }
}
