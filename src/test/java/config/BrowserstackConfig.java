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


}


