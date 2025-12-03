package br.com.testedelogin.tests;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.testedelogin.config.ConfigManager;
import br.com.testedelogin.core.BaseTest;
import br.com.testedelogin.global.Constants;
import br.com.testedelogin.interactions.LoginInteractions;
import br.com.testedelogin.report.SparkReporterUtil;
import br.com.testedelogin.utils.MetodoBaseUtil;

/**
 * Test class responsible for validating the login functionality.
 */
public class LoginTest extends BaseTest {

    private LoginInteractions loginInteractions;
    private SparkReporterUtil sparkReporterUtil;

    /**
     * Initializes test instances before each test execution.
     */
    @Before
    public void setUpTest() {
        loginInteractions = new LoginInteractions(driver);
        sparkReporterUtil = new SparkReporterUtil(driver);
        setReportTitle(Constants.LOGIN_ROUTINE_DESCRIPTION);
    }

    /**
     * Generates and moves the execution report after all tests
     * in this class have finished.
     *
     * @throws IOException In case of I/O errors when handling the report file.
     */
    @AfterClass
    public static void generateTestReport() throws IOException {
        new MetodoBaseUtil(driver)
            .moveHtmlReportToDirectory(
                Constants.LOGIN_REPORT_PATH, 
                Constants.LOGIN_ROUTINE_DESCRIPTION
            );
    }

    /* ===========================
       ===== FLOW ACTIONS ========
       =========================== */

    /**
     * Navigates to the login screen.
     */
    public void navigateToLoginPage() {
        loginInteractions.navigateToLoginScreen();
    }

    /**
     * Navigates to the login screen and performs authentication.
     *
     * @param user     User login.
     * @param password User password.
     * @throws InterruptedException If the thread execution is interrupted.
     */
    public void navigateToLoginAndAuthenticate(String user, String password)
            throws InterruptedException {
        loginInteractions.navigateToLoginAndAuthenticate(user, password);
    }

    /* ===========================
       ========= TESTS ===========
       =========================== */

    /**
     * Test Case: TC001 - Perform login successfully.
     */
    @Test
    public void TC001_should_Login_Successfully() {

        String testDescription = "TC001 - Should successfully log in";
        String screenshotName = this.getClass().getSimpleName()
                + testDescription.substring(0, 5);

        ExtentTest test = extent.createTest(testDescription);

        try {
            navigateToLoginPage();

            navigateToLoginAndAuthenticate(
                ConfigManager.getLoginUser(),
                ConfigManager.getLoginPassword()
            );

            sparkReporterUtil.markTestAsPassed(test);

        } catch (Throwable t) {
            sparkReporterUtil.finalizeFailedTest(test, screenshotName, t);
        }
    }
}