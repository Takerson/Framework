package hardcore.page;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected static final int WAIT_TIMEOUT_SECONDS = 10;
    protected static ArrayList<String> tab;

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
    }
}
