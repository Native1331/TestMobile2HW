package config;


import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credential.properties")
public interface CredentialsConfig extends Config {
    String userValue();
    String keyValue();
    String appValue();
    String modelOfApp();
    String version();
    String projectValue();
    String  buildValue();
    String nameOfTest();
    String urlValue();
}



