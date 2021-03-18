package tests;

import config.ConfigHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Basic;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.*;

public class LoginTests extends TestBase {

    LoginPage loginPage = new LoginPage();
    Basic page = new Basic();

    @Test
    @DisplayName("User sees security check when signing up via email")
    void registrationViaEmailTest() {

        page.openUrl();
        sleep(2000);
        loginPage.openRegistration();
        sleep(2000);
        loginPage.setEmailData(ConfigHelper.getEmail());
        sleep(2000);
        loginPage.setPassword(ConfigHelper.getPassword());
        sleep(2000);
        loginPage.submitRegistration();
        loginPage.checkCorrectResult("Security Verification");
    }

    @Test
    @DisplayName("User can't log in without password")
    void cantLoginWithoutPassword() {

        page.openUrl();
        loginPage.openLogin();
        loginPage.setEmailData(ConfigHelper.getEmail());
        sleep(2000);
        loginPage.submitLogin();
        loginPage.checkCorrectResult("Please enter your password");
    }

    @Test
    @DisplayName("User sees security check when signing up via mobile phone")
    void registrationViaPhoneTest() {

        page.openUrl();
        loginPage.openRegistration();
        sleep(2000);
        loginPage.openMobileTab();
        sleep(2000);
        loginPage.setPhoneData(ConfigHelper.getPhone());
        sleep(2000);
        loginPage.setPassword(ConfigHelper.getPassword());
        sleep(2000);
        loginPage.submitRegistration();
        loginPage.checkCorrectResult("Security Verification");
    }
}
