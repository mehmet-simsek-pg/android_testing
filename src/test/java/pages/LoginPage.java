package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

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

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        WebElement emailEl = driver.findElement(emailInput);
        emailEl.click();
        emailEl.sendKeys(email);

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        WebElement passwordEl = driver.findElement(passwordInput);
        passwordEl.click();
        passwordEl.sendKeys(password);
    }

    public void clickLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        driver.findElement(loginBtn).click();
    }
}
