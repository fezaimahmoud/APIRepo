package StepDefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // Static block to initialize the ExtentReports instance
    static {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("target/extent-report.html");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Tester", "Your Name");
    }

    @Before
    public void initializeTest(Scenario scenario) {
        test.set(extent.createTest(scenario.getName()));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            test.get().fail("Scenario failed");
        } else {
            test.get().pass("Scenario passed");
        }
        extent.flush();
    }

    public static ExtentTest getTest() {
        return test.get();
    }
}
