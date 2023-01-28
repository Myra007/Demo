package StepDef;

import Base.Base;
import Base.InstanceManager;
import DriverFactory.DriverFactory;
import io.cucumber.java.Before;


public class Hooks {

    @Before
    public void setUp() {

        String browser = System.getProperty("browser");
        Base base = Base.getInstance();
        DriverFactory factory = InstanceManager.getInstance().getDriverFactory();


        switch (browser.toLowerCase()) {
            case "chrome":
                factory.setDriverClassification(InstanceManager.getInstance().getChromeDriver());
                break;
            case "firefox":
                factory.setDriverClassification(InstanceManager.getInstance().getFirefoxDriver());
                break;
            case "safari":
                factory.setDriverClassification(InstanceManager.getInstance().getSafariDriver());
                break;
            default:
                throw new RuntimeException("We don't support this browser : " + browser + ". Only supported browsers are Chrome and Firefox.");
        }

        base.initializeDriver(factory);
    }


}
