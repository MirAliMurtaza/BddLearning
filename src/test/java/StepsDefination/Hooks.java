package StepsDefination;

import General.GeneralFunction;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Hooks {

    // Runs before all tests
    @BeforeAll
    public static void beforeAll() {
        GeneralFunction.setDriver();  // Initialize WebDriver
    }

    // Runs after all tests
    @AfterAll
    public static void afterAll() {
        GeneralFunction.closeBrowser();  // Close WebDriver
    }
}
