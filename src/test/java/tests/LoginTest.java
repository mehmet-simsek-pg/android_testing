package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Navbar;

public class LoginTest extends BaseTest{

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @Test
    public void loginTest() {

        log.info("Login test başlıyor...");

        Navbar navbar = new Navbar(driver);
        LoginPage loginPage = new LoginPage(driver);

        navbar.clickLoginBtn();
        log.debug("Login sayfasına geçildi.");

        loginPage.fillLoginMask("test@example.com", "123456");
        log.debug("Login formu dolduruldu.");

        loginPage.clickLoginBtn();
        log.info("Login butonuna basıldı, test tamamlandı.");
    }
}
