package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneratedEmailPage extends AbstractPage {
    private static String emailAddress;

    public static String getEmailAddress() {
        return emailAddress;
    }

    @FindBy(id = "egen")
    private WebElement copyAGeneratedEmailAddressButton;
    @FindBy(xpath = "//button[@onclick = 'egengo();']")
    private WebElement checkEmailBoxButton;


    public GeneratedEmailPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public CreatedEstimatePage copyAGeneratedEmailAddressAndSwitchToCalculatorPage(){
        webElementWaitToBeVisible(copyAGeneratedEmailAddressButton);
        emailAddress = copyAGeneratedEmailAddressButton.getText();
        driver.switchTo().window(tab.get(0));
        return new CreatedEstimatePage(driver);
    }

    public EmailBoxPage checkEmailBox(){
        checkEmailBoxButton.click();
        return new EmailBoxPage(driver);
    }
}
