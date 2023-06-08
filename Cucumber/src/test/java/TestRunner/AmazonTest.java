package TestRunner;




import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/test/java/AppFeature",
        glue = {"StepDefinitions"},
        plugin = {"pretty","json:target/JSONReports"},
        monochrome = true,
        tags = "@smoketest"

)
public class AmazonTest {

}
