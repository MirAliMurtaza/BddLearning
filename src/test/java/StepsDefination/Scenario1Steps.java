package StepsDefination;

import General.GeneralFunction;
import Screenpages.HomePage;
import Screenpages.LoginPage;
import Utilities.ConfigReader;
import io.cucumber.java.en.*;

public class Scenario1Steps {

    private HomePage homePage = new HomePage();  // Assuming HomePage can operate without needing an instance of WebDriver
    private LoginPage loginPage = new LoginPage();  // Assuming LoginPage can operate without needing an instance of WebDriver
    private static ConfigReader configReader = new ConfigReader();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        GeneralFunction.GotoUrl();
        GeneralFunction.maximizeWindow();
        homePage.clickLoginButton();
    }

    @When("I log in with valid credentials")
    public void i_log_in_with_valid_credentials() {
        loginPage.enterUsername(configReader.getProperty("storeUserName"));
        loginPage.enterPassword(configReader.getProperty("storePass"));
        loginPage.clickLoginButton();
    }

    @When("I navigate to the homepage")
    public void i_navigate_to_the_homepage() {
        homePage.clickHomepageButton();
    }

    @When("I scroll to and select the newest Dove item")
    public void i_scroll_to_and_select_the_newest_dove_item() {
        homePage.scrollToDoveProducts();
        homePage.clickOnDoveProduct();
        homePage.clickSortByDovePage();
        homePage.selectSortByDovePage();
        homePage.clickFirstSortedItem();
    }

    @When("I add the item to the cart")
    public void i_add_the_item_to_the_cart() {
        homePage.clickAddToCartButton();
    }

    @Then("I should see the correct item and details in the cart")
    public void i_should_see_the_correct_item_and_details_in_the_cart() {
        homePage.verifyTotalAmountElement();
        homePage.verifyQuantityElement();
    }
}
