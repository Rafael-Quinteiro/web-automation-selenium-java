package br.com.webautomationselenium.interactions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import br.com.webautomationselenium.global.Constants;
import br.com.webautomationselenium.pages.OrderPO;

/**
 * Handles all interactions related to the order and checkout process.
 * This class encapsulates product selection, checkout flow,
 * billing, delivery and order confirmation.
 */
public class OrderInteractions {

    private DriverActions driverActions;
    private OrderPO orderPO;  
    
    /**
     * Creates an instance of OrderInteractions.
     *
     * @param driver WebDriver instance used to control the browser.
     */
    public OrderInteractions(WebDriver driver) {
        this.driverActions = new DriverActions(driver);
        this.orderPO = new OrderPO(driver);
    }

    /**
     * Selects the Desktop category.
     */
    public void selectDesktopCategory() {
        orderPO.linkDesktop.click();
    }

    /**
     * Selects the Mac subcategory.
     */
    public void selectMacSubCategory() {
        driverActions.waitUntilVisible(orderPO.linkMac);
        orderPO.linkMac.click();
    }

    /**
     * Adds a product to the shopping cart and validates success message.
     */
    public void addProductToCart() {
        orderPO.btnAddToCart.click();

        driverActions.waitUntilVisible(orderPO.divAlertMessageSuccess);
        driverActions.getText(orderPO.divAlertMessageSuccess)
                  .contains(Constants.ORDER_SUCCESS_MESSAGE);
    }

    /**
     * Navigates to the checkout screen.
     */
    public void navigateToCheckout() {
        driverActions.waitUntilVisible(orderPO.btnCheckout);
        orderPO.btnCheckout.click();

        driverActions.waitUntilVisible(orderPO.linkCheckout);
        orderPO.linkCheckout.click();

        driverActions.waitUntilVisible(orderPO.divCheckout);
        Assert.assertEquals(
                driverActions.getText(orderPO.divCheckout),
                Constants.CHECKOUT_TEXT
        );
    }

    /**
     * Confirms the billing details using the default address.
     */
    public void confirmBillingDetails() {
        driverActions.waitUntilClickable(orderPO.btnContinueBillingDetails);
        orderPO.btnContinueBillingDetails.click();
    }

    /**
     * Selects the option to insert a new billing address.
     */
    public void selectNewBillingAddress() {
        driverActions.waitUntilClickable(orderPO.btnNewAddressBillingDetails);
        orderPO.btnNewAddressBillingDetails.click();
    }

    /**
     * Fills in the new billing address form and continues.
     *
     * @param firstName    Customer first name.
     * @param lastName     Customer last name.
     * @param company      Company name.
     * @param address1     Primary address.
     * @param address2     Secondary address.
     * @param city         City name.
     * @param postCode     Postal code.
     * @param country      Country name.
     * @param regionState  State or region.
     * @throws InterruptedException if the thread is interrupted.
     */
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

        driverActions.waitUntilClickable(orderPO.inputFirstName);
        driverActions.writeInput(orderPO.inputFirstName, firstName);

        driverActions.writeInput(orderPO.inputLastName, lastName);
        driverActions.writeInput(orderPO.inputCompany, company);
        driverActions.writeInput(orderPO.inputAddress1, address1);
        driverActions.writeInput(orderPO.inputAddress2, address2);
        driverActions.writeInput(orderPO.inputCity, city);
        driverActions.writeInput(orderPO.inputPostCode, postCode);

        driverActions.typeLetterByLetter(country, orderPO.inputCountry, 500);
        driverActions.typeLetterByLetter(regionState, orderPO.inputRegionState, 500);
        
        driverActions.scrollToElement(orderPO.btnContinueBillingDetails);
        orderPO.btnContinueBillingDetails.click();
    }

    /**
     * Confirms the delivery details step.
     */
    public void confirmDeliveryDetails() {
        driverActions.waitUntilClickable(orderPO.btnContinueDeliveryDetails);
        orderPO.btnContinueDeliveryDetails.click();
    }

    /**
     * Confirms the delivery method.
     */
    public void confirmDeliveryMethod() {
        driverActions.waitUntilClickable(orderPO.btnContinueDeliveryMethod);
        orderPO.btnContinueDeliveryMethod.click();
    }

    /**
     * Selects the payment method and accepts the terms and conditions.
     */
    public void selectPaymentMethod() {
        driverActions.waitUntilClickable(orderPO.checkTermosConditions);
        orderPO.checkTermosConditions.click();

        orderPO.btnPaymentMethod.click();
    }

    /**
     * Confirms the order and validates the success message.
     */
    public void confirmOrder() {
        driverActions.waitUntilInvisible(orderPO.divBankTransferInstructions);

        driverActions.waitUntilClickable(orderPO.btnConfirmOrder);
        orderPO.btnConfirmOrder.click(); 

        driverActions.waitUntilVisible(orderPO.divOrderSuccess);
        driverActions.getText(orderPO.divOrderSuccess)
                  .contains(Constants.ORDER_SUCCESS_MESSAGE);
    }
}