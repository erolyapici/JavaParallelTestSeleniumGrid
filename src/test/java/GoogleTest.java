import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by eyapici on 03/01/16.
 */
public class GoogleTest extends BaseTest{

    @Test
    public void searchGoogle(){

        DriverManager.getDriver().get("http://www.google.com");
        DriverManager.getDriver().findElement(By.cssSelector("#lst-ib")).sendKeys("Türkiye");
        DriverManager.getDriver().findElement(By.name("btnG")).click();

        String result = DriverManager.getDriver().findElement(By.cssSelector("#rso > div:nth-child(1) > div:nth-child(1) > div > h3 > a")).getText();

        Assert.assertTrue(result != null);
    }

}
