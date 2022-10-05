package hardcore.test;

import hardcore.model.Calculator;
import hardcore.page.CreatedEstimatePage;
import hardcore.page.GoogleHomePage;
import hardcore.page.GoogleSearchListPage;
import hardcore.services.CalculatorCreator;
import hardcore.services.SetUpAnEstimate;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckSetUpTest extends CommonConditions {
    private CreatedEstimatePage setUpAnEstimate;
    private String searchText = "Google Cloud Platform Pricing Calculator";
    private String numberOfInstance = "4 x";
    private String vmClass = "Provisioning model: Regular";
    private String instanceType = "Instance type: n1-standard-8\nCommitted Use Discount applied";
    private String region = "Region: Frankfurt";
    private String localSSD = "Local SSD: 2x375 GiB\nCommitted Use Discount applied";
    private String commitmentTerm = "Commitment term: 1 Year";
    private String priceForMonth = "Total Estimated Cost: USD 1,840.40 per 1 month";

    @BeforeClass
    public void setUpAnEstimate() {
        Calculator calculator = CalculatorCreator.createEstimate();
        GoogleSearchListPage createdEstimate = new GoogleHomePage(driver)
                .openPage()
                .inputTextInSearchField(searchText)
                .selectPricingCalculatorPageFromSearchList();
        setUpAnEstimate = new SetUpAnEstimate(driver)
                .setUpAnEstimate(calculator)
                .createAnEstimate();
    }

    @Test
    public void verificationNumberOfInstance() {
        Assert.assertEquals(numberOfInstance,setUpAnEstimate.getNumberOfInstance(),"the value " +
                "of the \"Number of instance\" field from the estimate does not match the expected value");
    }

    @Test
    public void verificationRegion(){
        Assert.assertEquals(region,setUpAnEstimate.getRegion(),"the value of " +
                "the \"Region\" field from the estimate does not match the expected value");
    }

    @Test
    public void verificationInstanceType(){
        Assert.assertEquals(instanceType,setUpAnEstimate.getInstanceType(),"the value " +
                "of the \"Instance type\" field from the estimate does not match the expected value");
    }

    @Test
    public void verificationVmClass(){
        Assert.assertEquals(vmClass,setUpAnEstimate.getVmClass(), "the value of" +
                " the \"Vm class\" field from the estimate does not match the expected value");
    }

    @Test
    public void verificationLocalSSD(){
        Assert.assertEquals(localSSD,setUpAnEstimate.getLocalSSD(),"the value of " +
                "the \"Local SSD\" field from the estimate does not match the expected value");
    }

    @Test
    public void verificationCommitmentTerm(){
        Assert.assertEquals(commitmentTerm,setUpAnEstimate.getCommittedTerm(),"the value of" +
                " the \"Commitment term\" field from the estimate does not match the expected value");
    }

    @Test
    public void verificationPriceForMonth(){
        Assert.assertEquals(priceForMonth,setUpAnEstimate.getPriceForMonth(),"the value of" +
                " the \"Price for month\" field from the estimate does not match the expected value");
    }
}