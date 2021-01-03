package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"gluecode"},
        plugin = {"pretty",
            "html:target/HTMLReports/report.html"},
        monochrome = true,
        tags = "@JobInterview"
)

public class TestSuiteRunner extends AbstractTestNGCucumberTests {

}
