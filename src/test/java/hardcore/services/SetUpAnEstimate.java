package hardcore.services;

import hardcore.model.Calculator;
import hardcore.page.GoogleCalculatorPage;
import org.openqa.selenium.WebDriver;

public class SetUpAnEstimate extends GoogleCalculatorPage {
    private GoogleCalculatorPage createdEstimatePage;

    public SetUpAnEstimate(WebDriver driver) {
        super(driver);
    }

    public GoogleCalculatorPage setUpAnEstimate (Calculator calculator) {
        return createdEstimatePage = new GoogleCalculatorPage(driver)
                .setUpNumberOfInstance(calculator)
                .selectMachineType()
                .selectMachine(calculator)
                .addGPU()
                .selectGpuType(calculator)
                .setUpNumberOfGPUs(calculator)
                .selectLocalSSD(calculator)
                .choosingADatacenterLocal(calculator)
                .selectCommittedUsageDate(calculator);
    }
}