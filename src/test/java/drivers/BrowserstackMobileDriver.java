package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {


    static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    String userValue= config.userValue();
    String keyValue=config. keyValue();
    String appValue=config.appValue();
    String modelOfApp=config.modelOfApp();
    String version=config.version();
    String projectValue=config.projectValue();
    String  buildValue=config.buildValue();
    String nameOfTest=config.nameOfTest();

    @Override
           public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", userValue);
        mutableCapabilities.setCapability("browserstack.key", keyValue);

        // Set URL of the application under test
//        mutableCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        mutableCapabilities.setCapability("app", appValue);

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", modelOfApp);
        mutableCapabilities.setCapability("os_version", version);

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", projectValue);
        mutableCapabilities.setCapability("build", buildValue);
        mutableCapabilities.setCapability("name", nameOfTest);
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }
    public static URL getBrowserstackUrl() {
         String urlValue=config.urlValue();
        try {
            return new URL(urlValue);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}