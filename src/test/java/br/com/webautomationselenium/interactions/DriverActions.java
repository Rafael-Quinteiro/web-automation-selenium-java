package br.com.webautomationselenium.interactions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.webautomationselenium.config.ConfigManager;
import br.com.webautomationselenium.global.Constants;

/**
 * Utility class responsible for WebDriver interaction operations.
 */
public class DriverActions {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    /**
     * Constructor.
     * 
     * @param driver WebDriver instance
     */
    public DriverActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(ConfigManager.getMaxWaitTime()));
    }

    /* ============================
     * INPUT INTERACTIONS
     * ============================ */

    public void writeInput(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void writeAndTab(WebElement element, String text) {
        element.clear();
        element.sendKeys(text, Keys.TAB);
    }

    public void typeLetterByLetter(String text, WebElement element, long delayMs)
            throws InterruptedException {

        for (char letter : text.toCharArray()) {
            element.sendKeys(String.valueOf(letter));
            Thread.sleep(delayMs);
        }
    }

    public void clearInput(WebElement element) {
        element.clear();
    }

    /* ============================
     * ACTIONS
     * ============================ */

    public void scrollToElement(WebElement element) {
        new Actions(driver)
                .scrollToElement(element)
                .perform();
    }

    /* ============================
     * SCREENSHOT
     * ============================ */

    /**
     * Takes a screenshot and saves it in the default screenshot folder.
     *
     * @param testDescription Description used to name the screenshot file
     * @return Absolute path of the saved screenshot
     */
    public String takeScreenshot(String testDescription) {
        File destinationFile = new File(
                Constants.SCREENSHOT_FOLDER_PATH + testDescription + ".png");

        File sourceFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        try {
            FileHandler.copy(sourceFile, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException("Error while saving screenshot", e);
        }

        return destinationFile.getAbsolutePath();
    }

    /* ============================
     * GETTERS
     * ============================ */

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /* ============================
     * WAITS (VISIBILITY / CLICK)
     * ============================ */

    public WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Boolean waitUntilInvisible(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /* ============================
     * EXPLICIT WAIT (WHEN REALLY NEEDED)
     * ============================ */

    public void explicitSleep(long milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }
}