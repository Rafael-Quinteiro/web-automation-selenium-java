package br.com.webautomationselenium.tests;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.aventstack.extentreports.ExtentTest;

import br.com.webautomationselenium.base.BaseTest;
import br.com.webautomationselenium.builders.DataFormsBuilder;
import br.com.webautomationselenium.config.ConfigManager;
import br.com.webautomationselenium.data.DataForms;
import br.com.webautomationselenium.global.Constants;
import br.com.webautomationselenium.interactions.LoginInteractions;
import br.com.webautomationselenium.interactions.OrderInteractions;
import br.com.webautomationselenium.report.SparkReporter;
import br.com.webautomationselenium.suits.AllSmokeTests;
import br.com.webautomationselenium.utils.Utils;

/**
 * Test class responsible for validating the order flow.
 */
public class OrderTest extends BaseTest {

    private OrderInteractions orderInteractions;
    private LoginInteractions loginInteractions;
    private DataFormsBuilder dataFormsBuilder;
    private DataForms dataForms;

    private static SparkReporter sparkReporter;

    /**
     * Initializes test instances and performs login before each test execution.
     */
    @Before
    public void setUpTest() throws InterruptedException {

        orderInteractions = new OrderInteractions(driver);
        loginInteractions = new LoginInteractions(driver);
        sparkReporter = new SparkReporter(driver);

        dataFormsBuilder = new DataFormsBuilder();
        dataForms = dataFormsBuilder.build();

        setReportTitle(Constants.ORDER_ROUTINE_DESCRIPTION);

        loginInteractions.navigateToLoginAndAuthenticate(
            ConfigManager.getLoginUser(),
            ConfigManager.getLoginPassword()
        );
    }

    /**
     * Generates and moves the execution report after all tests
     * in this class have finished.
     *
     * @throws IOException In case of I/O errors when handling the report file.
     */
    @AfterClass
    public static void generateTestReport() throws IOException {
        new Utils()
            .moveHtmlReportToDirectory(
                Constants.ORDER_REPORT_PATH,
                Constants.ORDER_ROUTINE_DESCRIPTION
            );
    }

    /* ===========================
       ===== FLOW ACTIONS ========
       =========================== */

    public void selectDesktopCategory() {
        orderInteractions.selectDesktopCategory();
    }

    public void selectMacSubCategory() {
        orderInteractions.selectMacSubCategory();
    }

    public void addProductToCart() {
        orderInteractions.addProductToCart();
    }

    public void navigateToCheckout() {
        orderInteractions.navigateToCheckout();
    }

    public void confirmBillingDetails() {
        orderInteractions.confirmBillingDetails();
    }

    public void confirmDeliveryDetails() {
        orderInteractions.confirmDeliveryDetails();
    }

    public void confirmDeliveryMethod() {
        orderInteractions.confirmDeliveryMethod();
    }

    public void selectPaymentMethod() {
        orderInteractions.selectPaymentMethod();
    }

    public void confirmOrder() {
        orderInteractions.confirmOrder();
    }

    public void selectNewBillingAddress() {
        orderInteractions.selectNewBillingAddress();
    }

    public void fillNewBillingAddress(
        String firstName,
        String lastName,
        String company,
        String address1,
        String address2,
        String city,
        String postCode,
        String country,
        String regionState
    ) throws InterruptedException {

        orderInteractions.fillNewBillingAddress(
            firstName,
            lastName,
            company,
            address1,
            address2,
            city,
            postCode,
            country,
            regionState
        );
    }

    /* ===========================
       ========= TESTS ===========
       =========================== */

    /**
     * TC001 - Create order using registered address.
     */
    @Test
    @Category({AllSmokeTests.class})
    public void TC001_should_Create_Order_With_Registered_Address() {

        String testDescription = "TC001 - Should create an order using the registered address";
        String screenshotName = this.getClass().getSimpleName()
                + testDescription.substring(0, 5);

        ExtentTest test = extent.createTest(testDescription);

        try {
            selectDesktopCategory();
            selectMacSubCategory();
            addProductToCart();
            navigateToCheckout();
            confirmBillingDetails();
            confirmDeliveryDetails();
            confirmDeliveryMethod();
            selectPaymentMethod();
            confirmOrder();

            sparkReporter.markTestAsPassed(test);

        } catch (Throwable t) {
            sparkReporter.finalizeFailedTest(test, screenshotName, t);
        }
    }

    /**
     * TC002 - Create order using default address.
     */
    @Test
    @Category({AllSmokeTests.class})
    public void TC002_should_Create_Order_With_Default_Address() {

        String testDescription = "TC002 - Should create an order using the default address";
        String screenshotName = this.getClass().getSimpleName()
                + testDescription.substring(0, 5);

        ExtentTest test = extent.createTest(testDescription);

        try {
            selectDesktopCategory();
            selectMacSubCategory();
            addProductToCart();
            navigateToCheckout();

            selectNewBillingAddress();

            orderInteractions.fillNewBillingAddress(
                dataForms.getFirstName(),
                dataForms.getLastName(),
                dataForms.getCompany(),
                dataForms.getAddress1(),
                dataForms.getAddress2(),
                dataForms.getCity(),
                dataForms.getPostCode(),
                dataForms.getCountry(),
                dataForms.getRegionState()
            );

            confirmDeliveryDetails();
            confirmDeliveryMethod();
            selectPaymentMethod();
            confirmOrder();

            sparkReporter.markTestAsPassed(test);

        } catch (Throwable t) {
            sparkReporter.finalizeFailedTest(test, screenshotName, t);
        }
    }

    /**
     * TC003 - Create order using new billing address.
     */
    @Test
    @Category({AllSmokeTests.class})
    public void TC003_should_Create_Order_With_New_AddressData() {

        String testDescription = "TC003 - Should create an order using new address data";
        String screenshotName = this.getClass().getSimpleName()
                + testDescription.substring(0, 5);

        ExtentTest test = extent.createTest(testDescription);

        try {
            selectDesktopCategory();
            selectMacSubCategory();
            addProductToCart();
            navigateToCheckout();

            selectNewBillingAddress();

            fillNewBillingAddress(
                dataFormsBuilder.withFirstName("Novo Nome").build().getFirstName(),
                dataFormsBuilder.withLastName("Novo Sobrenome").build().getLastName(),
                dataFormsBuilder.withCompany("").build().getCompany(),
                dataFormsBuilder.withAddress1("Rua Nova 123").build().getAddress1(),
                dataFormsBuilder.withAddress2("").build().getAddress2(),
                dataFormsBuilder.withCity("Cidade Nova").build().getCity(),
                dataFormsBuilder.withPostCode("12345-678").build().getPostCode(),
                dataFormsBuilder.withCountry("Brazil").build().getCountry(),
                dataFormsBuilder.withRegionState("São Paulo").build().getRegionState()
            );

            confirmDeliveryDetails();
            confirmDeliveryMethod();
            selectPaymentMethod();
            confirmOrder();

            sparkReporter.markTestAsPassed(test);

        } catch (Throwable t) {
            sparkReporter.finalizeFailedTest(test, screenshotName, t);
        }
    }
}