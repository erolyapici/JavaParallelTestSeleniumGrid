
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.Map;

/**
 * Created by eyapici on 21/12/15.
 */
public class TestListener extends TestListenerAdapter implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
            Map<String, String> parameters = iInvokedMethod.getTestMethod().getXmlTest().getTestParameters();

            String browserName = parameters.get("browser");

            RemoteWebDriver driver = DriverFactory.createInstance(browserName);
            DriverManager.setWebDriver(driver);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }
}
