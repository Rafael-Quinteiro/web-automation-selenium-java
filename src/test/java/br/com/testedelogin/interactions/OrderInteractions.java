package br.com.testedelogin.interactions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import br.com.testedelogin.global.Constants;
import br.com.testedelogin.pages.OrderPO;
import br.com.testedelogin.utils.MetodoUtil;

/**
 * Handles all interactions related to the order and checkout process.
 * This class encapsulates product selection, checkout flow,
 * billing, delivery and order confirmation.
 */
public class OrderInteractions {

    private MetodoUtil metodoUtil;
    private OrderPO orderPO;  
    
    /**
     * Creates an instance of OrderInteractions.
     *
     * @param driver WebDriver instance used to control the browser.
     */
    public OrderInteractions(WebDriver driver) {
        this.metodoUtil = new MetodoUtil(driver);
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
        metodoUtil.waitUntilVisible(orderPO.linkMac);
        orderPO.linkMac.click();
    }

    /**
     * Adds a product to the shopping cart and validates success message.
     */
    public void addProductToCart() {
        orderPO.btnAddToCart.click();

        metodoUtil.waitUntilVisible(orderPO.divAlertMessageSuccess);
        metodoUtil.getText(orderPO.divAlertMessageSuccess)
                  .contains(Constants.ORDER_SUCCESS_MESSAGE);
    }

    /**
     * Navigates to the checkout screen.
     */
    public void navigateToCheckout() {
        metodoUtil.waitUntilVisible(orderPO.btnCheckout);
        orderPO.btnCheckout.click();

        metodoUtil.waitUntilVisible(orderPO.linkCheckout);
        orderPO.linkCheckout.click();

        metodoUtil.waitUntilVisible(orderPO.divCheckout);
        Assert.assertEquals(
                metodoUtil.getText(orderPO.divCheckout),
                Constants.CHECKOUT_TEXT
        );
    }

    /**
     * Confirms the billing details using the default address.
     */
    public void confirmBillingDetails() {
        metodoUtil.waitUntilClickable(orderPO.btnContinueBillingDetails);
        orderPO.btnContinueBillingDetails.click();
    }

    /**
     * Selects the option to insert a new billing address.
     */
    public void selectNewBillingAddress() {
        metodoUtil.waitUntilClickable(orderPO.btnNewAddressBillingDetails);
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

        metodoUtil.waitUntilClickable(orderPO.inputFirstName);
        metodoUtil.writeInput(orderPO.inputFirstName, firstName);

        metodoUtil.writeInput(orderPO.inputLastName, lastName);
        metodoUtil.writeInput(orderPO.inputCompany, company);
        metodoUtil.writeInput(orderPO.inputAddress1, address1);
        metodoUtil.writeInput(orderPO.inputAddress2, address2);
        metodoUtil.writeInput(orderPO.inputCity, city);
        metodoUtil.writeInput(orderPO.inputPostCode, postCode);

        metodoUtil.typeLetterByLetter(country, orderPO.inputCountry, 500);
        metodoUtil.typeLetterByLetter(regionState, orderPO.inputRegionState, 500);
        
        metodoUtil.scrollToElement(orderPO.btnContinueBillingDetails);
        orderPO.btnContinueBillingDetails.click();
    }

    /**
     * Confirms the delivery details step.
     */
    public void confirmDeliveryDetails() {
        metodoUtil.waitUntilClickable(orderPO.btnContinueDeliveryDetails);
        orderPO.btnContinueDeliveryDetails.click();
    }

    /**
     * Confirms the delivery method.
     */
    public void confirmDeliveryMethod() {
        metodoUtil.waitUntilClickable(orderPO.btnContinueDeliveryMethod);
        orderPO.btnContinueDeliveryMethod.click();
    }

    /**
     * Selects the payment method and accepts the terms and conditions.
     */
    public void selectPaymentMethod() {
        metodoUtil.waitUntilClickable(orderPO.checkTermosConditions);
        orderPO.checkTermosConditions.click();

        orderPO.btnPaymentMethod.click();
    }

    /**
     * Confirms the order and validates the success message.
     */
    public void confirmOrder() {
        metodoUtil.waitUntilInvisible(orderPO.divBankTransferInstructions);

        metodoUtil.waitUntilClickable(orderPO.btnConfirmOrder);
        orderPO.btnConfirmOrder.click(); 

        metodoUtil.waitUntilVisible(orderPO.divOrderSuccess);
        metodoUtil.getText(orderPO.divOrderSuccess)
                  .contains(Constants.ORDER_SUCCESS_MESSAGE);
    }
}