package Base;

import static CXEUtils.Constants.*;

import DriverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Base {

    private static Base base;

    private WebDriver driver;


    private Base(){}

    public static Base getInstance(){
        if(base == null){
            base = new Base();
        }
        return base;
    }

    public void initializeDriver(DriverFactory driverFactory){
        driver = driverFactory.getDriverClassification().initializeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
    }


    public WebDriver getDriver(){
        return driver;
    }


}
