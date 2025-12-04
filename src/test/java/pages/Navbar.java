package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Navbar {

    private static final Logger log = LoggerFactory.getLogger(Navbar.class);
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
        log.info("Login butonuna tıklanıyor...");
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        driver.findElement(loginBtn).click();
        log.info("Login butonuna başarıyla tıklandı.");
    }
}
