package hardcore.test;

import hardcore.model.Calculator;
import hardcore.page.*;
import hardcore.services.CalculatorCreator;
import hardcore.services.SetUpAnEstimate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudPrisingCalculatorTest extends CommonConditions {
    private EmailBoxPage emailBox;
    private static final String SEARCH_TEXT = "Google Cloud Platform Pricing Calculator";

    @Test (description = "Create an estimate on the Google Cloud Pricing Calculator page. And compare " +
            "the price of an estimate from the Google Calculator page and the Email Box page")
    public void createNewEstimateAndCompareThePrice() {
        Calculator calculator = CalculatorCreator.createEstimate();
        GoogleSearchListPage googleSearchListPage = new GoogleHomePage(driver)
                .openPage()
                .inputTextInSearchField(SEARCH_TEXT)
                .selectPricingCalculatorPageFromSearchList();
        GoogleCalculatorPage setUpAnEstimate = new SetUpAnEstimate(driver)
                .setUpAnEstimate(calculator);
        emailBox = setUpAnEstimate
                .createAnEstimate()
                .createNewTabAndRotateToIt()
                .openMailGeneratorPage()
                .generateAnEmail()
                .copyAGeneratedEmailAddressAndSwitchToCalculatorPage()
                .clickOnEmailButton()
                .enterACreatedEmailAndSendToEmail(GeneratedEmailPage.getEmailAddress())
                .switchToEmailTab()
                .checkEmailBox();
        Assert.assertEquals(emailBox.getEstimatedCostPerMonthFromEmailBox(), CreatedEstimatePage.getPriceInCalculator(),
                "the price of the estimate in the \"Calculator\" and in the \"Email\" is different ");
    }
}