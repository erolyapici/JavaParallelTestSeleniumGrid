import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Created by eyapici on 03/01/16.
 */
public class BaseTest{
    public String browser;
    public ITestContext context;
    private String testName;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(Method m, String browser) {
        this.browser = browser;

    }

    @BeforeTest
    public void beforeTest(ITestContext context) {
        this.context = context;
    }

    @AfterMethod
    public void afterEachTest(ITestResult result) {
        DriverManager.getDriver().quit();
    }

    @AfterSuite
    public void afterSuite() {
        //TODO

    }
}
