package CXEVoiceFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static final long TIMEOUT = 15;
    private static DriverFactory df;
    private static WebDriver driver;

    private DriverFactory() {
    }
    /* This method is used to initialize the driver */
    public static void initi_driver(){
        Properties prop=init_prop();
        String browser_name = prop.getProperty("browser").trim();
        System.out.println("Given browser is:" +browser_name);
        switch(browser_name){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.setAcceptInsecureCerts(true);
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Enter the correct browser name");
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }


    /*private DriverFactory(){

        Properties prop=init_prop();
        String browserChoosen=prop.getProperty("browser");

        switch(browserChoosen) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();

                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            break;
            default:
            System.out.println("Enter the correct browser name");
        }

}*/
    public static void openPage(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }
    public static void setUpDriver() {
        if (df==null) {
            df = new DriverFactory();
        }
    }
    public static void tearDown() {

        if(driver!=null) {
            //driver.close();
            driver.quit();
        }

        df = null;
    }
    /* This method is used to load the properties from config.properties file */

    private static Properties init_prop() {
        Properties prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
            try {
                prop.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return prop;

    }

}

