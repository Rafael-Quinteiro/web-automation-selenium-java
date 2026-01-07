package br.com.webautomationselenium.report;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import br.com.webautomationselenium.global.Constants;
import br.com.webautomationselenium.interactions.DriverActions;

/**
 * Utility class responsible for handling test reporting
 * and screenshot capture using Extent Reports.
 */
public class SparkReporter {

    private WebDriver driver;
    private static DriverActions driverActions;

    /**
     * Sets the WebDriver instance.
     *
     * @param driver WebDriver used in the test execution.
     */
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Creates an instance of SparkReporterUtil.
     *
     * @param driver WebDriver used during test execution.
     */
    public SparkReporter(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Logs a successful test execution.
     *
     * @param test Current test instance.
     */
    public void logTestSuccess(ExtentTest test) {
        test.log(Status.PASS, "Test executed successfully!");
    }

    /**
     * Logs a failure with an exception.
     *
     * @param test Current test instance.
     * @param throwable Exception thrown during test execution.
     */
    public void logTestFailure(ExtentTest test, Throwable throwable) {
        test.log(Status.FAIL, throwable);
    }

    /**
     * Logs an execution error.
     *
     * @param test Current test instance.
     * @param throwable Exception thrown during test execution.
     */
    public void logTestError(ExtentTest test, Throwable throwable) {
        test.log(Status.FAIL, throwable);
    }

    /**
     * Logs a failure related to an incorrect number of files.
     *
     * @param test Current test instance.
     * @param failureMessage Custom failure message.
     */
    public void logFileCountFailure(ExtentTest test, String failureMessage) {
        test.log(Status.FAIL, failureMessage);
    }

    /**
     * Logs an informational message about file count validation.
     *
     * @param test Current test instance.
     * @param successMessage Custom success message.
     */
    public void logFileCountInfo(ExtentTest test, String successMessage) {
        test.log(Status.INFO, successMessage);
    }

    /**
     * Logs a skipped test.
     *
     * @param test Current test instance.
     */
    public void logTestSkipped(ExtentTest test) {
        test.log(Status.SKIP, "Test skipped.");
    }

    /**
     * Visually marks the test as successful using green highlight.
     *
     * @param test Current test instance.
     */
    public void markTestAsPassed(ExtentTest test) {
        test.log(Status.PASS,
                MarkupHelper.createLabel("Test executed successfully!", ExtentColor.GREEN));
    }

    /**
     * Visually marks the test as failed using red highlight.
     *
     * @param test Current test instance.
     */
    public void markTestAsFailed(ExtentTest test) {
        test.log(Status.FAIL,
                MarkupHelper.createLabel("Test execution failed!", ExtentColor.RED));
    }

    /**
     * Creates the screenshot folder if it does not exist.
     */
    public void createScreenshotDirectory() {
        File directory = new File(Constants.SCREENSHOT_FOLDER_PATH);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    /**
     * Finalizes the test as failed by logging the error
     * and attaching the screenshot to the report.
     *
     * @param test Test instance.
     * @param testDescription Description used to name the screenshot file.
     * @param throwable Exception that caused the failure.
     */
    public void finalizeFailedTest(
            ExtentTest test,
            String testDescription,
            Throwable throwable) {

        driverActions = new DriverActions(driver);

        String path = Constants.SCREENSHOT_FOLDER_PATH;

        driverActions.takeScreenshot(path);

        markTestAsFailed(test);
        logTestFailure(test, throwable);

        test.fail(
            MediaEntityBuilder
                .createScreenCaptureFromPath(
                        driverActions.takeScreenshot(path))
                .build()
        );
    }
}