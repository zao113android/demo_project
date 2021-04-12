package pages;

import static com.codeborne.selenide.Selenide.open;

public class BasicPage {

    public void openUrl() {
        open("https://www.binance.com/");
    }
}
