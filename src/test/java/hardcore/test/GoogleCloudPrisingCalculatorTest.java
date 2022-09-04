package hardcore.test;

import hardcore.model.Calculator;
import hardcore.page.CreatedEstimate;
import hardcore.page.EmailBox;
import hardcore.page.GeneratedEmail;
import hardcore.page.GoogleHomePage;
import hardcore.services.CalculatorCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudPrisingCalculatorTest extends CommonConditions {
    EmailBox emailBox;
    protected static final String SEARCH_TEXT = "Google Cloud Platform Pricing Calculator";

    @Test()
    public void createNewEstimateAnd() {
        Calculator calculator = CalculatorCreator.createEstimate();
        emailBox = new GoogleHomePage(driver)
                .openPage()
                .inputTextInSearchField(SEARCH_TEXT)
                .selectPricingCalculatorPageFromSearchList()
                .setUpNumberOfInstance(calculator)
                .selectMachineType()
                .selectMachine(calculator)
                .addGPU()
                .selectGpuType(calculator)
                .setUpNumberOfGPUs(calculator)
                .selectLocalSSD(calculator)
                .choosingADatacenterLocal(calculator)
                .selectCommittedUsageDate(calculator)
                .createAnEstimate()
                .createNewTabAndRotateToIt()
                .openMailGeneratorPage()
                .generateAnEmail()
                .copyAGeneratedEmailAddressAndSwitchToCalculatorPage()
                .clickOnEmailButton()
                .enterACreatedEmailAndSendToEmail(GeneratedEmail.emailAddress)
                .switchToEmailTab()
                .checkEmailBox();
        Assert.assertEquals(emailBox.getEstimatedCostPerMonthFromEmailBox(), CreatedEstimate.priceInCalculator);
    }
}
