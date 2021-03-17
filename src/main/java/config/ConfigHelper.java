package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static AuthorizationConfig getAuthorizationConfig() {
        return ConfigFactory
                .newInstance()
                .create(AuthorizationConfig.class, System.getProperties());
    }

    public static WebDriverConfig getWebDriverConfig() {
        return ConfigFactory
                .newInstance()
                .create(WebDriverConfig.class, System.getProperties());
    }

    public static String getEmail() {

        return getAuthorizationConfig().email();
    }

    public static String getPassword() {

        return getAuthorizationConfig().password();
    }

    public static String getPhone() {

        return getAuthorizationConfig().phone();
    }

    public static String getWebDriverBrowser() {

        return getWebDriverConfig().WebDriverBrowser();
    }

    public static String getRemoteWebDriver() {

        return getWebDriverConfig().RemoteWebDriverUrl();
    }

    public static String getVideoStorage() {

        return getWebDriverConfig().VideoStorage();
    }
}
