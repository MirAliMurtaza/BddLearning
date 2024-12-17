package Screenpages;

import General.Elements;
import General.GeneralFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import java.util.List;

import static General.GeneralFunction.configReader;

public class ApparelsPage {

    public static void clickOnApparel() {
        GeneralFunction.clickElement(Elements.appsNaccs);
    }

    public static void clickOnShirts() {
        GeneralFunction.clickElement(Elements.tShirts);
    }

    public static void clickOnShoes() {
        GeneralFunction.clickElement(Elements.shoes);
    }

    public static void sortByRatingLowest() {
        GeneralFunction.selectDropDownByVisibleText(Elements.sortDropdown, "Rating Lowest");
    }

    public static void sortByHighestValue() {
        GeneralFunction.selectDropDownByVisibleText(Elements.sortDropdown, "Price High > Low");
    }

    public static void sortByMedium() {
        GeneralFunction.selectDropDownByVisibleText(Elements.mediumShirt, "Medium");
    }

    public static void addHighestValueProductToCart() {
        List<WebElement> products = GeneralFunction.findElements(Elements.productList);
        if (!products.isEmpty()) {
            WebElement viewLink = products.get(0).findElement(Elements.ChildElementShoe);
            viewLink.click();
            WebElement quantityInput = GeneralFunction.getElement(Elements.shoeQuantity, 10, 1000);
            quantityInput.clear();
            quantityInput.sendKeys("2");
            WebElement addToCartButton = GeneralFunction.getElement(Elements.innerBtn, 10, 1000);
            addToCartButton.click();
            System.out.println("Highest value product added to the cart with quantity 2.");
        } else {
            System.out.println("No products found.");
        }
    }

    public static void fetchShirts() {
        int count = 0;
        int processed = 0;

        sortByRatingLowest();

        WebElement parentElement = GeneralFunction.findElement(Elements.productList);
        List<WebElement> childElements = GeneralFunction.findChildElements(parentElement, Elements.productItems);

        if (childElements.size() < 3) {
            System.out.println("Not enough products to process.");
            return;
        }

        while (processed < 3) {
            // Re-fetch the product list after each navigation to ensure fresh elements
            parentElement = GeneralFunction.findElement(Elements.productList);
            childElements = GeneralFunction.findChildElements(parentElement, Elements.productItems);

            // Ensure the list still has enough products
            if (childElements.size() < processed + 1) {
                System.out.println("Product list has changed, not enough products to process.");
                break;
            }

            // Get the product at the current index
            WebElement product = childElements.get(processed);

            // Check if the product is out of stock
            if (!product.findElements(Elements.outOfStockPrdct).isEmpty()) {
                System.out.println("Product " + (processed + 1) + " is out of stock.");
                processed++;  // Move to the next product
                continue;
            }

            // Attempt to add to cart if the product has an "Add to Cart" button
            List<WebElement> addToCartButtons = product.findElements(Elements.addToCartBtn);
            if (!addToCartButtons.isEmpty()) {
                WebElement addToCartButton = addToCartButtons.get(0);
                addToCartButton.click();
                System.out.println("Product " + (processed + 1) + " found and clicked 'Add to Cart'");

                // Select medium size
                sortByMedium();
                System.out.println("Medium size selected");

                // Click inside cart
                WebElement innerCartBtn = GeneralFunction.findElement(Elements.innerBtn);
                innerCartBtn.click();
                System.out.println("Clicked 'Add to Cart' inside the product page");

                count++;
                System.out.println("Product added to cart. Count: " + count);

                // Navigate back twice to return to the product list
                GeneralFunction.navigateBack();
                System.out.println("Navigated back once");
                GeneralFunction.navigateBack();
                System.out.println("Navigated back twice");

                // Re-sort by rating lowest for the next iteration
                if (processed < 2) {  // If there are more products to process
                    sortByRatingLowest();
                    System.out.println("Re-sorted by 'Rating Lowest'");
                }
            } else {
                System.out.println("Product " + (processed + 1) + " does not have 'Add to Cart' button.");
            }

            // Increment 'processed' after each product is checked
            processed++;
        }
    }

    public static void verifyItemsInCart() {
        GeneralFunction.assertion(Elements.productDescriptionLocator1, "Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie");
        GeneralFunction.assertion(Elements.productDescriptionLocator2, "Fiorella Purple Peep Toes");

        System.out.println("Assertion passed: All specified items are correctly listed in the shopping cart.");
    }
}
