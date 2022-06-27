package config;
import org.aeonbits.owner.Config;


    @Config.Sources("classpath:browserstack.properties")
    public interface MobileBrowserstackConfig extends Config {


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

