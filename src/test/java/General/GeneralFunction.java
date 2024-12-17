package General;

import BaseTest.BaseTest;
import Utilities.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class GeneralFunction {
    protected static WebDriver driver;
    public static ConfigReader configReader = new ConfigReader();

    // Initialize the WebDriver if it's not already initialized
    public static void setDriver() {
        if (driver == null) {
            driver = BaseTest.getDriver(configReader.getProperty("browser"));
        }
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized");
        }
        return driver;
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebElement waitUntilElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));  // Adjust the timeout as necessary
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void scrollToElement(WebElement element) {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.out.println("Error scrolling to element: " + e.getMessage());
            throw new RuntimeException("Unable to scroll to element: " + e.getMessage());
        }
    }

    public static void GotoUrl() {
        driver.navigate().to(configReader.getProperty("url"));
    }

    public static WebElement waitForElementVisibleAndReturn(By locator, Duration timeout, Duration pollingInterval) {
        WebDriverWait wait = new WebDriverWait(driver, timeout, pollingInterval);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void assertion(By locator, String expected) {
        try {
            WebElement element = waitForElementVisibleAndReturn(locator, Duration.ofSeconds(10), Duration.ofMillis(500));
            String actual = element.getText();
            if (!actual.equals(expected)) {
                throw new AssertionError("Expected text: '" + expected + "' but found: '" + actual + "'");
            }
        } catch (NoSuchElementException e) {
            throw new AssertionError(String.format("The element %s is not found on the screen", locator), e);
        } catch (TimeoutException e) {
            throw new AssertionError(String.format("The element %s was not visible within the time limit", locator), e);
        } catch (StaleElementReferenceException e) {
            throw new AssertionError(String.format("The element %s is stale", locator), e);
        } catch (InvalidElementStateException e) {
            throw new AssertionError(String.format("The element %s is not in a state to accept interactions", locator), e);
        } catch (Exception e) {
            throw new AssertionError(String.format("An error occurred while asserting text for the element %s", locator), e);
        }
    }

    public static void waitForElementVisible(By locator, int time, int interval) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time), Duration.ofMillis(interval));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement getElement(By locator, int time, int interval) {
        waitForElementVisible(locator, time, interval);
        return driver.findElement(locator);
    }

    public static void sendKeys(By locator, String value) {
        WebElement element = getElement(locator, 10, 1000);
        if (element != null) {
            element.sendKeys(value);
        } else {
            throw new IllegalStateException("Failed to find element to send keys: " + locator);
        }
    }

    public static void clickElement(By locator) {
        WebElement element = getElement(locator, 10, 1000);
        if (element != null) {
            element.click();
        } else {
            throw new IllegalStateException("Failed to find element to click: " + locator);
        }
    }

    public static void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public static void clickSpecificElementFromList(By locator, int index) {
        List<WebElement> elements = findElements(locator);
        if (index >= 0 && index < elements.size()) {
            elements.get(index).click();
        } else {
            throw new IllegalArgumentException("The index " + index + " is out of bounds for the list of elements found by " + locator);
        }
    }

    public static void scrollToElement(By locator) {
        WebElement element = getElement(locator, 10, 1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static WebElement findElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("Element not found: " + locator);
        }
    }

    // New Method: Find multiple WebElements
    public static List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public static List<WebElement> findChildElements(WebElement parentElement, By childLocator) {
        try {
            return parentElement.findElements(childLocator);
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("No child elements found using locator: " + childLocator);
        }
    }

    // New Method: Navigate back in the browser history
    public static void navigateBack() {
        driver.navigate().back();
    }

    public static boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void selectDropDownByVisibleText(By locator, String visibleText) {
        WebElement dropdownElement = getElement(locator, 10, 1000);
        new Select(dropdownElement).selectByVisibleText(visibleText);
    }

    public static void mouseHover(By by) {
        WebElement element = getElement(by, 10, 1000);
        new Actions(driver).moveToElement(element).perform();
    }

    public static void maximizeWindow() {
        if (driver != null) {
            driver.manage().window().maximize();
        } else {
            throw new IllegalStateException("WebDriver is not initialized. Cannot maximize window.");
        }
    }

    public static String getText(By locator) {
        WebElement element = getElement(locator, 10, 1000);
        return element.getText();
    }

    public static void assertElementText(By locator, String expectedText) {
        String actualText = getText(locator);
        if (!actualText.equals(expectedText)) {
            throw new AssertionError("Expected: " + expectedText + ", but got: " + actualText);
        }
    }
}
