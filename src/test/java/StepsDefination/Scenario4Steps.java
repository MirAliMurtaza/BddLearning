package StepsDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Screenpages.MenPage;

public class Scenario4Steps {

    @Given("I am on the men's section of the store")
    public void i_am_on_the_mens_section_of_the_store() {
        MenPage.goToMenSection();
    }

    @When("I add products ending with M to the cart")
    public void i_add_products_ending_with_m_to_the_cart() {
        MenPage.addProductsEndingWithMToCart();
    }

    @Then("I should see that all items in the cart end with M")
    public void i_should_see_that_all_items_in_the_cart_end_with_m() {
        MenPage.checkCartItemsEndWithM();
    }
}
