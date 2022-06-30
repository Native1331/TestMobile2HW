package config;


import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/credential.properties"
})

public interface CredentialsConfig extends Config {
    String server();
    String keyValue();
    String project ();
    String build();
    String name();
    String app();
    String device();
    String osVersion();
    String baseUrl();


}




