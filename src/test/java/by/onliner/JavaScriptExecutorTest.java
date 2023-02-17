package by.onliner;

import com.herokuapp.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest extends BaseTest {

    @Test
    public void checkScrollOfTheMainPage() {
        driver.get("https://www.onliner.by/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)", "");
        WebElement elementToScrollTo = driver.findElement(By.id("onliner-best-layer"));
        js.executeScript("arguments[0].scrollIntoView(true);", elementToScrollTo);
        js.executeScript("window.scrollBy(0,document.documentElement.scrollHeight)");
        js.executeScript("window.scrollTo(0, 0);");
    }
}
