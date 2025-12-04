package util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class BaseDriver {

    private static AndroidDriver driver;

    private BaseDriver() { // Baska classlar icerisinden new leme yapilamasin
    }

    public static void initDriver() throws URISyntaxException, MalformedURLException {

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
