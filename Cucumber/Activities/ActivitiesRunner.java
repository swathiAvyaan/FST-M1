package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        glue = {"stepDefinitions"},
        tags = "@activity1 and @activity2 and @activity3 and @activity4 and @activity5",
        plugin = {"html: test-reports"},
        monochrome = true
)

public class ActivitiesRunner {
    //empty
}