package StepsDefination;

import io.cucumber.java.en.*;
import Screenpages.ApparelsPage;
import General.GeneralFunction;

public class Scenario2Steps {

    @Given("I am logged in and on the homepage")
    public void i_am_logged_in_and_on_the_homepage() {
        GeneralFunction.GotoUrl();
        GeneralFunction.maximizeWindow();
    }

    @When("I navigate to the APPAREL & ACCESSORIES section and select Tshirts")
    public void i_navigate_to_the_apparel_and_accessories_section_and_select_tshirts() {
        ApparelsPage.clickOnApparel();
        ApparelsPage.clickOnShirts();
    }

    @And("I sort items by Rating Lowest and add top 3 low rated T-shirts to the cart ensuring size is Medium")
    public void i_sort_items_by_rating_lowest_and_add_top_3_low_rated_t_shirts_to_the_cart_ensuring_size_is_medium() {
        ApparelsPage.sortByRatingLowest();
        ApparelsPage.fetchShirts(); // Assumes fetchShirts handles sorting and adds only medium sizes
    }

    @And("I navigate back to APPAREL & ACCESSORIES and select Shoes")
    public void i_navigate_back_to_apparel_and_accessories_and_select_shoes() {
        ApparelsPage.clickOnApparel();
        ApparelsPage.clickOnShoes();
    }

    @And("I add the highest value shoe to the cart with quantity 2")
    public void i_add_the_highest_value_shoe_to_the_cart_with_quantity_2() {
        ApparelsPage.sortByHighestValue();
        ApparelsPage.addHighestValueProductToCart();
    }

    @Then("I verify the items in the cart")
    public void i_verify_the_items_in_the_cart() {
        ApparelsPage.verifyItemsInCart();
    }
}
