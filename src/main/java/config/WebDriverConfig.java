package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${environment}.properties")
public interface WebDriverConfig extends Config {

    @Key("webDriverBrowser")
    String WebDriverBrowser();

    @Key("remoteWebDriver")
    String RemoteWebDriverUrl();

    @Key("videoStorage")
    String VideoStorage();
}
