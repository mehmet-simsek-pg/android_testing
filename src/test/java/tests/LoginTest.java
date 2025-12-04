package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Navbar;

public class LoginTest extends BaseTest{

    @Test
    public void loginTest() {

        Navbar navbar = new Navbar(driver);
        LoginPage loginPage = new LoginPage(driver);

        navbar.clickLoginBtn();

        loginPage.waitForLoginPageLoaded();

        loginPage.fillLoginMask("test@example.com", "123456");
        loginPage.clickLoginBtn();
    }
}
