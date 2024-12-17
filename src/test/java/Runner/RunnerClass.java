package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"StepsDefination"},
        plugin = {"pretty", "html:target/cucumber"}
)
public class RunnerClass extends AbstractTestNGCucumberTests {
}
