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

public class LoginPage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    private final AndroidDriver driver;
    private WebDriverWait wait;

    private final By emailInput = AppiumBy.xpath("//android.widget.EditText[@content-desc='input-email']");
    private final By passwordInput = AppiumBy.xpath("//android.widget.EditText[@content-desc='input-password']");
    private final By loginBtn = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='button-LOGIN']");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void waitForLoginPageLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
    }

    public void fillLoginMask(String email, String password) {

        log.info("Login formu dolduruluyor: email={}, password length={}", email, password.length());

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        driver.findElement(emailInput).sendKeys(email);
        log.debug("Email alanı dolduruldu.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);
        log.debug("Password alanı dolduruldu.");
    }

    public void clickLoginBtn() {
        log.info("Login butonuna tıklanıyor...");
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        driver.findElement(loginBtn).click();
        log.info("Login butonuna başarıyla tıklandı.");
    }
}
