package Screenpages;

import General.Elements;
import General.GeneralFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    public void clickLoginButton(){
        GeneralFunction.clickElement(Elements.loginbtn);
    }

    public void clickHomepageButton(){
        GeneralFunction.clickElement(Elements.homepagebtn);
    }

    public void scrollToDoveProducts(){
        GeneralFunction.scrollToElement(Elements.doveProducts);
    }

    public void clickOnDoveProduct(){
        GeneralFunction.clickElement(Elements.doveProducts);
    }

    public void clickSortByDovePage(){
        GeneralFunction.clickElement(Elements.sortbyDovePage);
    }

    public void selectSortByDovePage(){
        GeneralFunction.selectDropDownByVisibleText(Elements.sortbyDovePage, "Date New > Old");
    }

    public void clickFirstSortedItem(){
        GeneralFunction.clickSpecificElementFromList(Elements.listOfSortedItems, 0);
    }

    public void clickAddToCartButton(){
        GeneralFunction.clickElement(Elements.addToCartButtonPrdct);
    }


    public void verifyQuantityElement(){
        boolean isVisible = GeneralFunction.isElementPresent(Elements.itemQuantity);
        if (!isVisible) {
            throw new AssertionError("Quantity element is not displayed as expected.");
        }
    }

    private WebElement retryFindElement(By locator) {
        GeneralFunction GeneralFunctions = new GeneralFunction();
        WebDriverWait wait = new WebDriverWait(GeneralFunctions.getDriver(), Duration.ofSeconds(10));
        int attempts = 0;
        while (attempts < 3) {
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } catch (TimeoutException e) {
                System.out.println("Attempt " + (attempts + 1) + ": waiting for element to be visible");
            }
            attempts++;
        }
        throw new TimeoutException("Element with locator: " + locator + " could not be found after 3 attempts.");
    }

    public void verifyTotalAmountElement() {
        WebElement amountElement = retryFindElement(Elements.itemTotalAmount);
        String actualAmount = amountElement.getText();
        String expectedAmount = "$7.00";
        if (!actualAmount.equals(expectedAmount)) {
            throw new AssertionError("Expected amount: " + expectedAmount + ", but found: " + actualAmount);
        }
    }
}
