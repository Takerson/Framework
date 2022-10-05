package hardcore.test;

import hardcore.driver.DriverSingleton;
import hardcore.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    @BeforeClass()
    public void setUp(){
        driver = DriverSingleton.getDriver();
    }

    @AfterClass
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}