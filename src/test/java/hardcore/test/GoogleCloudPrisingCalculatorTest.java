package hardcore.test;

import hardcore.model.Calculator;
import hardcore.page.CreatedEstimatePage;
import hardcore.page.EmailBoxPage;
import hardcore.page.GeneratedEmailPage;
import hardcore.page.GoogleHomePage;
import hardcore.services.CalculatorCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudPrisingCalculatorTest extends CommonConditions {
    private EmailBoxPage emailBox;
    private static final String SEARCH_TEXT = "Google Cloud Platform Pricing Calculator";

    @Test
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
                .enterACreatedEmailAndSendToEmail(GeneratedEmailPage.getEmailAddress())
                .switchToEmailTab()
                .checkEmailBox();
        Assert.assertEquals(emailBox.getEstimatedCostPerMonthFromEmailBox(), CreatedEstimatePage.getPriceInCalculator());
    }
}
