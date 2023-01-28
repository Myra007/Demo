package DriverFactory;

import AbstractComponents.DriverClassification;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriver implements DriverClassification {

    WebDriver driver;

    @Override
    public WebDriver initializeDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);

        String remoteExecution = System.getProperty("remote");

        if(remoteExecution.equalsIgnoreCase("yes")){
            //todo implement remote execution later
        }
        else{
            WebDriverManager.chromedriver().setup();
            driver = new org.openqa.selenium.firefox.FirefoxDriver(options);
        }

        return driver;
    }


}
