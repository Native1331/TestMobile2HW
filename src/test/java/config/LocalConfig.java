package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:resources/properties/local.properties")
public interface LocalConfig extends Config {

    @Key("deviceLocalName")
    @DefaultValue("Pixel 4 API 30")
    String getDeviceName();

    @Key("osLocalVersion")
    @DefaultValue("11.0")
    String getOsVersion();

    @Key("LocalUrl")
    @DefaultValue("http://localhost:4723/wd/hub")
    String getLocalUrl();

    @Key("platformName")
    @DefaultValue("Android")
    String getPlatformName();
}




