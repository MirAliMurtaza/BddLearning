package StepsDefination;

import Screenpages.LoginAction;
import Utilities.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginTest extends LoginAction {
    static ConfigReader configReader = new ConfigReader();

    @Given("Goto Url")
    public void goto_url() {
        GotoUrl();
    }

    @Given("Enter username")
    public void enter_username() {
        enterUsername();  // Ensure this method correctly fills in the username
    }

    @Given("Enter invalid email")
    public void enter_invalid_email() {
        enterInvalidEmail();
    }

    @Given("Enter password")
    public void enter_password() {
        enterPassword();  // Ensure this method correctly fills in the password
    }

    @Given("Enter invalid password")
    public void enter_invalid_password() {
        enterInvalidPassword();
    }

    @When("Click login button")
    public void click_login_button() {
        clickLogin();  // Ensure this method correctly performs the click action
    }
}
