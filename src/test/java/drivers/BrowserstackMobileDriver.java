package drivers;
import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class);

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", BrowserstackConfig.username());
        mutableCapabilities.setCapability("browserstack.key", BrowserstackConfig.access_key());
        mutableCapabilities.setCapability("app", BrowserstackConfig.app());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", BrowserstackConfig.device());
        mutableCapabilities.setCapability("os_version", BrowserstackConfig.osVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", BrowserstackConfig.project());
        mutableCapabilities.setCapability("build", BrowserstackConfig.build());
        mutableCapabilities.setCapability("name", BrowserstackConfig.name());
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(BrowserstackConfig.baseUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}