package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import static helpers.DriverHelper.getConsoleLogs;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;

public class HomePageTests extends TestBase {

    @Test
    @DisplayName("Page should have title")
    void titleHomePageTest() {

        step("Open the main page", () ->
                open("https://www.binance.com/"));

        step("Check title", () ->
                $("h1").shouldHave(text("Buy & sell Crypto in minutes")));
    }

    @Test
    @DisplayName("User can change the language")
    void languageHomePage() {

        step("Open the main page", () ->
                open("https://www.binance.com/"));

        step("Open languages", () ->
                $(byText("English")).click());

        step("Choose another language", () ->
                $$("button").find((text("Русский"))).click());

        step("Check the result", () ->
                $("h1")
                        .shouldHave(text("Покупайте криптовалюту за рубли в считаные минуты")));
    }

    @Test
    @DisplayName("FAQ is opened from menu")
    void correctCurrencyPageIsOpenedTest() {

        step("Open the main page", () ->
                open("https://www.binance.com/"));

        step("Find and click on support block", () ->
                $(byText("24 / 7 Support")).parent().click());

        step("Check result", () -> {
                $(byText("FAQ")).should(exist);
                $(byText("FAQ")).shouldHave(href("/en/support/faq"));
        });
    }

    @Test
    @DisplayName("Console log should not have any errors")
    void consoleLogShouldNotHaveErrors() {
        step("Open the main page", () ->
                open("https://www.binance.com/"));

        step("Get logs", () -> {
                String consoleLogs = getConsoleLogs();
                assertThat(consoleLogs, not(containsString("SEVERE")));
        });

    }
}
