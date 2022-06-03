
package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "//Users//MohanrajVaratharaj//Downloads//CucumberwithSelenium//Features//login.feature",
glue="stepDefinitions",
dryRun = true,
plugin={"html:test-output"})

public class testRunner {
}

