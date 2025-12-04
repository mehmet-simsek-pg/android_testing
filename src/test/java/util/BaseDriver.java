package util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class BaseDriver {

    private static final Logger log = LoggerFactory.getLogger(BaseDriver.class);

    private static AndroidDriver driver;

    private BaseDriver() { // Baska classlar icerisinden new leme yapilamasin
    }

    public static void initDriver() throws URISyntaxException, MalformedURLException {

        if (driver != null) {
            log.warn("Driver zaten ayarlı, yeniden oluşturulmayacak.");
            return;
        }

        log.info("Android driver oluşturuluyor...");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android Emulator"); // Eger gercek cihazda test yapiyorsak, bu ismi degismemiz lazim.
        // Örn. Samsung Galaxy S7 gibi
        options.setAppPackage("com.wdiodemoapp");
        options.setAppActivity("com.wdiodemoapp.MainActivity");

        // Android driver bizden bir url birde capabilities istiyor.
        // URL appium un calistigi url olacak, capabilities ise appium inspectorda kullandigimiz
        // field ler olacak.
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        log.info("Android driver başarıyla başlatıldı.");
    }

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Bir sonraki testte driver null olarak isleme baslasin
        }
    }
}
