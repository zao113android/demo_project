package pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginPage {

    public void openRegistration() {
        $("#header_register").click();
        $(byText("Create a free account")).should(exist);
    }

    public void openLogin() {
        $("#header_login").click();
        $(byText("Log In")).should(exist);
    }

    public void openMobileTab() {

        $("#tab-mobile").click();
    }

    public void setEmailData(String email) {
        $(byName("email")).click();
        $(byName("email")).val(email);
        sleep(2000);
    }

    public void setPhoneData(String phone) {
        $(byName("mobile")).click();
        $(byName("mobile")).val(phone);
        sleep(2000);
    }

    public void setPassword(String password) {
        $(byName("password")).click();
        $(byName("password")).setValue(password);
    }

    public void submitRegistration() {

        $("#click-registration-submit").click();
    }

    public void submitLogin() {

        $("#click_login_submit").click();
    }

    public void checkCorrectResult(String resultText) {

        $(byText(resultText)).should(exist);
    }

}
