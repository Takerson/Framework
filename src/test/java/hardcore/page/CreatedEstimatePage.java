package hardcore.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreatedEstimatePage extends AbstractPage {
    private String textWithoutRegex;
    private static String priceInCalculator;

    public static String getPriceInCalculator() {
        return priceInCalculator;
    }

    // get data about estimate
    @FindBy(xpath = "//*[contains(text(),'Total Estimated Cost:')]")
    private WebElement priceForMonth;
    @FindBy(xpath = "//*[@id='compute']/md-list/div/div/div/span/span")
    private WebElement numberOfInstance;
    @FindBy(xpath = "//div[contains(text(),'Region: ')]")
    private WebElement region;
    @FindBy(xpath = "//div[contains(text(),'Instance type: ')]")
    private WebElement instanceType;
    @FindBy(xpath = "//div[contains(text(),'Provisioning model: ')]")
    private WebElement vmClass;
    @FindBy(xpath = "//div[contains(text(),'Local SSD: ')]")
    private WebElement localSSD;
    @FindBy(xpath = "//div[contains(text(),'Commitment term')]")
    private WebElement committedTerm;


    // sending data about estimate to email
    @FindBy(xpath = "//button[contains(text(),'Email')]")
    private WebElement emailButton;
    @FindBy(xpath = "//input[@name = 'description' and @type = 'email']")
    private WebElement emailInputField;
    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//article[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement parentFrame;
    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement frame;

    public CreatedEstimatePage(WebDriver driver){
        super(driver);
    }

    public MailFor10MinHomePage createNewTabAndRotateToIt(){
        ((JavascriptExecutor) driver).executeScript("window.open()");
        tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        return new MailFor10MinHomePage(driver);
    }

    public CreatedEstimatePage clickOnEmailButton(){
        webElementWaitToBeVisible(parentFrame);
        driver.switchTo().frame(parentFrame);
        webElementWaitToBeVisible(frame);
        driver.switchTo().frame(frame);

        textWithoutRegex = priceForMonth.getText();
        regExPrice();
        webElementWaitToBeClickable(emailButton);
        emailButton.click();
        return this;
    }

    public CreatedEstimatePage enterACreatedEmailAndSendToEmail(String email){
        webElementWaitToBeVisible(emailInputField);
        emailInputField.sendKeys(email);
        webElementWaitToBeClickable(sendEmailButton);
        sendEmailButton.click();
        return this;
    }

    public GeneratedEmailPage switchToEmailTab(){
        driver.switchTo().window(tab.get(1));
        return new GeneratedEmailPage(driver);
    }

    public String regExPrice(){
        Pattern pattern = Pattern.compile("([0-9]{1,9}),([0-9]{3})?.([0-9]+)");
        Matcher matcher = pattern.matcher(priceForMonth.getText());
        if(matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            priceInCalculator = textWithoutRegex.substring(start, end);
        }
        return priceInCalculator;
    }




    public String getNumberOfInstance() {
        webElementWaitToBeClickable(numberOfInstance);
        return numberOfInstance.getText().trim();
    }

    public String getRegion() {
        webElementWaitToBeClickable(region);
        return region.getText().trim();
    }

    public String getInstanceType() {
        webElementWaitToBeClickable(instanceType);
        return instanceType.getText().trim();
    }

    public String getVmClass() {
        webElementWaitToBeClickable(vmClass);
        return vmClass.getText().trim();
    }

    public String getLocalSSD() {
        webElementWaitToBeClickable(localSSD);
        return localSSD.getText().trim();
    }

    public String getPriceForMonth() {
        webElementWaitToBeClickable(priceForMonth);
        return priceForMonth.getText().trim();
    }

    public String getCommittedTerm() {
        webElementWaitToBeClickable(committedTerm);
        return committedTerm.getText().trim();
    }
}
