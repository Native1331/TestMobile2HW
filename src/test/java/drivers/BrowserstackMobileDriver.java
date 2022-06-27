package drivers;
package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import owner.StackOwner;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    static StackOwner configBrowserStack = ConfigFactory.create(StackOwner.class);

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", configBrowserStack.username());
        mutableCapabilities.setCapability("browserstack.key", configBrowserStack.access_key());
        mutableCapabilities.setCapability("app", configBrowserStack.app());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", configBrowserStack.device());
        mutableCapabilities.setCapability("os_version", configBrowserStack.osVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", configBrowserStack.project());
        mutableCapabilities.setCapability("build", configBrowserStack.build());
        mutableCapabilities.setCapability("name", configBrowserStack.name());
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(configBrowserStack.baseUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}