package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchListPage extends AbstractPage{

    @FindBy(xpath = "//a[@data-ctorig='https://cloud.google.com/products/calculator']")
    private WebElement chooseThePrisingCalculatorPageFromSearchList;

    public GoogleSearchListPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public GoogleCalculatorPage selectPricingCalculatorPageFromSearchList(){
        webElementWaitToBeClickable(chooseThePrisingCalculatorPageFromSearchList);
        chooseThePrisingCalculatorPageFromSearchList.click();
        return new GoogleCalculatorPage(driver);
    }
}
