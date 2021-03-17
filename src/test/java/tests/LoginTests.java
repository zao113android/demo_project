package tests;

import config.ConfigHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Basic;
import pages.LoginPage;

public class LoginTests extends TestBase {

    LoginPage loginPage = new LoginPage();
    Basic page = new Basic();

    @Test
    @DisplayName("User sees security check when signing up via email")
    void registrationViaEmailTest() {

        page.openUrl();
        loginPage.openRegistration();
        loginPage.setEmailData(ConfigHelper.getEmail());
        loginPage.setPassword(ConfigHelper.getPassword());
        loginPage.submitRegistration();
        loginPage.checkCorrectResult("Security Verification");
    }

    @Test
    @DisplayName("User can't log in without password")
    void cantLoginWithoutPassword() {

        page.openUrl();
        loginPage.openLogin();
        loginPage.setEmailData(ConfigHelper.getEmail());
        loginPage.submitLogin();
        loginPage.checkCorrectResult("Please enter your password");
    }

    @Test
    @DisplayName("User sees security check when signing up via mobile phone")
    void registrationViaPhoneTest() {

        page.openUrl();
        loginPage.openRegistration();
        loginPage.openMobileTab();
        loginPage.setPhoneData(ConfigHelper.getPhone());
        loginPage.setPassword(ConfigHelper.getPhone());
        loginPage.submitRegistration();
        loginPage.checkCorrectResult("Security Verification");
    }
}
