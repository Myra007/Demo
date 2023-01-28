package DriverFactory;

import AbstractComponents.DriverClassification;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

public class SafariDriver implements DriverClassification {

    WebDriver driver;

    @Override
    public WebDriver initializeDriver() {
        SafariOptions options = new SafariOptions();

        String remoteExecution = System.getProperty("remote");

        if(remoteExecution.equalsIgnoreCase("yes")){
            //todo implement remote execution later
        }
        else{
            WebDriverManager.safaridriver().setup();
            driver = new org.openqa.selenium.safari.SafariDriver(options);
        }

        return driver;
    }


}
