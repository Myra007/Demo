package Page.Actions;

import CXEUtils.Constants;
import CXEUtils.Elementutil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private By usernameField = By.cssSelector(".cxl-username .cxl-input-text-field");
    private By securityCodeField = By.cssSelector(".cxl-password .cxl-input-text-field");
    private By serverDds = By.cssSelector(".cxl-server-list .cxl-select .cxl-input-select");
    private By signInButton = By.cssSelector(".cxl-login-button");
    private By incorrectCredentialsErrorMessage = By.xpath("//div[contains(@class, 'cxl-logon-info')]/div[2]");
    private By inbox = By.xpath("//span[text()='Inbox']");
    private Elementutil elementutil;
    private WebDriver driver;
    //private Page.Locators.Login login;

    public Login(WebDriver driver) {
        this.driver = driver;
        elementutil = new Elementutil(driver);
        //login = new Page.Locators.Login();
    }

    public void signIn(String username, String securityCode, String serverName){
        elementutil.waitForElementVisible(usernameField, 5);
        System.out.println("Entering username");
        elementutil.doSendKeys(usernameField, username);
        System.out.println("Entering security code");
        elementutil.doSendKeys(securityCodeField, securityCode);
        System.out.println("Selecting dropdown");
        elementutil.doSelectDropDownByValue(serverDds, serverName);
        System.out.println("Click on Sign In button");
        elementutil.doClick(signInButton);
    }

    public String getErrorMessage() {
        elementutil.waitForElementVisible(incorrectCredentialsErrorMessage, 5);
        String errMsg = elementutil.doGetElementText(incorrectCredentialsErrorMessage);
        return errMsg;
    }

    public void  seeText(){
        elementutil.waitForElementVisible(inbox, Constants.DEFAULT_TIME_OUT);
    }
}
