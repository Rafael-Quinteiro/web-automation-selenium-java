package br.com.webautomationselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object representing the Login page of the application.
 * This class maps all web elements required to perform login actions.
 */
public class LoginPO extends BasePO {

    @FindBy(css = "#top-links > ul > li.dropdown > a")
    public WebElement linkMyAccount;

    @FindBy(css = "#top-links > ul > li.dropdown.open > ul > li:nth-child(2) > a")
    public WebElement linkLogin;

    @FindBy(id = "input-email")
    public WebElement inputEmail;

    @FindBy(id = "input-password")
    public WebElement inputPassword;

    @FindBy(css = "#content > div > div:nth-child(2) > div > form > input")
    public WebElement btnLogin;

    /**
     * Creates an instance of LoginPO and initializes the web elements.
     *
     * @param driver WebDriver instance used to interact with the browser.
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }
}