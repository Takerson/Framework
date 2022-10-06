package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailBoxPage extends AbstractPage{

    @FindBy(id = "refresh")
    private WebElement refreshButton;
    @FindBy(xpath = "//h3[contains(text(),'USD')]")
    private WebElement estimatedMonthlyCost;
    @FindBy(id = "ifmail")
    private WebElement frame;


    public EmailBoxPage(WebDriver driver){
        super(driver);
    }

    public EmailBoxPage refreshEmailBox(){
        webElementWaitToBeVisible(refreshButton);
        webElementWaitToBeClickable(refreshButton);
        refreshButton.click();
        webElementWaitToBeClickable(refreshButton);
        refreshButton.click();
        return this;
    }

    public String getEstimatedCostPerMonthFromEmailBox(){
        webElementWaitToBeClickable(refreshButton);
        refreshButton.click();
        webElementWaitToBeVisible(frame);
        driver.switchTo().frame(frame);
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeSelected(estimatedMonthlyCost));
        webElementWaitToBeVisible(estimatedMonthlyCost);
        return estimatedMonthlyCost.getText().replaceAll("[a-zA-Z\\s]","").trim();
    }
}
