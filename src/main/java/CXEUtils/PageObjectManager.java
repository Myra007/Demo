package CXEUtils;

import Page.Actions.Login;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private static PageObjectManager pom;

    private PageObjectManager()
    {

    }
    public static PageObjectManager getInstance()
    {
        if (pom == null){
            pom = new PageObjectManager();
        }
        return pom;
    }
    public Login getLoginPage(WebDriver driver) {
      return new Login(driver);
    }
}
