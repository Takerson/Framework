package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchListPage extends AbstractPage{

    @FindBy(xpath = "//a[@data-ctorig='https://cloud.google.com/products/calculator']")
    private WebElement chooseThePrisingCalculatorPageFromSearchList;

    public GoogleSearchListPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public GoogleCalculatorPage selectPricingCalculatorPageFromSearchList(){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(chooseThePrisingCalculatorPageFromSearchList));
        chooseThePrisingCalculatorPageFromSearchList.click();
        return new GoogleCalculatorPage(driver);
    }
}
