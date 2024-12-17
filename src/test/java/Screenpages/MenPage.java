package Screenpages;

import General.Elements;
import General.GeneralFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.HashSet;

public class MenPage {

    public static void goToMenSection() {
        GeneralFunction.GotoUrl();
        GeneralFunction.maximizeWindow();
        GeneralFunction.clickElement(Elements.menSectionLink);
    }

    public static void addProductsEndingWithMToCart() {
        HashSet<String> processedProducts = new HashSet<>();
        int initialCount = Elements.MenitemsAddedToCartCount; // Track how many were added at the start

        try {
            while (true) {
                // Re-locate product elements each iteration
                List<WebElement> products = GeneralFunction.findElements(Elements.productNames);

                boolean foundNewProduct = false;

                for (WebElement product : products) {
                    String productName = product.getText().trim();

                    // Only consider products ending with 'M' and not processed before
                    if (productName.endsWith("M") && !processedProducts.contains(productName)) {
                        foundNewProduct = true;
                        GeneralFunction.scrollToElement(product);
                        product.click();

                        try {
                            WebElement addToCartButton = GeneralFunction.waitUntilElementVisible(Elements.addToCartButtonOnProductPage);
                            addToCartButton.click();
                            Elements.MenitemsAddedToCartCount++;
                            processedProducts.add(productName); // Mark this product as processed
                            System.out.println("Added to cart: " + productName);

                            // Navigate back twice to return to the product list
                            GeneralFunction.navigateBack();
                            GeneralFunction.navigateBack();

                        } catch (TimeoutException | StaleElementReferenceException e) {
                            System.out.println("Skipping, out of stock or page issue: " + productName);
                            // Mark this product as processed to avoid retrying
                            processedProducts.add(productName);

                            // Navigate back once to return to the list
                            GeneralFunction.navigateBack();
                        }

                        // Re-wait until the list is visible before processing the next product
                        GeneralFunction.waitUntilElementVisible(Elements.productNames);

                        // Break out of the for-loop after processing a single product
                        // (to force a re-fetch of fresh elements in the next iteration)
                        break;
                    }
                }

                // If no new product was found in this iteration, end the loop
                if (!foundNewProduct) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error processing items: " + e.getMessage());
            e.printStackTrace();
        }

        // Print how many were added during this run
        System.out.println("Total products added this run: " + (Elements.MenitemsAddedToCartCount - initialCount));
    }



    public static void checkCartItemsEndWithM() {
        if (Elements.MenitemsAddedToCartCount == 0) {
            System.out.println("No items were added to the cart. Skipping cart checks.");
            return;
        }

        GeneralFunction.clickElement(Elements.cartBtn);
        GeneralFunction.waitForElementVisible(By.id("cart_checkout1"), 10, 500);
        List<WebElement> cartItems = GeneralFunction.findElements(Elements.cartProductNames);

        int itemsInCart = cartItems.size();
        System.out.println("Total items in cart: " + itemsInCart);

        if (itemsInCart != Elements.MenitemsAddedToCartCount) {
            throw new AssertionError("Number of items in cart does not match expected.");
        }

        for (WebElement item : cartItems) {
            String itemName = item.getText();
            System.out.println("Item in cart: " + itemName);
            if (!itemName.endsWith("M")) {
                throw new AssertionError("Item name does not end with 'M': " + itemName);
            }
        }

        System.out.println("All items in the cart end with 'M'.");
    }
}