package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:resources/properties/local.properties")
public interface LocalConfig extends Config {

    @Key("localDeviceName")
    @DefaultValue("Pixel 4 API 30")
    String getLocalDeviceName();

    @Key("localOsVersion")
    @DefaultValue("11.0")
    String getLocalOsVersion();

    @Key("LocalUrl")
    @DefaultValue("http://localhost:4723/wd/hub")
    String getLocalUrl();

    @Key("localPlatformName")
    @DefaultValue("Android")
    String getLocalPlatformName();
}




