package br.com.webautomationselenium.interactions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import br.com.webautomationselenium.global.Constants;
import br.com.webautomationselenium.pages.LoginPO;
import br.com.webautomationselenium.utils.MetodoUtil;

/**
 * Handles all interactions related to the login process.
 * This class encapsulates the navigation and authentication
 * flow using the Login Page Object.
 */
public class LoginInteractions {

    private MetodoUtil metodoUtil;
    private LoginPO loginPO;

    /**
     * Creates an instance of LoginInteractions.
     *
     * @param driver WebDriver instance used to control the browser.
     */
    public LoginInteractions(WebDriver driver) {
        this.metodoUtil = new MetodoUtil(driver);
        this.loginPO = new LoginPO(driver);
    }

    /**
     * Navigates to the login screen through the "My Account" menu.
     */
    public void navigateToLoginScreen() {
        metodoUtil.waitUntilClickable(loginPO.linkMyAccount);
        loginPO.linkMyAccount.click();

        metodoUtil.waitUntilClickable(loginPO.linkLogin);
        loginPO.linkLogin.click();
    }

    /**
     * Performs the login using the provided credentials and
     * validates if the user was redirected to the account page.
     *
     * @param user     User email.
     * @param password User password.
     * @throws InterruptedException if the thread is interrupted.
     */
    public void performLogin(String user, String password) throws InterruptedException {
        metodoUtil.waitUntilClickable(loginPO.inputEmail);
        metodoUtil.writeInput(loginPO.inputEmail, user);

        metodoUtil.writeInput(loginPO.inputPassword, password);

        loginPO.btnLogin.click();

        assertEquals(
                "Page URL is not as expected! "
                        + "Expected: " + Constants.ACCOUNT_PAGE_URL
                        + " | Actual: " + metodoUtil.getCurrentUrl(),
                Constants.ACCOUNT_PAGE_URL,
                metodoUtil.getCurrentUrl()
        );
    }

    /**
     * Executes the complete login flow:
     * navigation to the login screen and authentication.
     *
     * @param user     User email.
     * @param password User password.
     * @throws InterruptedException if the thread is interrupted.
     */
    public void navigateToLoginAndAuthenticate(String user, String password) throws InterruptedException {
        navigateToLoginScreen();
        performLogin(user, password);
    }
}