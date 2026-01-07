package br.com.webautomationselenium.base;

import java.util.logging.Level;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import br.com.webautomationselenium.config.ConfigManager;
import br.com.webautomationselenium.report.SparkReporter;
import br.com.webautomationselenium.utils.Utils;

/**
 * Base class for all test classes in the project.
 * All tests must extend this class to inherit browser
 * configuration, reporting and execution setup.
 */
public abstract class BaseTest {

    protected static WebDriver driver;
    protected static ChromeOptions options;
    protected static ExtentReports extent;
    protected static ExtentSparkReporter spark;
    protected static LoggingPreferences logPrefs;
    protected static SparkReporter sparkReporter;

    /**
     * Initializes all shared test configurations.
     * This method is executed once before any test runs.
     */
    @BeforeClass
    public static void setUpTestSuite() {

        // REPORT CONFIGURATION (RUNS ONCE)
        sparkReporter = new SparkReporter(null);
        sparkReporter.createScreenshotDirectory();

        extent = new ExtentReports();

        spark = new ExtentSparkReporter(Utils.getHtmlReportName());
        spark.config().setTheme(Theme.DARK);
        extent.attachReporter(spark);

        // CHROME LOGGING CONFIGURATION (RUNS ONCE)
        logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
    }

    /**
     * Opens the browser and prepares the test environment.
     * This method is executed before each test.
     */
    @Before
    public void openBrowser() {

        // CHROME OPTIONS SETUP
        options = new ChromeOptions();
        options.addArguments("--start-maximized", "--incognito" /*, "--headless" */);
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        // REGISTER CHROME LOGS (SELENIUM 4)
        options.setCapability("goog:loggingPrefs", logPrefs);

        // START THE BROWSER
        driver = new ChromeDriver(options);

        // BIND DRIVER TO REPORTER
        sparkReporter.setDriver(driver);

        // CLEAR COOKIES AND OPEN BASE URL
        driver.manage().deleteAllCookies();
        driver.get(ConfigManager.getBaseLoginUrl());
    }

    /**
     * Closes the browser after each test execution.
     */
    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Saves and finalizes the ExtentReports execution.
     */
    @After
    public void flushReports() {
        extent.flush();
    }

    /**
     * Sets the document title of the test report.
     *
     * @param testDescription Description of the tested routine.
     */
    protected void setReportTitle(String testDescription) {
        spark.config().setDocumentTitle(testDescription);
    }
}