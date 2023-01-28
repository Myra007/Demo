package Base;

import DriverFactory.ChromeDriver;
import DriverFactory.DriverFactory;
import DriverFactory.FirefoxDriver;
import DriverFactory.SafariDriver;
import Page.Actions.Login;
import org.openqa.selenium.WebDriver;

public class InstanceManager {
    private static InstanceManager pom;


    private InstanceManager()
    {

    }
    public static InstanceManager getInstance()
    {
        if (pom == null){
            pom = new InstanceManager();
        }
        return pom;
    }
    public Login getLoginPage(WebDriver driver) {
      return new Login(driver);
    }

    public ChromeDriver getChromeDriver() {
        return new ChromeDriver();
    }

    public FirefoxDriver getFirefoxDriver() {
        return new FirefoxDriver();
    }

    public SafariDriver getSafariDriver() {
        return new SafariDriver();
    }

    public DriverFactory getDriverFactory() {
        return new DriverFactory();
    }

}
