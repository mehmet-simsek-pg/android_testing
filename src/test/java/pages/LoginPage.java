package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final AndroidDriver driver;
    private WebDriverWait wait;

    private final String emailInputXPATH = "//android.widget.EditText[@content-desc='input-email']";
    private final String passwordInputXPATH = "//android.widget.EditText[@content-desc='input-password']";
    private final String loginBtnXPATH = "//android.view.ViewGroup[@content-desc='button-LOGIN']";

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void fillLoginMask(String email, String password) {

        WebElement emailInput = driver.findElement(AppiumBy.xpath(emailInputXPATH));
        System.out.println(emailInput.getText());
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.click();
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(AppiumBy.xpath(passwordInputXPATH));
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void clickLoginBtn() {
        driver.findElement(AppiumBy.xpath(loginBtnXPATH)).click();
    }
}
