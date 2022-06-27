package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:credentials.properties")
public interface CredentialsConfig extends Config {
    String user();
    String key();
    String appBrowserstack();
}



