package by.onliner;

import com.herokuapp.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class FramesTest extends BaseTest {

    @Test
    public void checkElementNameIsDisplayedInSearch() {
        driver.get("https://www.onliner.by/");
        driver.findElement(By.xpath("//input[@class='fast-search__input']"))
                .sendKeys("Тостер");
        WebElement modalFrame = driver.findElement(By.xpath("//iframe[@class='modal-iframe']"));
        driver.switchTo().frame(modalFrame);
        List<WebElement> itemsNames = driver.findElements(By.xpath("//div[@class='product__title']/a"));
        String firstItemName = itemsNames.stream()
                .map(WebElement::getText)
                .findFirst()
                .orElse("");
        By frameSearchInputWithText = By.xpath("//span[@class='text_match']");
        WebElement frameSearchInputField = driver.findElement(By.xpath("//input[@class='search__input']"));
        frameSearchInputField.clear();
        frameSearchInputField.sendKeys(firstItemName);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(frameSearchInputWithText, firstItemName));
    }
}
