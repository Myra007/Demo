package DriverFactory;

import AbstractComponents.DriverClassification;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriver implements DriverClassification {

    WebDriver driver;

    @Override
    public WebDriver initializeDriver() {

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        String remoteExecution = System.getProperty("remote");

        if(remoteExecution.equalsIgnoreCase("yes")){
            //todo implement remote execution later
        }
        else{
            WebDriverManager.chromedriver().setup();
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }

        return driver;
    }
}
