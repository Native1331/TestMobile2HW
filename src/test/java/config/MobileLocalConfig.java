package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:browserstack.properties")
public interface MobileLocalConfig extends Config {


    @Key("deviceLocalName")
    @DefaultValue("Pixel 4 API 30")
    String getDeviceName();

    @Key("osLocalVersion")
    @DefaultValue("11.0")
    String getOsVersion();

    @Key("baseLocalUrl")
    @DefaultValue("http://localhost:4723/wd/hub")
    String getBaseUrl();

    @Key("platformName")
    @DefaultValue("Android")
    String getPlatformName();


}