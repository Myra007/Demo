package DriverFactory;

import AbstractComponents.DriverClassification;

public class DriverFactory {

    private DriverClassification driverClassification;

    public void setDriverClassification(DriverClassification driverClassification){
        this.driverClassification = driverClassification;
    }

    public DriverClassification getDriverClassification(){
        return driverClassification;
    }

}
