package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\com.WebOrder\\NewOrderDataTable.feature", // --> IllegalArgumentException
        glue = "StepDefinitions",// \com\weborder  // --> UndefinedStepException
        monochrome = false,
        dryRun = false
)

public class WebOrderRegressionRunner {
}
