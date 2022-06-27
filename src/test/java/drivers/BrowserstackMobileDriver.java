package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.CredentialsConfig;
import config.MobileBrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    static MobileBrowserstackConfig mobileBrowserstackConfig = ConfigFactory.create(MobileBrowserstackConfig.class);
    static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    static String userName = config.user();
    static String password = config.key();
    static String appBrowserstack = config.appBrowserstack();
    String deviceName = mobileBrowserstackConfig.getDeviceName();
    String osVersion = mobileBrowserstackConfig.getOsVersion();
    static String browserstackUrl = mobileBrowserstackConfig.getBaseUrl();

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", userName);
        mutableCapabilities.setCapability("browserstack.key", password);

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", appBrowserstack);

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", deviceName);
        mutableCapabilities.setCapability("os_version", osVersion);

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "Mobile Autotest Example");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "selenide android test");
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(browserstackUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}