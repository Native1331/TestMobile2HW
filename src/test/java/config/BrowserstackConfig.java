package config;
import org.aeonbits.owner.Config;

import java.net.URL;


@Config.Sources("classpath:resources/config/credential.properties")
    public interface BrowserstackConfig extends Config {
    @Key("deviceName")
    @DefaultValue("Google Pixel 3")
    String getDeviceName();

    @Key("osVersion")
    @DefaultValue("9.0")
    String getOsVersion();

    @Key("baseUrl")
    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String getBaseUrl();

    @Key("username")
    String getUsername();

    @Key("access_key")
    String getAccess_key();

    @Key("app")
    String getApp();

    @Key("deviceName")
    String getDeviceName();

    @Key("osVersion")
    String getOsVersion();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();

    @Key(" baseUrl")
    String getBaseUrl();

}


