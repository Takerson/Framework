package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    }

    public CreatedEstimatePage copyAGeneratedEmailAddressAndSwitchToCalculatorPage(){
        webElementWaitToBeVisible(copyAGeneratedEmailAddressButton);
        emailAddress = copyAGeneratedEmailAddressButton.getText();
        driver.switchTo().window(tab.get(0));
        return new CreatedEstimatePage(driver);
    }

    public EmailBoxPage checkEmailBox(){
        webElementWaitToBeClickable(checkEmailBoxButton);
        checkEmailBoxButton.click();
        webElementWaitToBeClickable(checkEmailBoxButton);
        checkEmailBoxButton.click();
        return new EmailBoxPage(driver);
    }
}
