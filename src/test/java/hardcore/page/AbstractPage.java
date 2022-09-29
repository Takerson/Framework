package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected static final int WAIT_TIMEOUT_SECONDS = 10;
    protected static ArrayList<String> tab;

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
    }

    protected void webElementWaitToBeVisible(WebElement webElement){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void webElementWaitToBeClickable(WebElement webElement){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(webElement));
    }
}