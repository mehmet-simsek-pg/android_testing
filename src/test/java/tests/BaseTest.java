package tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.BaseDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup() throws MalformedURLException, URISyntaxException {
        BaseDriver.initDriver(); // bu satirda static Android driver kuruldu
        driver = BaseDriver.getDriver(); // burada ise bu sayfadaki driver a Android driver i atadik
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @AfterMethod
    public void tearDown() {
        BaseDriver.quitDriver();
    }
}
