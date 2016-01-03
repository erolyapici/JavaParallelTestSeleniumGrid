
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
    private static ThreadLocal<RemoteWebDriver> webDriver = new ThreadLocal<RemoteWebDriver>();

    public static RemoteWebDriver getDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(RemoteWebDriver driver) {
        webDriver.set(driver);
    }
}
