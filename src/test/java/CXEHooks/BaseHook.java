package CXEHooks;

import java.util.Properties;

import CXEVoiceFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseHook {

    /*
     * public WebDriver driver;
     * protected DriverFactory df;
     * protected Properties
     * prop;
     * protected LoginPage loginpage;
     */
    @Before
    public static void setUp() {
        System.out.println("Inside Hooks");
        DriverFactory.setUpDriver();
        DriverFactory.initi_driver();
        //DriverFactory.openPage("https://10.12.49.77/user");
    }

    @After
    public void tearDown() {
        DriverFactory.tearDown();
    }

}
