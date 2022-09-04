package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneratedEmail extends AbstractPage {
    public static String emailAddress;

    @FindBy(id = "egen")
    private WebElement copyAGeneratedEmailAddressButton;
    @FindBy(xpath = "//button[@onclick = 'egengo();']")
    private WebElement checkEmailBoxButton;


    public GeneratedEmail(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public CreatedEstimate copyAGeneratedEmailAddressAndSwitchToCalculatorPage(){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(copyAGeneratedEmailAddressButton));
        emailAddress = copyAGeneratedEmailAddressButton.getText();
        driver.switchTo().window(tab.get(0));
        return new CreatedEstimate(driver);
    }

    public EmailBox checkEmailBox(){
        checkEmailBoxButton.click();
        return new EmailBox(driver);
    }
}
