package br.com.webautomationselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Base class for all Page Objects in the project.
 * Every new Page Object must extend this class
 * to inherit the WebDriver instance and PageFactory initialization.
 */
public abstract class BasePO {
    
    /**
     * WebDriver instance shared by all test pages.
     */
    protected WebDriver driver;

    /**
     * Constructor responsible for initializing the PageFactory elements.
     *
     * @param driver WebDriver instance used to interact with the browser.
     */
    protected BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}