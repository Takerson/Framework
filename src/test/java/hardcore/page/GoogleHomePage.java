package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends AbstractPage {
    private static final String HOME_PAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@name = 'q']")
    private WebElement searchInput;
    @FindBy(xpath = "//div[@class='devsite-header--inner nocontent']")
    private WebElement frame;

    public GoogleHomePage(WebDriver driver){
        super(driver);
    }

    public GoogleHomePage openPage(){
        driver.get(HOME_PAGE_URL);
        return this;
    }

    public GoogleSearchListPage inputTextInSearchField(String searchTextx){
        webElementWaitToBeClickable(searchInput);
        searchInput.sendKeys(searchTextx);
        searchInput.submit();
        return new GoogleSearchListPage(driver);
    }
}
