package hardcore.services;

import hardcore.model.Calculator;

public class CalculatorCreator {
    public static final String NUMBER_OF_INSTANCE = "numberOfInstance";
    public static final String MACHINE_TYPE = "machineType";
    public static final String GPU_TYPE = "GPUType";
    public static final String NUMBER_OF_GPU = "numberOfGPU";
    public static final String LOCAL_SSD = "localSSD";
    public static final String DATACENTER_LOCATION = "datacenterLocation";
    public static final String COMMITTED_USAGE = "committedUsage";

    public static Calculator createEstimate(){
        return new Calculator(TestDataReader.getTestData(NUMBER_OF_INSTANCE),
                TestDataReader.getTestData(MACHINE_TYPE),
                TestDataReader.getTestData(GPU_TYPE),
                TestDataReader.getTestData(NUMBER_OF_GPU),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(DATACENTER_LOCATION),
                TestDataReader.getTestData(COMMITTED_USAGE));
    }
}
