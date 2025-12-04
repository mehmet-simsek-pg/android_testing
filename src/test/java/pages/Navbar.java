package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Navbar {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    private final By loginBtn = AppiumBy.xpath("//android.widget.Button[@content-desc='Login']");

    public Navbar(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickLoginBtn() {
        // AppiumBy appium dan geliyor. AndroidDriver ve IOSDriver icin ortak kullanilan eleman
        // WebDriver da ise bunun yerine sadece By kullaniyorduk.
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        WebElement element = driver.findElement(loginBtn);
        element.click();
    }
}
