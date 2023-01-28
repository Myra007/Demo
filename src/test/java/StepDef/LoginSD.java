package StepDef;

import CXEUtils.PageObjectManager;
import CXEVoiceFactory.DriverFactory;
import Page.Actions.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSD {

    WebDriver driver;
    PageObjectManager pageObjectManager = PageObjectManager.getInstance();
    Login login;

    public LoginSD() {
//        this.driver = DriverFactory.getDriver();
//        login = pageObjectManager.getLoginPage(driver);
//        System.out.println("Inside Login Constructor");
    }

    @Given("User is on the login page of cxe {string}")
    public void user_is_on_the_login_page_of_cxe(String url) {
        DriverFactory.openPage(url);
        login = new Login(DriverFactory.getDriver());
        System.out.println("On the login page");
    }

    @When("User enters username {string} security code {string} server {string}")
    public void user_enters_username_security_code_server(String username, String securityCode, String serverName) {
        login.signIn(username, securityCode, serverName);
    }

    @Then("User is logged in successfully")
    public void user_is_logged_in_successfully() {
        login.seeText();
        System.out.println("Login Successful");


    }

    @Then("Error message is thrown")
    public void error_message_is_thrown() {
        System.out.println("Login Failed");
        String expected = "Username or security code entered incorrectly. Please try again.";
        String actual = login.getErrorMessage();
        Assert.assertEquals(expected, actual);
    }

}
