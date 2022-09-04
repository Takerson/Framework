package hardcore.page;

import hardcore.model.Calculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCalculatorPage extends AbstractPage{

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstance;

    @FindBy(xpath = "//md-card-content[@id='mainForm']//label[text() = 'Series']/following-sibling::md-select")
    private WebElement seriesField ;
    @FindBy(xpath = "//md-option[@value='n1']")
    private WebElement selectSeriesN1;

    @FindBy(xpath = "//md-card-content[@id='mainForm']//label[text() = 'Machine type']/following-sibling::md-select")
    private WebElement machineType ;
    String selectMachineType = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-%s']";

    @FindBy(xpath = "//div[contains(text(),'Add GPUs')]//preceding-sibling::div")
    private WebElement GPUsCheckBox ;
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement GPUTypeField;
    String selectGPUType = "//md-option[@value='%s']";

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUField;
    String selectNumberOfGPUField = "//md-option[@value='%s'][@ng-repeat = 'item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]']";

    @FindBy(xpath = "//md-select[@ng-model ='listingCtrl.computeServer.ssd']")
    private WebElement localSSDField;
    String selectLocalSSD = "//md-option[@ng-repeat ='item in listingCtrl.dynamicSsd.computeServer' and @value ='%s']";

    @FindBy(xpath = "//md-select[@ng-model ='listingCtrl.computeServer.location']")
    private WebElement dataCenterLocationField;
    String selectDataCenterLocation = "//md-option[@ng-repeat ='item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer' and @value ='%s']";

    @FindBy(xpath = "//md-select[@placeholder='Committed usage' and @ng-model = 'listingCtrl.computeServer.cud']")
    private WebElement committedUsageField;
    String selectCommittedUsage = "//md-select-menu[contains(@style, 'transform-origin')]//div[text()='%s']/parent::md-option";

    @FindBy(xpath = "//button[not(@disabled)][contains(text(),'Add to Estimate')]")
    private WebElement addToEstimateButton;
    @FindBy(xpath = "//button[contains(text(),'Email')]")
    private WebElement emailButton;

    @FindBy(xpath = "//input[@name = 'description' and @type = 'email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//article[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement parentFrame;
    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement frame;


    public GoogleCalculatorPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public GoogleCalculatorPage setUpNumberOfInstance(Calculator calculator)  {
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(parentFrame));
        driver.switchTo().frame(parentFrame);
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(frame));
        driver.switchTo().frame(frame);
        numberOfInstance.sendKeys(calculator.getNumberOfInstance());
        return this;
    }

    public GoogleCalculatorPage selectMachineType()  {
        seriesField.click();
        webElementWaitToBeClickableWithClick(selectSeriesN1);
        return this;
    }

    public GoogleCalculatorPage selectMachine(Calculator calculator) {
        machineType.click();
        stringFormatToList(selectMachineType,calculator.getMachineType());
        return this;
    }

    public GoogleCalculatorPage addGPU(){
        GPUsCheckBox.click();
        return this;
    }

    public GoogleCalculatorPage selectGpuType(Calculator calculator){
        webElementWaitToBeClickableWithClick(GPUTypeField);
        stringFormatToList(selectGPUType,calculator.getGPUType());
        return this;
    }

    public GoogleCalculatorPage setUpNumberOfGPUs(Calculator calculator){
        numberOfGPUField.click();
        stringFormatToList(selectNumberOfGPUField,calculator.getNumberOfGPU());
        return this;
    }

    public GoogleCalculatorPage selectLocalSSD(Calculator calculator){
        localSSDField.click();
        stringFormatToList(selectLocalSSD,calculator.getLocalSSD());
        return this;
    }

    public GoogleCalculatorPage choosingADatacenterLocal(Calculator calculator){
        dataCenterLocationField.click();
        stringFormatToList(selectDataCenterLocation,calculator.getDatacenterLocation());
        return this;
    }

    public GoogleCalculatorPage selectCommittedUsageDate(Calculator calculator){
        committedUsageField.click();
        stringFormatToList(selectCommittedUsage,calculator.getCommittedUsage());
        return this;
    }

    public CreatedEstimate createAnEstimate(){
        addToEstimateButton.click();
        return new CreatedEstimate(driver);
    }

    public void webElementWaitToBeClickableWithClick(WebElement webElement){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public void stringFormatToList(String xpath, String valueOfXpath){
        WebElement element = new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).
                until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(xpath,valueOfXpath))));
        element.click();
    }
}
