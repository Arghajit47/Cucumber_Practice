package GreenCommuteTestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/test/java/AppFeature/GreenCommute1.feature",
        glue = {"StepDefinitions"},
        plugin = {"pretty","json:target/JSONReports"},
        monochrome = true


)
public class TestRunner {
}
