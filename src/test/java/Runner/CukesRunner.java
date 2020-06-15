package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // --> its coming from junit
@CucumberOptions(
        // "src\\test\\resources\\com.WebOrder\\Logintest.feature",
        //src\test\resources
        features={"src\\test\\resources\\com.Etsy\\ScenarioOutlineEtsy.feature"}, //\com.duckduckgo\SearchBoxTest.feature
        glue="StepDefinitions", // it should be empty instead of StepDefinitions
        monochrome=false,
        dryRun = false,
        tags = "@etsyOutline" // or @tech  ///    @etsy and @tt
        // @smoke and not @techtorial2
)

public class CukesRunner {
}
