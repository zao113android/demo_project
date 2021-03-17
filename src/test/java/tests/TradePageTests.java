package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TradePageTests extends TestBase {

    @Test
    @Disabled
    @DisplayName("Page Exchange is opened from menu")
    void correctCurrencyPageIsOpenedTest() {

        open("https://www.binance.com/");

        $("header").find("div",0).hover();
        $("#Exchange").click();
        $("h1").shouldHave(text("BTC/USDT"));
    }
}
