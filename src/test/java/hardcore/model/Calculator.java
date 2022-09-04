package hardcore.model;

import java.util.Objects;

public class Calculator {
    private String numberOfInstance;
    private String machineType;
    private String GPUType;
    private String numberOfGPU;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;

    public Calculator(String numberOfInstance, String machineType, String GPUType,
                      String numberOfGPU, String localSSD, String datacenterLocation, String committedUsage) {
        this.numberOfInstance = numberOfInstance;
        this.machineType = machineType;
        this.GPUType = GPUType;
        this.numberOfGPU = numberOfGPU;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstance() {
        return numberOfInstance;
    }

    public void setNumberOfInstance(String numberOfInstance) {
        this.numberOfInstance = numberOfInstance;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getGPUType() {
        return GPUType;
    }

    public void setGPUType(String GPUType) {
        this.GPUType = GPUType;
    }

    public String getNumberOfGPU() {
        return numberOfGPU;
    }

    public void setNumberOfGPU(String numberOfGPU) {
        this.numberOfGPU = numberOfGPU;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(numberOfInstance, that.numberOfInstance) &&
                Objects.equals(machineType, that.machineType) &&
                Objects.equals(GPUType, that.GPUType) &&
                Objects.equals(numberOfGPU, that.numberOfGPU) &&
                Objects.equals(localSSD, that.localSSD) &&
                Objects.equals(datacenterLocation, that.datacenterLocation) &&
                Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstance, machineType, GPUType, numberOfGPU, localSSD, datacenterLocation, committedUsage);
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "numberOfInstance='" + numberOfInstance + '\'' +
                ", machineType='" + machineType + '\'' +
                ", GPUType='" + GPUType + '\'' +
                ", numberOfGPU='" + numberOfGPU + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }
}
