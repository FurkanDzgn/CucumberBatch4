package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\MyApp\\myAppDatabseValidation.feature",
        glue = "StepDefinitions",
        dryRun = false
 //       tags = ""
)
public class DBRunner {
}
