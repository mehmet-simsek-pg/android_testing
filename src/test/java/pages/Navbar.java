package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Navbar {

    private final AndroidDriver driver;
    private WebDriverWait wait;

    private final String loginBtnXPATH = "//android.widget.Button[@content-desc='Login']";

    public Navbar(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickLoginBtn() {
        // AppiumBy appium dan geliyor. AndroidDriver ve IOSDriver icin ortak kullanilan eleman
        // WebDriver da ise bunun yerine sadece By kullaniyorduk.
        WebElement element = driver.findElement(AppiumBy.xpath(loginBtnXPATH));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
