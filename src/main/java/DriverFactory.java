
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static String SERVER_URL = "http://localhost:4444";

    public static RemoteWebDriver createInstance(String BrowserName) {
        DesiredCapabilities capabilities;

        switch (BrowserName) {
            case "ie":
                capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
                capabilities.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT, true);
                break;
            case "chrome":
                capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-bundled-ppapi-flash");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                break;
            case "firefox":
                capabilities = DesiredCapabilities.firefox();
                break;
            case "safari":
                capabilities = DesiredCapabilities.safari();
                break;
            default:
                capabilities = DesiredCapabilities.firefox();
                break;
        }
        capabilities.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, false);
        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "slow");
        capabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
        capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
        capabilities.setCapability(CapabilityType.SUPPORTS_LOCATION_CONTEXT, true);
        capabilities.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
        capabilities.setCapability(CapabilityType.SUPPORTS_WEB_STORAGE, true);

        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(SERVER_URL + "/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        return driver;
    }
}
