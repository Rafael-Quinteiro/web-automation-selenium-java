package br.com.webautomationselenium.utils;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.webautomationselenium.config.ConfigManager;

/**
 * Utility class responsible for WebDriver interaction operations.
 */
public class MetodoUtil {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    /**
     * Constructor.
     * 
     * @param driver WebDriver instance
     */
    public MetodoUtil(WebDriver driver) {
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