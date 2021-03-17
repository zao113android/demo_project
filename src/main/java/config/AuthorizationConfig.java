package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:authorization.properties"
})
public interface AuthorizationConfig extends Config {

    @Config.Key("email")
    String email();

    @Config.Key("password")
    String password();

    @Config.Key("phone")
    String phone();
}
