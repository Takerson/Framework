package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage extends AbstractPage {
    private static final String HOME_PAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@name = 'q']")
    private WebElement searchInput;
    @FindBy(xpath = "//div[@class='devsite-header--inner nocontent']")
    private WebElement frame;

    public GoogleHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public GoogleHomePage openPage(){
        driver.get(HOME_PAGE_URL);
        return this;
    }

    public GoogleSearchListPage inputTextInSearchField(String searchTextx){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(searchInput)).sendKeys(searchTextx);
        searchInput.submit();
        return new GoogleSearchListPage(driver);
    }
}
